package assembly;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import antlr.generatedClasses.GrammaireParser;
import descripteurDeClasse.DescripteurDeClasse;
import objet.AffectationStatique;
import objet.ElementObjet;
import org.antlr.runtime.tree.Tree;
import tds.Element;
import tds.ElementMethod;
import tds.ElementVariable;
import tds.Pair;
import tds.TDS;
import tdt.TDT;

public class TasASM {
	public static FileWriter writer;
	public static ArrayList<DescripteurDeClasse> listeDdc;
	public static TDT tdt;
	public static String initAdressesMethodes = "initAdressesMethodes_\n";
	private static boolean isBeingCasted = false;


	//adresse de l'instance dans R1 -> pourra etre affecte plus facilement à des attributs
	public static void allocationObjet(String type) {
		DescripteurDeClasse ddc = get(type);
		String bloc = "//debut instanciation------------\n"+
				"	LDW R1, #STACK_ADRS\n"+
				"	ADQ -"+(getDeplacement(type))+", R1\n"+
				"	STW R1, (HP)\n"+
				" 	LDW R1, HP\n"+//debut de l'instance pour plus tard
				"	ADQ "+ddc.taille+", HP\n";
		try {
			writer.write(bloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//adresse de la string dans R1 -> pourra etre affecte plus facilement à des attributs
	public static void allocationString(String str, boolean onlystore, boolean inConcat) throws IOException {
		String bloc = "";

		if(!inConcat){
			bloc = "//debut stockage string----------\n"
					+ "	LDW R1, HP\n";
		}

		if(inConcat && onlystore){
			bloc += "\tLDW R9, #0x0000\n" +
					"\tSUB R9, R10, R9\n"+
					"\tJEQ #20 \n" +
					"\tLDW R9, #0x0020\n" +
					"\tLDW R8, #ASCII_OFFSET\n" +
					"\tMUL R8, R10, R10\n" +
					"\tADD R10, R9, R9\n" +

					"\tLDW R0, R9\n" +
					"\tSTW R0, (HP)\n" +
					"\tADQ 2, HP\n";
		}
		String hex="";
		str = str.substring(1, str.length()-1);
		str = str.replace("\\n", "\n");
		for(int i=0; i<str.length();i++) {
			if(onlystore){
				if(i%2 == 0)
					hex = String.format("%02x", (int) str.charAt(i));
				else {
					hex += String.format("%02x", (int) str.charAt(i));
					bloc+="	LDW R0, #0x"+hex+"\n"+
							"	STW R0, (HP)\n"+
							"	ADQ 2, HP\n";
				}
			}
			else{
				if(i%2==0)
					hex = String.format("%02x", (int) str.charAt(i));
				else {
					hex += String.format("%02x", (int) str.charAt(i));
					bloc+="	LDW R0, #0x"+hex+"\n"+
							"	STW R0, (HP)\n"+
							"	ADQ 2, HP\n";
				}
			}
		}
		if(onlystore == false){
			if(str.length()%2==0) {
				bloc+="	LDW R0, #0x0000\n"+
						"	STW R0, (HP)\n"+
						"	ADQ 2, HP\n";
			}
			else {
				hex += "00";
				bloc+="	LDW R0, #0x"+hex+"\n"+
						"	STW R0, (HP)\n"+
						"	ADQ 2, HP\n";
			}
		}

		try {
			writer.write(bloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(str.length()%2==0) {
				hex = "0000";
			}
			else{
				hex = "00" + hex;
			}

			if(onlystore == true){
				writer.write("\tLDW R10, #0x" + hex + "\n");
			}
		}

	}

	//met l'adresse de x.[...].attribut dans R0
	//si on veut changer la valeur on doit renvoyer l'adresse de l'attribut plutot que la valeur
	//donc adresse == true si et seulement si on veut changer la valeur d'un attribut
	public static void attributDansR0(TDS tds, ElementObjet obj, int etiquette, boolean adresse) throws IOException {
		writer.write("//debut Attribut dans R0-----\n");
		String type;
		//legacy code; normalement la nature est forcement Objet ou Static maintenant
		if(obj.getNature().contentEquals("Integer")) {
			writer.write("	LDW R0, #"+obj.getNom()+"\n");
			type = "Integer";
			for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
				type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, false, adresse);
			}
		}
		//legacy code; normalement la nature est forcement Objet ou Static maintenant
		else if(obj.getNature().contentEquals("String")) {
			type = "String";
			allocationString(obj.getNom(), false, false);
			writer.write("	LDW R0, R1\n");
			
		}
		else if(obj.getNature().contentEquals("Static")) {
			type = obj.getNom();
			DescripteurDeClasse ddc = get(type);
			writer.write("	LDW R0, #STACK_ADRS\n"
					+ "	ADQ -"+getDeplacement(ddc.type)+", R0\n");
			for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
				type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, false, adresse);
			}
		}
		else {
			if(etiquette != -1){
				writer.write(ToolsASM.link()+
						"while" + etiquette + "\n");
			}
			if(obj.getNom().contentEquals("this")) {
				//si on arrive, c'est que l'ElementObjet est un attribut ou une fonction
				//on doit mettre l'instance (R11) dans R0 avant de parcourir les parametres
				type = obj.getType();
				writer.write("	LDW R0, R11\n");
				for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
					type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, obj.getHerite()&&i==0, adresse);
				}
			}
			else if(obj.getHerite()) {//on met le type de la super classe
					type = tdt.getType(obj.getType()).getTypeHeritage();
					writer.write("	LDW R0, R11\n");
					for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
						type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, obj.getHerite()&&i==0, adresse);
					}
				
			}
			else {
				Pair<Element, Integer>pair = tds.getByName(obj.getNom(), GrammaireParser.VARIABLE, false);
				if(pair != null) {
					writer.write(ToolsASM.getVariableInR0(tds, obj.getNom()));
					//pas une variable par exmple 12 ou "test" dans une fonction
					Element elem = pair.getFirst(); //pour simplifier la lecture
					//pour chaque attribut
					type = elem.getType();
					for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
						type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, obj.getHerite()&&i==0, adresse);
					}
				}
				
			}	
			
		}
		writer.write("//fin Attribut dans R0-------\n");
	}
	private static String attributDansR0MoveParam(ElementObjet obj, TDS tds, String type, boolean last, boolean herite, boolean adresse) throws IOException {
		//si c'est un cast il faut recuperer le descripteur de classe correspondant pour l'utiliser sur le prochain param 
		if(obj.getNature().contentEquals("Cast")) {
			for(int i=0;i<obj.getListeAttributOuParam().size();i++) {
				
				type = attributDansR0MoveParam(obj.getListeAttributOuParam().get(i), tds, type, i==obj.getListeAttributOuParam().size()-1, obj.getHerite()&&i==0, adresse&&last);
			}
			//c'est le type dans lequel on cast, donc le type qui va atre utilise pour chercher le descripteur de classe au prochain attribut
			type = obj.getNom();
			isBeingCasted = true;
			
		}
		else {
			DescripteurDeClasse ddc = get(type);
			//si c'est un attribut on cherche le deplacement dans le descripteur de classe en java
			if(obj.getNature().contentEquals("Attribut")) {
				ElementVariable e = ddc.getAttribut(obj.getNom());
				type = e.getType();
				//si c'est un attribut statique on doit aller le chercher dans le descripteur de classe et non dans l'instance
				//le descripteur n'est pas forcement celui de la classe actuelle on va donc le chercher de facon statique grave au nom du type
				if(e.getStatique()) {
					writer.write("	ADQ -"+ddc.getDeplacementAttributStatique(e.getNom())+", R0\n");
				}
				else {
					int depl = ddc.getDeplacementAttribut(obj.getNom());
					writer.write("	ADQ "+depl+", R0\n");
				}
				
				if(!(adresse && last))
					writer.write("	LDW R0, (R0)\n");
			}
			//si c'est une fonction on cherche le deplacement dans le descripteur de classe en ASM
			else {
				if(type.contentEquals("Integer")) {
					//on ne peut pas utiliser initFonction car Integer n'est pas un vrai objet
					writer.write("//debut appel methode "+obj.getNom()+" de "+type+"------\n"
							+ "	ADQ -2, SP\n"
							+ "	STW  R11, (SP)	//sauvegarde R11 sur la pile (n'a d'effet que si on est dans une methode)\n"
							+ "	LDW R11, R0\n"
							+ ToolsASM.appelToString()
							+ "	LDW R11, (SP)	//on recupere R11 qui etait empile\n"
							+ "	ADQ 2, SP\n"
							+ "//fin appel methode "+obj.getNom()+" de "+type+"--------\n");
					type = "String";
				}
				else if(obj.getNom()!=null && (obj.getNom().contentEquals("print")||obj.getNom().contentEquals("println"))){
					Printer p = new Printer(writer);
					writer.write("	LDW R1, R0\n");
					p.addPrintR1(obj.getNom().contentEquals("println"));
					
				}
				else {
					if(obj.getNom()!=null) {
						ElementMethod e = ddc.getMethode(obj.getNom());
						if(e.getStatique())
							initFonction(tds, type, obj, true);
						else
							initFonction(tds, type, obj, isBeingCasted || herite);
					}
					else
						initFonction(tds, type, obj, isBeingCasted || herite);
					if(obj.getNom()!=null)
						type = ddc.getMethode(obj.getNom()).getType();
					//sinon c'est un super constructeur donc le type est le nom de la super classe
					else
						type = tdt.getType(type).getTypeHeritage();
				}
			}
			isBeingCasted = false;
		}
		return type;
	}
	
	public static DescripteurDeClasse get(String type) {
		for(DescripteurDeClasse ddc: listeDdc) {
			if(ddc.type.contentEquals(type))
				return ddc;
		}
		return null;
	}
	//donne le d�placement pour arriver au descripteur de classe du type en param�tre
	public static int getDeplacement(String type) {
		int total = 4;
		for(DescripteurDeClasse ddc: listeDdc) {
			if(ddc.type.contentEquals(type))
				break;
			total+=ddc.tailleDescripteur;
		}
		return total;
	}
	private static ArrayList<Integer> getDeplacementAjoutAdresseMethodes(String type, String methode){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(DescripteurDeClasse ddc: listeDdc) {
			String str = tdt.getTypeMethode(ddc.type, methode);
			if(str!=null)
				if(str.contentEquals(type)) {
					int depl = getDeplacement(ddc.type)+ddc.getDeplacementMethode(methode);
					if(res.isEmpty())
						res.add(-depl);
					else {
						res.add(-depl-res.get(res.size()-1));
					}
				}
		}
		return res;
	}
	public static void ajoutAdressesMethodes(String type, String methode) {
		ArrayList<Integer> listeDeplacement = getDeplacementAjoutAdresseMethodes(type, methode);
		initAdressesMethodes+="	LDW R1, #STACK_ADRS\n";
		for(Integer i: listeDeplacement) {
			initAdressesMethodes += "	LDW R0, #"+type+"_"+methode+"\n"
					+ "	ADQ "+i+", R1\n"
					+ "	STW R0, (R1)\n";
		}
	}
	//ajoute toutes les valeurs des attributs statiques qui ont ete predefinies, attention cependant si on utilise
	//un attribut statique pour en initialise un autre ce sera l'ordre des classes qui dira si c'est possible
	//autrement la valeur 0 est affectee
	public static void ajoutValeurAttributStatique(ArrayList<AffectationStatique> listeAffectationStatique) throws IOException {
		writer.write("initAttributsStatiques_\n");
		for(AffectationStatique as : listeAffectationStatique) {
			
			
		}
	}
	
	
	//R11 doit contenir l'objet qui appelle la methode
	//R11 doit donc avoir ete empile si on appelle une methode depuis une fonction (fait dans attributDansR0)
	//empile les parametres
	public static void initFonction(TDS tds, String type, ElementObjet fonction, boolean isBeingCasted) throws IOException {
		writer.write("//debut appel methode "+(fonction.getNom()==null?type:fonction.getNom())+" de "+type+"----------\n"
				+ "	ADQ -2, SP\n"
				+ "	STW R11, (SP)	//sauvegarde R11 sur la pile (n'a d'effet que si on est dans une methode)\n"
				+ "ADQ -2, SP\n"
				+ "	STW "+RESERVED_REGISTERS.return_function+", (SP)	//sauvegarde R10 sur la pile\n"
				+ "	LDW R11, R0\n");
		
		//si c'est un cast il faut aller chercher le descripteur du type qui est cast� et le mettre dans R11
		if(isBeingCasted)
			writer.write("	LDW R11, #STACK_ADRS	//on va chercher le descripteur de classe\n"
					+ "	ADQ -"+(getDeplacement(type))+", R11\n");
		DescripteurDeClasse ddc = get(type);
		
		//on va chercher tous les parametres et on les empile
		for(ElementObjet param: fonction.getListeAttributOuParam()) {
			if(param.getNature().contentEquals("New")) {
				allocationObjet(param.getNom());
				writer.write("	ADQ -2, SP\n"
						+ "	STW R1, (SP)\n//fin instanciation--------------\n"
						+ "	LDW R0, R1\n");
				initFonction(tds, param.getNom(), param, false);
				
			}
			else {
				if(param.getNature().contentEquals("Static")) {
					TasASM.attributDansR0(tds, param, -1, false);
				}
				else if(param.getNature().contentEquals("Integer"))
					writer.write("	LDW R0, #"+param.getNom()+"\n");
				else if(param.getNature().contentEquals("String")) {
					allocationString(param.getNom(), false, false);
					writer.write("	LDW R0, R1\n"
							+ "//fin stockage string------------\n");

				}
				else if(param.getNature().contentEquals("Operation")) {
					Tree t = param.getTree();
					operation_handler(t, tds,fonction);
				}
				else if(param.getNature().contentEquals("toString")){
					writer.write("//begining : parameter of function is toString\n");
					writer.write("ADQ -2, SP\n" +
							"	STW  R11, (SP)	//sauvegarde R11 sur la pile (n'a d'effet que si on est dans une methode)\n");
					Tree op =  param.getTree().getChild(0).getChild(0);
					if(op.getType() == GrammaireParser.INT){
						writer.write("	LDW R1, #" + op.getText() + "\n");
					}
					if(Arrays.binarySearch(ToolsASM.tab, op.getType()) >= 0){

						operation_handler(op, tds,fonction);
						writer.write("\tLDW R1, R0\n");

					}
					writer.write("\tLDW R11, R1\n");
					writer.write(ToolsASM.appelToString());
					writer.write("LDW R11, (SP)	//on recupere R11 qui etait empile\n" +
							"\tADQ 2, SP\n");
					writer.write("//end : parameter of function is toString\n");
				}
				else {
					//2 cas, si c'est une variable on va simplement la chercher
					//si c'est un objet il faut aller à la valeur pointe par l'attribut qui contient la String/Integer
					//sinon on aurait une variable qui pointe sur un pointeur de String/Integer
					if(param.getNature().contentEquals("Objet")) {
						TasASM.attributDansR0(tds, param, -1, false);
					}
					else {
						writer.write(ToolsASM.getVariableInR0(tds, param.getNom()));
					}

				}
				writer.write("	ADQ -2, SP\n"
						+ "	STW R0, (SP)\n");
			}
			
		}
		//on doit effectuer un JSR a une adresse precise sans avoir le label
		//JSR ne permet pas de faire ceci on doit donc le faire nous meme avec un JEA
		//donc il faut empiler le PC pour avoir l'adresse de retour
		if(isBeingCasted) {
			writer.write("	LDW R0, R11\n");
			//on retourne chercher le R11 qu'on a empiler au cas ou il y ai des this ou super dans la methode appelee
			writer.write("	LDW R11, (SP)"+(2+2*fonction.getListeAttributOuParam().size())+"\n");
		}
		else
			writer.write("	LDW R0, (R11)\n");
		
		writer.write("	ADQ -"+ddc.getDeplacementMethode(fonction.getNom()==null?type:fonction.getNom())+", R0\n"
				+ "	LDW R0, (R0)\n"
				+ "	MPC WR\n"// charge le contenu du PC dans WR
				+ "	ADQ 8, WR\n"//adresse de retour en enlevant les parametres
				+ "	ADQ -2, SP\n" // decremente le pointeur de pile SP
				+ "	STW WR, (SP)\n" // sauvegarde l'adresse de retour sur le sommet de pile
				+ "	JEA (R0)\n"
				+ "	ADQ "+(fonction.getListeAttributOuParam().size()*2)+", SP\n"
				+ "	LDW R0, "+RESERVED_REGISTERS.return_function+"\n"
				+ "	LDW "+RESERVED_REGISTERS.return_function+", (SP)	// on recupere R10 qui etait empile \n"
				+ "	ADQ 2, SP\n"
				+ "	LDW R11, (SP)	//on recupere R11 qui etait empile\n"
				+ "	ADQ 2, SP\n"
				+ "//fin appel methode "+(fonction.getNom()==null?type:fonction.getNom())+" de "+type+"--------\n");
	}


	public static void operation_handler(Tree t, TDS tds,ElementObjet obj) throws IOException {
		if(Arrays.binarySearch(ToolsASM.tab_conditionnal_operators, t.getType()) >= 0){
			String currentClass=obj.getType();
			OperateurCondition c = new OperateurCondition(writer);
			if(t.getType() == 55){ // /
				String R1=c.registre( writer,0,t,tds,currentClass);
				String R2=c.registre( writer,1,t,tds,currentClass);
				c.different(t, R1,R2, writer, -1);
			}
			else if(t.getType() == 56){
				String re1=c.registre( writer,0,t,tds,currentClass);
				String re2=c.registre( writer,1,t,tds,currentClass);
				c.egal(t, re1,re2, writer, -1);
			}
			else if(t.getType() == 54){
				String r1=c.registre( writer,0,t,tds,currentClass);
				String r2=c.registre( writer,1,t,tds,currentClass);
				c.inferieur(t, r1,r2, writer, -1);
			}
			else if(t.getType() == 57){
				String regi1=c.registre( writer,0,t,tds,currentClass);
				String regi2=c.registre( writer,1,t,tds,currentClass);
				c.superieur(t, regi1,regi2, writer, -1);
			}
			else if(t.getType() == 41){
				String reg1=c.registre( writer,0,t,tds,currentClass);
				String reg2=c.registre( writer,1,t,tds,currentClass);
				c.et( writer,reg1,reg2);
			}
			else if(t.getType() == 77){
				String regis1=c.registre( writer,0,t,tds,currentClass);
				String regis2=c.registre( writer,1,t,tds,currentClass);
				c.ou( writer,regis1,regis2);
			}

			writer.write("	LDW R0, R5\n");
		}
		else{
			if(t.getType() == 46){ //+
//				Addition a = new Addition(writer, tds, "R1");
//				a.makeOperation(t.getChild(0), "R1",
//						t.getChild(1), "R2",
//						false);
				new OperateurArithmetique(writer, tds, t, "");

			}
			else if(t.getType() == 45){ //*
//				Multiplication m = new Multiplication(writer,
//						tds,
//						"R1");
//				m.makeOperation(t.getChild(0), "R1",
//						t.getChild(1), "R2",
//						false);
				new OperateurArithmetique(writer, tds, t, "");
			}
			else if(t.getType() == 48) { //-
//				Soustraction s = new Soustraction(writer,
//						tds,
//						"R1");
//				s.makeOperation(t.getChild(0), "R1",
//						t.getChild(1), "R2",
//						false);
				new OperateurArithmetique(writer, tds, t, "");
			}
			else if(t.getType() == 50) { // /
//				Division d = new Division(writer,
//						tds,
//						"R6");
//				d.makeOperation(t.getChild(0), "R1",
//						t.getChild(1), "R2",
//						false);
				new OperateurArithmetique(writer, tds, t, "");
			}
			if(t.getType() == 50){
				writer.write("	LDW R0, R6\n");
			}
			else{
				writer.write("	LDW R0, " + RESERVED_REGISTERS.operations_register_2 + "\n");
			}

		}
	}
}
