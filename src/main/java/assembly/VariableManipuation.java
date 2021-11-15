package assembly;

import antlr.generatedClasses.GrammaireParser;
import objet.ElementObjet;

import org.antlr.runtime.tree.Tree;
import tds.Element;
import tds.Pair;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public abstract class VariableManipuation {
    public static void variableDeclaration(TDS tds, FileWriter writer) throws IOException {
        // --- Ecriture de l'environnement du bloc en cours --- //
        // Recuperation du deplacement total des elements de la TDS

        if (tds.getTable().size() == 0) {
            // La TDS est vide, aucune variable a declarer
            return;
        }
        int dep = tds.getDeplacementAllouer();
        if(dep != 0)
        	writer.write("	ADQ -" + dep + ", SP" + "\n" );

    }

    public static void variableAffectation(Tree nodeAffectation, TDS tds, FileWriter writer, String classType) throws IOException {
    	// --- Ecriture du code de l'affectation --- //
        // Pour le moment, on ne considere que le cas simple ou le fils droit du noeud affectation est juste un noeud VARIABLE
        String bloc_delc = "";
        Tree t_ = nodeAffectation.getChild(1);
        if(nodeAffectation.getChild(1).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
            Tree t__ = t_;
            while(t__.getType() == GrammaireParser.GROUP){
                if (t_.getChild(0).getType() == GrammaireParser.MESSAGE){
                    break;
                }
                t__ = t__.getChild(0);

            }
            t_ = t__;
        }

        if (t_.getType() == GrammaireParser.INT) {
            // On affecte un entier a une variable
            int val = Integer.parseInt(t_.getText());      // Entier a affecter a la variable
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,false, val);
        }
        else if (t_.getType() == GrammaireParser.PLUS_UNAIRE) {
            // On affecte un entier a une variable
            int val = Integer.parseInt(t_.getChild(0).getText());      // Entier a affecter a la variable
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,false, val);
        }
        else if (t_.getType() == GrammaireParser.MOINS_UNAIRE) {
            // On affecte un entier a une variable
            int val = Integer.parseInt(t_.getChild(0).getText());      // Entier a affecter a la variable
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,false, -val);
        }

        else if (t_.getType() == GrammaireParser.STRING) {
            // On affecte une string a une variable

            String val = t_.getChild(0).getText();

            TasASM.allocationString(val, false, false);
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);

            	
        }
        else if (t_.getType() == 42) {
            // On affecte une string a une variable
//            String val = t_.getChild(0).getText();
//            TasASM.allocationString(val, false);
//            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
            Printer p = new Printer(writer);
            p.esperluette_concat(t_);
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
        }
        else if (t_.getType() == GrammaireParser.NEW) {
        	String type = t_.getChild(0).getText();
        	//allocation de la place necessaire puis mise dans R1 de l'adresse de cette instance
        	TasASM.allocationObjet(type);
        	affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
	        writer.write("	//fin instanciation--------------\n"
	        			+"	LDW R0, R1\n");

	      	//on empile les parametres du constructeur et on le lance (JSR)
	        //System.out.println(t_.getChild(0));
	       	ElementObjet obj = new ElementObjet(classType, t_, "Fonction");
	       	TasASM.initFonction(tds, type, obj, false);
        }
        //amenee changer il s'agit d'un test pour les constructeurs pour faire this.x = x;
        else if(t_.getType() == GrammaireParser.VARIABLE){
        	writer.write(ToolsASM.getVariableInR0(tds, t_.getChild(0).getText())+ "	LDW R1, R0\n");
        	affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
        }
        else if(t_.getType() == GrammaireParser.GROUP) {
            if(t_.getChild(0).getType() == GrammaireParser.MESSAGE){
                if(t_.getChild(0).getChild(1).getType() == GrammaireParser.APPEL_FONCTION){
                    if(t_.getChild(0).getChild(1).getChild(0).getType() == GrammaireParser.FONCTION){
                        if(t_.getChild(0).getChild(1).getChild(0).getChild(0).getText().equals("toString")){
                            try {
                                if(t_.getChild(0).getChild(0).getType() == GrammaireParser.INT){
                                    Integer.parseInt(t_.getChild(0).getChild(0).getText());
                                    if(!classType.contentEquals("main"))
                                        writer.write("	ADQ -2, SP\n"
                                                + "	STW R11, (SP)\n");
                                    writer.write("	LDW R11, #"+t_.getChild(0).getChild(0).getText()+"\n"
                                            +ToolsASM.appelToString()
                                            +" LDW R1, R0\n");
                                    if(!classType.contentEquals("main"))
                                        writer.write("	LDW R11, (SP)\n"
                                                + "	ADQ 2, SP\n");
                                    affectationGauche(nodeAffectation.getChild(0), tds, writer, classType, true, 0);
                                }
                                else if(t_.getChild(0).getChild(0).getType() == GrammaireParser.PLUS_UNAIRE){
                                    Integer.parseInt(t_.getChild(0).getChild(0).getChild(0).getText());
                                    if(!classType.contentEquals("main"))
                                        writer.write("	ADQ -2, SP\n"
                                                + "	STW R11, (SP)\n");
                                    writer.write("	LDW R11, #"+t_.getChild(0).getChild(0).getChild(0).getText()+"\n"
                                            +ToolsASM.appelToString()
                                            +" LDW R1, R0\n");
                                    if(!classType.contentEquals("main"))
                                        writer.write("	LDW R11, (SP)\n"
                                                + "	ADQ 2, SP\n");
                                    affectationGauche(nodeAffectation.getChild(0), tds, writer, classType, true, 0);
                                }
                                else if(t_.getChild(0).getChild(0).getType() == GrammaireParser.MOINS_UNAIRE){
                                    Integer.parseInt(t_.getChild(0).getChild(0).getChild(0).getText());
                                    if(!classType.contentEquals("main"))
                                        writer.write("	ADQ -2, SP\n"
                                                + "	STW R11, (SP)\n");
                                    writer.write("	LDW R11, #-"+t_.getChild(0).getChild(0).getChild(0).getText()+"\n"
                                            +ToolsASM.appelToString()
                                            +" LDW R1, R0\n");
                                    if(!classType.contentEquals("main"))
                                        writer.write("	LDW R11, (SP)\n"
                                                + "	ADQ 2, SP\n");
                                    affectationGauche(nodeAffectation.getChild(0), tds, writer, classType, true, 0);
                                }
                                else if(
                                        Arrays.binarySearch(ToolsASM.tab, t_.getChild(0).getChild(0).getType()) >= 0
                                ){
                                    if(Arrays.binarySearch(ToolsASM.tab_conditionnal_operators, t_.getChild(0).getType()) >= 0){ //affectation avec un operateur booleen
                                        if(!classType.contentEquals("main"))
                                            writer.write("	ADQ -2, SP\n"
                                                    + "	STW R11, (SP)\n");
                                        writer.write("	LDW R11, " + RESERVED_REGISTERS.operations_register + "\n"
                                                +ToolsASM.appelToString()
                                                +" LDW R1, R0\n");
                                        if(!classType.contentEquals("main"))
                                            writer.write("	LDW R11, (SP)\n"
                                                    + "	ADQ 2, SP\n");
                                        affectationGauche(nodeAffectation.getChild(0), tds, writer, classType, true, 0);
                                    }
                                    else{ //affectation avec une operation
                                        if(!classType.contentEquals("main"))
                                            writer.write("	ADQ -2, SP\n"
                                                    + "	STW R11, (SP)\n");
                                        writer.write("	LDW R11," + RESERVED_REGISTERS.operations_register_2 + "\n"
                                                +ToolsASM.appelToString()
                                                +" LDW R1, R0\n");
                                        if(!classType.contentEquals("main"))
                                            writer.write("	LDW R11, (SP)\n"
                                                    + "	ADQ 2, SP\n");
                                        affectationGauche(nodeAffectation.getChild(0), tds, writer, classType, true, 0);
                                    }
                                }



	                  
	                       	}catch(NumberFormatException e) {}
                            boolean b = false;
                            if(t_.getChild(0).getChild(0).getType() == GrammaireParser.PLUS_UNAIRE){
                                b= true;
                            }
                            else if(t_.getChild(0).getChild(0).getType() == GrammaireParser.MOINS_UNAIRE){
                                b = true;
                            }
                            else if(t_.getChild(0).getChild(0).getType() == GrammaireParser.INT){
                                b = true;
                                writer.write("\tLDW R11, #" + t_.getChild(0).getChild(0).getText() + "\n");
                            }

                        }
                    }
                }
            }
        }
        else if(t_.getType()==GrammaireParser.IDENTIFICATEUR) {
			ElementObjet obj = new ElementObjet(classType, t_.getChild(0), "Objet");
			TasASM.attributDansR0(tds, obj, -1, false);
            writer.write("	LDW R1, R0\n");
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
        }
        else if (t_.getText().equals("||") || t_.getText().equals("&&") || t_.getText().equals(">")  || t_.getText().equals("<") || t_.getText().equals("<>") || t_.getText().equals("=")) {
            // On affecte un booleen stocke dans R5 a une variable
            writer.write("	LDW R1, "+RESERVED_REGISTERS.operations_register+"\n");
            affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
        }
        else if(t_.getType()==GrammaireParser.MESSAGE || t_.getType()==GrammaireParser.SELECT){
        	ElementObjet obj = new ElementObjet(classType, t_, "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
        	writer.write("	LDW R1, R0\n");
        	affectationGauche(nodeAffectation.getChild(0), tds, writer, classType,true, -1);
        }

        
        // --- Ecriture dans le fichier --- //
        try {
            writer.write(bloc_delc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int variableDec(Tree nodeAffectation, TDS tds){
        return tds.getByNameCurrentTable(nodeAffectation.getText(), GrammaireParser.VARIABLE).getDeplacement();
    }


    public static void variableAffectationAndDeclare(Tree nodeAffectation, TDS tds, String classType, FileWriter writer) throws IOException {
        // --- Ecriture du code de l'affectation --- //
        // Pour le moment, on ne considere que le cas simple ou le fils droit du noeud affectation est juste un noeud VARIABLE
        if (nodeAffectation.getChild(0).getType() == GrammaireParser.INT) {
            // On affecte un entier a une variable
            int val = Integer.parseInt(nodeAffectation.getChild(0).getText());      // Entier a affecter a la variable
            affectationGauche(nodeAffectation.getParent(), tds, writer, classType,false, val);

        }

        else if (nodeAffectation.getChild(0).getType() == GrammaireParser.STRING) {
            // On affecte une string a une variable

            String val = nodeAffectation.getChild(0).getChild(0).getText();
            TasASM.allocationString(val, false, false);
            affectationGauche(nodeAffectation.getParent(), tds, writer, classType,true, -1);
            writer.write("\n//fin stockage string--------\n");

        }
        else if (nodeAffectation.getChild(0).getType() == GrammaireParser.NEW) {
            String type = nodeAffectation.getChild(0).getChild(0).getText();
            TasASM.allocationObjet(type);
            affectationGauche(nodeAffectation.getParent(), tds, writer, classType, true,-1);
            writer.write("	//fin instanciation--------------\n"
        			+"	LDW R0, R1\n");
            ElementObjet obj = new ElementObjet(classType, nodeAffectation.getChild(0), "Fonction");
            TasASM.initFonction(tds, type, obj, false);
        }
        else if (nodeAffectation.getChild(0).getText().equals("||") || nodeAffectation.getChild(0).getText().equals("&&") ||nodeAffectation.getChild(0).getText().equals(">")  || nodeAffectation.getChild(0).getText().equals("<") || nodeAffectation.getChild(0).getText().equals("<>") || nodeAffectation.getChild(0).getText().equals("=")) {
            // On affecte un booleen stocke dans R5 a une variable
            
            writer.write("	LDW R1, "+RESERVED_REGISTERS.operations_register+"\n");
            affectationGauche(nodeAffectation.getParent(), tds, writer, classType, true, -1);
        }
        else if(nodeAffectation.getChild(0).getType()==GrammaireParser.IDENTIFICATEUR) {
        	ElementObjet obj = new ElementObjet(classType, nodeAffectation.getChild(0).getChild(0), "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
        	writer.write("	LDW R1, R0\n");
        	affectationGauche(nodeAffectation.getParent(), tds, writer, classType,true, -1);
        }
        else {
        	ElementObjet obj = new ElementObjet(classType, nodeAffectation.getChild(0), "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
        	writer.write("	LDW R1, R0\n");
        	affectationGauche(nodeAffectation.getParent(), tds, writer, classType,true, -1);
        }
        
    }
    //cette fonction affecte val a ce qu'il y a a gauche (variable, attribut, this, result)
    //si val = -1 la valeur va etre cherche dans R1
    public static void affectationGauche(Tree t, TDS  tds, FileWriter writer, String classType, boolean dansR1, int val) throws IOException{
    	//si c'est une variable
    	if(t.getType()==GrammaireParser.VARIABLE || t.getType()==GrammaireParser.VARIABLE_LOCALE) {
            if( t.getParent().getChild(1).getType() == GrammaireParser.MOINS_UNAIRE && val==-1){
                Pair<Element, Integer> pair = tds.getByName(t.getChild(0).getText(), GrammaireParser.VARIABLE, false);
                int nbChainageStatique = tds.getImbric() - pair.getSecond();
                String bloc = "";
                if (nbChainageStatique != 0) {
                    bloc += ToolsASM.link();
                    for (int i = 0; i <= nbChainageStatique; i++) {
                        bloc += "	LDW SP, (SP)\n";
                    }
                        bloc += "	LDW R0, #-1"  + "\n" +
                                "	STW R0,(SP)-" + pair.getFirst().getDeplacement() + "\n";
                    bloc += ToolsASM.unlink();
                } else {
                        bloc += "	LDW R0, #-1"  + "\n" +
                                "	STW R0,(BP)-" + pair.getFirst().getDeplacement() + "\n";
                }
                writer.write(bloc);
            }
            else{
                writer.write(ToolsASM.changerVariable(tds, t.getChild(0).getText(),dansR1, val));
            }

        }
    	//this, super ou result
    	else if(t.getType()==GrammaireParser.IDENTIFICATEUR && !classType.contentEquals("main")){
    		if(t.getChild(0).getText().contentEquals("RESULT")) {
    			if(val==-1)
    				writer.write("	LDW "+RESERVED_REGISTERS.return_function+", R1\n");
    			else
    				writer.write("	LDW "+RESERVED_REGISTERS.return_function+", #"+val+"\n");
    		}
        	else {
        		//TasASM.changerAttributThis(classType,t.getChild(0).getChild(1).getChild(0).getText(),dansR1, val);
        		ElementObjet obj = new ElementObjet(classType, t.getChild(0), "Objet");
        		TasASM.attributDansR0(tds, obj, -1, true);
        		writer.write((!dansR1?"	LDW R1, #"+val+"\n":"")+
        				"	STW R1, (R0)\n");
        	}
    	}
    	//sinon c'est un objet (x.y.y.x := ...)
        else {
        	ElementObjet obj = new ElementObjet(classType, t, "Objet");
        	TasASM.attributDansR0(tds, obj, -1, true);
    		writer.write((!dansR1?"	LDW R1, #"+val+"\n":"")+
    				"	STW R1, (R0)\n");  	
        }
    }



}
