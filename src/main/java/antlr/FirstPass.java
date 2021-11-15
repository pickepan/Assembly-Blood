package antlr;

import antlr.generatedClasses.GrammaireParser;
import controls.Control;
import org.antlr.runtime.tree.Tree;
import tds.Element;
import tds.ElementMethod;
import tds.ElementVariable;
import tds.TDS;
import tdt.ElementTDT;
import tdt.TDT;

public class FirstPass {

    private boolean debug;
    private TDT tableDesTypes;
    private Tree tree;
    private ElementTDT e;
    private Element elem;

    public FirstPass(boolean debug) {
        this.debug = debug;
    }

    public void firstPass(Tree t){
         switch (t.getType()){
            case 31: //root node
                for(int i = 0; i<t.getChildCount();i++){
//                    tdsNew = new TDS(++tds_counter,tds.getImbric()+1,tds);
//                    tds.addTDSFilles(tdsNew);
                    firstPass(t.getChild(i));
                }
                break;

            case GrammaireParser.CLASSE:

//                tdsNew = new TDS(++tds_counter,tds.getImbric()+1,tds);
//                tds.addTDSFilles(tdsNew);

                Control cNameAlreadyExists = new Control(t.getLine(), t.getCharPositionInLine(), "Class '" + t.getChild(0) + "' is already defined", debug);
                cNameAlreadyExists.nameClassCheck(t, tableDesTypes);

                if(debug == true){
                    System.out.print("CLASS " + t.getChild(0));
                }

                e = new ElementTDT(t.getChild(0).getText());//ajout nom du type

                if(debug == true){
                    if(t.getChild(1).getType() != GrammaireParser.LIST_PARAM)
                        System.out.println();
                }

                firstPass(t.getChild(1));

                if(debug == true){
                    System.out.println("{");
                }


                for(int i=2; i<t.getChildCount();i++){ //name params methods
                    if(!t.getChild(i).getText().equals("EXTENDS")){
                        firstPass(t.getChild(i));
                    }
                    else{
                        if(debug == true){
                            System.out.println("EXTENDS " + t.getChild(i).getChild(0).getText());
                        }
                        e.setTypeHeritage(t.getChild(i).getChild(0).getText());
                    }
                }

                if(debug == true){
                    System.out.println("}");
                }

                tableDesTypes.addType(e);
                e = null;
                break;

            case GrammaireParser.LIST_PARAM:
                boolean isClassParameter = t.getParent().getText().equals("CLASSE");
                boolean isMethodParameter = t.getParent().getText().equals("METHOD");

                if(debug == true){
                    System.out.print("(");
                }


                for(int i=0; i<t.getChildCount();i++){
                    if(debug == true){
                        if(i != 0)
                            System.out.print(",");
                    }


                    if(isClassParameter){ //parameter of a class
                        //ajout de l'attribut defini en parametre si on est dans une entete
                        if(e !=null) {
                            elem = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(), 0, 0, 0);
                            e.add(elem);
                        }

                        if(debug == true){
                            System.out.print(t.getChild(i).getChild(0).getText());
                            System.out.print(":");
                            System.out.print(t.getChild(i).getChild(1).getText());
                        }


                        ElementVariable elementVariable = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(),0,t.getLine(),t.getCharPositionInLine());
//                        tds.addElement(elementVariable);

                    }
                    else if(isMethodParameter){
                        //ajout des types de chaque param�tre si c'est une method d'un objet
                        if(elem !=null) {
                            ((ElementMethod)elem).addParameter(t.getChild(i).getChild(1).getText());
                        }

                        if(debug == true){
                            System.out.print(t.getChild(i).getChild(0).getText());
                            System.out.print(":");
                            System.out.print(t.getChild(i).getChild(1).getText());
                        }

                        ElementVariable elementVariable = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(),0,t.getLine(),t.getCharPositionInLine());
//                        tds.addElement(elementVariable);
                    }
                    else{
                        //DO NOTHING
                        firstPass(t.getChild(i));
                    }

                }

                if(debug == true){
                    System.out.print(")");
                }

                break;

            case GrammaireParser.ATTRIBUT: //variable de classe
                //ajout attribut a un objet de la tdt
                //nom, type, deplacement, ligne, decalage
                if(e !=null) {
                    elem = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, 0, 0);
                    if(t.getChild(t.getChildCount()-1).getText().contentEquals("static"))
                    	elem.setStatique(true);
                    e.add(elem);
                }

                if(debug == true){
                    System.out.print("ATTRIBUT Node : ");
                    System.out.println("Nom = '" + t.getChild(0).getText() + "' | type= " + t.getChild(1).getText());
                }

                //Ajout à la TDS
                Element attribut = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, t.getChild(0).getLine(),t.getChild(0).getCharPositionInLine());
//                tds.addElement(attribut);

                break;

            case GrammaireParser.METHOD:
                //instanciation d'un element method qui sera ajout a la fin a la tdt
                //les parametres sont ajoutes dans LISTE_PARAM
                //nom, type, deplacement, ligne, decalage

                if(e !=null) {
                    elem = new ElementMethod(t.getChild(0).getText(), null, 0, 0, 0);
                    if(t.getChild(1).getText().contentEquals("static"))
                    	elem.setStatique(true);
                }

                if(debug == true){
                    System.out.print("METHOD " + t.getChild(0));
                }


                Control cConstructorOk = new Control(t.getLine(), t.getCharPositionInLine(), "Illegal condition : condition must be if(0||1)", debug);
                cConstructorOk.isConstructorOK(t);
//            	ElementMethod elementMethod = new ElementMethod(t.getChild(0).getText(),"method",0,t.getLine(),t.getCharPositionInLine());
//            	tds.addElement(elementMethod);


                //TODO verifier que c'est le cas pour les methodes courtes

//                tdsNew = new TDS(++tds_counter,tds.getImbric() + 1,tds); //creation d'une nouvelle table car nouveau bloc
//                tds.addTDSFilles(tdsNew);

                for(int i=1; i<t.getChildCount();i++){
                    //type de retour de la methode
                    if(t.getChild(i).getType() == GrammaireParser.CLASSID && e != null) {
                        if(debug == true){
                            System.out.print(":");
                        }
                        elem.setType(t.getChild(i).getText());
                    }

                    firstPass(t.getChild(i));

                }
                //ajout a la TDT
                //on remet elem a null pour dire que l'on attend plus de parametre
                if(e !=null) {
                    e.add(elem);
                    elem = null;
                }


                break;


            case GrammaireParser.PARAM: // PAS A FAIRE CAR DEJA FAIT DANS LIST_PARAM
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(":");
                }
                firstPass(t.getChild(1));
//                if(t.getParent().getParent().getText().equals("METHOD")){
//                    ElementVariable elementVariable = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(),0,t.getLine(),t.getCharPositionInLine());
//                    tds.addElement(elementVariable);
//                }
                break;

            case GrammaireParser.EXTENDS:
                if(debug == true){
                    System.out.print(" extends " + t.getChild(0));
                }
                //ajout de la relation d'heritage

                e.setTypeHeritage(t.getChild(0).getText());
                break;

            case GrammaireParser.BLOCK:
                if(!t.getParent().getText().equals("METHOD")){
//                    tdsNew = new TDS(++tds_counter,tds.getImbric()+1,tds);
//                    tds.addTDSFilles(tdsNew);
                    if(debug == true){
                        System.out.println("{");
                    }

                    for(int i=0; i<t.getChildCount();i++){
                        firstPass(t.getChild(i));
                    }
                    if(debug == true){
                        System.out.println("\n}");
                    }
                }
                else{
                    if(debug == true){
                        System.out.println("{");
                    }
                    for(int i=0; i<t.getChildCount();i++){
                        firstPass(t.getChild(i));
                    }
                    if(debug == true){
                        System.out.println("\n}");
                    }
                }
                break;

            case GrammaireParser.AFFECTATION:
                if(debug == true){
                    System.out.print("AFFECTATION Node : Nom = '" + t.getChild(0).getChild(0).getText() + "' | Value = ");
                }
                firstPass(t.getChild(1));
                if(debug == true){
                    System.out.println();
                }
                break;

            case GrammaireParser.VARIABLE:
                firstPass(t.getChild(0));
                break;

            case GrammaireParser.VARIABLE_LOCALE:
                if(debug == true){
                    System.out.print("VARIABLE_LOCALE Node : ");
                    System.out.print("Nom = '" + t.getChild(0).getText() + "' | type = " + t.getChild(1).getText());
                }
                if(t.getChildCount() == 3){ //  VALUE
                    if(debug == true){
                        System.out.print(" | Value = ");
                    }
                    firstPass(t.getChild(2));
                }
                if(debug == true){
                    System.out.println();
                }

//                Element elementVariable = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, t.getChild(0).getLine(),t.getChild(0).getCharPositionInLine());
//                tds.addElement(elementVariable);

                break;

            case GrammaireParser.VALUE:
                firstPass(t.getChild(0));
                break;

            case GrammaireParser.IDENTIFICATEUR: //TODO finir en fonction des differents cas possibles de fils
                if(debug == true){
                    System.out.println("IDENTIFICATEUR Node");
                }
                break;

            case GrammaireParser.GROUP:
                if(debug == true){
                    System.out.print("(");
                }
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(")");
                }
                break;


            case GrammaireParser.NEW:
                if(debug == true){
                    System.out.print("NEW ");
                }
                firstPass(t.getChild(0));
                firstPass(t.getChild(1));
                break;

            case GrammaireParser.IF:
                if(debug == true){
                    System.out.print("\nIF ( ");
                }
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" ) ");
                    System.out.print("THEN {");
                }
                firstPass(t.getChild(1));
                if(debug == true){
                    System.out.print("}");
                    System.out.print("ELSE {");
                }
                firstPass(t.getChild(2));
                if(debug == true){
                    System.out.print(" }");
                }
                break;

            case GrammaireParser.CONDITION:
//                Control cDivide = new Control(t.getLine(), t.getCharPositionInLine(), "Illegal condition : condition must be if(0||1)");
//                cDivide.condition(t, tds);
                firstPass(t.getChild(0));
                break;

            case GrammaireParser.THEN: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                for(int i=0; i<t.getChildCount(); i++){
                    firstPass(t.getChild(i));
                }
                break;

            case GrammaireParser.ELSE: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                for(int i=0; i<t.getChildCount(); i++){
                    firstPass(t.getChild(i));
                }
                break;

            case GrammaireParser.HERITED: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                if(debug == true){
                    System.out.print(":");
                }
                firstPass(t.getChild(0));
                firstPass(t.getChild(1));
                break;

            case GrammaireParser.WHILE:
                if(debug == true){
                    System.out.print("\nWHILE ( ");
                }
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" )");
                    System.out.print("DO {");
                }
                firstPass(t.getChild(1));
                if(debug == true){
                    System.out.print(" }");
                }
                break;

            case GrammaireParser.MESSAGE:
                firstPass(t.getChild(0));
                for(int i=1;i<t.getChildCount();i++){
                    if(debug == true){
                        System.out.print(".");
                    }
                    firstPass(t.getChild(i));
                }

                break;

            case GrammaireParser.APPEL_FONCTION:
                if(t.getChild(0).getText().equals("super")){
                    if(debug == true){
                        System.out.print("super");
                    }
                }
                else{
                    firstPass(t.getChild(0).getChild(0));
                }
                firstPass(t.getChild(1));
                break;

            case GrammaireParser.FONCTION:
                if(debug == true){
                    System.out.println("FONCTION Node");
                }
                break;

            case GrammaireParser.DO:
                for(int i=0; i<t.getChildCount(); i++){
                    firstPass(t.getChild(i));
                }
                break;

            case GrammaireParser.STRING:
                if(debug == true){
                    System.out.print("STRING = " + t.getChild(0).getText());
                }
                if(t.getChildCount()>1){
                    if(debug == true){
                        System.out.print(".");
                    }
                    firstPass(t.getChild(1));
                }
                break;

            case GrammaireParser.SELECT:
                firstPass(t.getChild(0).getChild(0));
                if(debug == true){
                    System.out.print(".");
                }
                firstPass(t.getChild(0).getChild(1));
                break;


            case GrammaireParser.CLASSID:
                if(debug == true){
                    System.out.print(t.getText());
                }
                break;

            case 22: //INTEGER
                if(debug == true){
                    System.out.print(t.getText());
                }
                break;

            case GrammaireParser.ID:
                if(debug == true){
                    System.out.print(t.getText());
                }
                break;

            case 46: //+
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("+");
                }
                firstPass(t.getChild(1));
                break;

            case 45: //*
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("*");
                }
                firstPass(t.getChild(1));
                break;

            case 48: //-
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("-");
                }
                firstPass(t.getChild(1));
                break;

            case 50: // /
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("/");
                }
                firstPass(t.getChild(1));

                Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Illegal division : by 0 or by String, forbidden", debug);
                c.divide(t);
                break;

            case 55: // <>
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("<>");
                }
                firstPass(t.getChild(1));
                break;

            case 56: // =
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print("=");
                }

                firstPass(t.getChild(1));
                break;

            case GrammaireParser.MOINS_UNAIRE: //MOINS UNAIRE
                if(debug == true){
                    System.out.print("-" + t.getChild(0).getText());
                }
                break;


            case GrammaireParser.PLUS_UNAIRE: //PLUS UNAIRE
                if(debug == true){
                    System.out.print("+" + t.getChild(0).getText());
                }
                break;

            case GrammaireParser.CAST: //PLUS UNAIRE
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(":");
                }
                firstPass(t.getChild(1));
                break;

            case 54: // <
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" < ");
                }
                firstPass(t.getChild(1));
                break;

            case 57: // >
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" > ");
                }
                firstPass(t.getChild(1));
                break;

            case 42: // &
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" & ");
                }
                firstPass(t.getChild(1));
                break;

            case 77: // ||
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" || ");
                }
                firstPass(t.getChild(1));

            case 41: // &&
                firstPass(t.getChild(0));
                if(debug == true){
                    System.out.print(" && ");
                }
                firstPass(t.getChild(1));

            case 67: //override
                if(debug == true){
                    System.out.println(" " + t.getText());
                }
                break;

            case 70: //static
                if(debug == true){
                    System.out.println(" " + t.getText());
                }
                break;

            default:
                if(debug){
                    System.out.print("Node type '" + t.getType() + "' does not exist!" );
                }

        }

    }

    public void launch(TDT tdt, Tree tree){
        tableDesTypes = tdt;
        this.tree = tree;
        if(debug){
            System.out.println("-----------------------------");
        }
        firstPass(tree);
        if(debug){
            System.out.println("-----------------------------");
            System.out.println("First pass OK\n");
        }
    }

    public TDT getTableDesTypes() {
        return tableDesTypes;
    }
}
