package assembly;

import antlr.generatedClasses.GrammaireParser;
import tds.Element;
import tds.Pair;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;

public class ToolsASM {
	//BEWARE THESE TABS MUST ALWAYS BE ORDERED ASC

	public static int[] tab = {17, 41, 45, 46, 48, 50, 54, 55, 56,  57, 77 }; // all operators
	public static int[] tab_conditionnal_operators = {41, 54, 55, 56, 57, 77}; // conditionnal operators


	public static String link() {
		return "	//link-------------\n" +
				"	ADQ -2, SP	\n" +
				"	STW BP, (SP)\n" +
				"	LDW BP, SP\n" +
				"	//fin link---------\n";
	}

	public static String unlink() {
		return "	//unlink-----------\n" +
				"	LDW SP, BP\n" +
				"	LDW BP, (SP)\n" +
				"	ADQ 2, SP\n" +
				"	//fin unlink-------\n";
	}

	public static String RTS() {
		return "	LDW WR, (SP)\n" +
				"	ADQ 2, SP\n" +
				"	JEA (WR)\n";
	}

	//permet de changer une variable en remontant des chainages statiques si necessaire
	//on aurait pu utiliser la fonction getVariableR0 pour eviter de dupliquer le code
	public static String changerVariable(TDS tds, String variable, boolean dansR1, int valeur) {
		Pair<Element, Integer> pair = tds.getByName(variable, GrammaireParser.VARIABLE, false);
		int nbChainageStatique = tds.getImbric() - pair.getSecond();
		String bloc = "";
		if (nbChainageStatique != 0) {
			bloc += ToolsASM.link();
			for (int i = 0; i <= nbChainageStatique; i++) {
				bloc += "	LDW SP, (SP)\n";
			}
			if (dansR1)
				bloc += "	STW R1, (SP)-" + pair.getFirst().getDeplacement() + "\n";
			else
				bloc += "	LDW R0, #" + valeur + "\n" +
						"	STW R0,(SP)-" + pair.getFirst().getDeplacement() + "\n";
			bloc += ToolsASM.unlink();
		} else {
			//pas de chainage
			if (dansR1) {
				bloc += "	STW R1, (BP)-" + pair.getFirst().getDeplacement() + "\n";
			}
			else {
				bloc += "	LDW R0, #" + valeur + "\n" +
						"	STW R0,(BP)-" + pair.getFirst().getDeplacement() + "\n";
			}
		}
		return bloc;
	}

	//met la valeur de la variable dans R0
	//a ne pas utiliser pour des objets ! Il faut utiliser changerAttributTas() pour changer un attribut et attributDansR0() pour get un attribut
	//Ces 2 fonctions font appel a celle-ci
	public static String getVariableInR0(TDS tds, String variable) {
		Pair<Element, Integer> pair = tds.getByName(variable, GrammaireParser.VARIABLE, false);
		int nbChainageStatique = tds.getImbric() - pair.getSecond();
		String bloc = "";
		int dec = pair.getFirst().getDeplacement();
		if (nbChainageStatique != 0) {
			bloc += ToolsASM.link();
			for (int i = 0; i <= nbChainageStatique; i++) {
				bloc += "	LDW SP, (SP)\n";
			}

			bloc += "	LDW R0, (SP)" + (dec < 0 ? (-dec) : "-" + dec) + "\n" +
					ToolsASM.unlink();
		}
		else{
			if(dec<0) {
				bloc +="	LDW R0, ("+(nbChainageStatique!=0?"SP":"BP")+")"+(-dec)+"\n";

			}
			else {
				bloc += "	LDW R0, (" + (nbChainageStatique != 0 ? "SP" : "BP") + ")-" + dec + "\n";
			}
		}


		return bloc;
	}


	public static String changerVariable(TDS tds, String variable, String registre) {
		Pair<Element, Integer> pair = tds.getByName(variable, GrammaireParser.VARIABLE, false);
		int nbChainageStatique = tds.getImbric() - pair.getSecond();
		String bloc = "";
		if (nbChainageStatique != 0) {
			bloc += ToolsASM.link();
			for (int i = 0; i <= nbChainageStatique; i++) {
				bloc += "	LDW SP, (SP)\n";
			}
//			if (valeur == -1)
//				bloc += "	STW R1, (SP)-" + pair.getFirst().getDeplacement() + "\n";
//			else
			bloc += "\tSTW " + registre + ",(SP)-" + pair.getFirst().getDeplacement() + "\n";
			bloc += ToolsASM.unlink();
		} else {
			//pas de chainage
//			if (valeur == -1)
//				bloc += "	STW R1, (BP)-" + pair.getFirst().getDeplacement() + "\n";
//**			else
			bloc += "\tSTW " + registre + ",(BP)-" + pair.getFirst().getDeplacement() + "\n";
		}
		return bloc;
	}

	public static void changerVariableEtEcrire(FileWriter writer, TDS tds, String variable, String registre) {
		try {
			writer.write(changerVariable(tds, variable, registre));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String appelToString() {
		
		String bloc = "	LDW R0, #STACK_ADRS	//on va chercher le descripteur de classe de Integer\n"
		+ "	ADQ -8, R0\n"//toujours 8 pour toString()
		+ "	LDW R0, (R0)\n"
		+ "	MPC WR\n"// charge le contenu du PC dans WR
		+ "	ADQ 8, WR\n"//adresse de retour en enlevant les parametres
		+ "	ADQ -2, SP\n" // decremente le pointeur de pile SP
		+ "	STW WR, (SP)\n" // sauvegarde l'adresse de retour sur le sommet de pile
		+ "	JEA (R0)\n"
		+ "	LDW R0, "+RESERVED_REGISTERS.return_function+"\n"
		+ "	LDW "+RESERVED_REGISTERS.return_function+", #0\n";
		return bloc;
	}
}