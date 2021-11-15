package antlr;

import antlr.generatedClasses.GrammaireParser;
import controls.Control;
import org.antlr.runtime.tree.Tree;
import tds.*;
import tdt.TDT;

import java.util.ArrayList;

public class SecondPass {

    private boolean debug;
    private boolean dansMessage = false; //variable qui permet de differencier une variable d'une sous variable dans un message
    private static int tds_counter = 0;
    private String currentClass = "main";
    private String currentMethod;
    private TDT tableDesTypes;
    private Element elem;

    private final ArrayList<Integer> symbolsInt;
    private final ArrayList<Integer> symbolsString;
    private final ArrayList<Integer> symbolsOpalg;
    public static ArrayList<TDS> listeTDS = new ArrayList<TDS>();

    public SecondPass(boolean debug) {
        this.debug = debug;
        symbolsInt = Antlr_tool.getSymbolsInt();
        symbolsString = Antlr_tool.getSymbolsString();
        symbolsOpalg = Antlr_tool.getSymbolsOpalg();
    }

    public void launch(TDS tds, Tree tree, TDT tdt){
        tableDesTypes = tdt;
        secondPass(tree, tds);
        if(debug){
            System.out.println("Second pass OK");
        }
    }

    public void secondPass(Tree t, TDS tds){
        TDS tdsNew;
        Control c = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);

        switch (t.getType()){
            case 31: //root node
                for(int i = 0; i<t.getChildCount();i++){
                    secondPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.CLASSE:
                tdsNew = new TDS(++tds_counter,tds.getImbric()+1,tds);
                tds.addTDSFilles(tdsNew);
                listeTDS.add(tdsNew);

                currentClass = t.getChild(0).getText();
//                System.out.println("Current class : " + currentClass);

//                System.out.print("CLASS " + t.getChild(0));

//                e = new ElementTDT(t.getChild(0).getText());//ajout nom du type

//                if(t.getChild(1).getType() != GrammaireParser.LIST_PARAM)
//                    System.out.println();
                secondPass(t.getChild(1), tdsNew);

//                System.out.println("{");
                for(int i=2; i<t.getChildCount();i++){ //name params methods
                    if(!t.getChild(i).getText().equals("EXTENDS")){
                        secondPass(t.getChild(i), tdsNew);
                    }
                    else{
//                        System.out.println("EXTENDS " + t.getChild(i).getChild(0).getText());
                    }
                }
//                System.out.println("}");

//                tableDesTypes.addType(e);
//                e = null;
                currentClass = "main";
                break;

            case GrammaireParser.LIST_PARAM:
                boolean isClassParameter = t.getParent().getText().equals("CLASSE");
                boolean isMethodParameter = t.getParent().getText().equals("METHOD");
//                System.out.print("(");
                for(int i=0; i<t.getChildCount();i++){
                    if(isClassParameter){ //parameter of a class
                        //ajout de l'attribut defini en parametre si on est dans une entete
//                        if(e !=null) {
//                            elem = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(), 0, 0, 0);
//                            e.add(elem);
//                        }
//                        System.out.print(t.getChild(i).getChild(0).getText());
//                        System.out.print(":");
//                        System.out.print(t.getChild(i).getChild(1).getText());

                        ElementVariable elementVariable = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(),0,t.getLine(),t.getCharPositionInLine());
                        Control cListParam = new Control(t.getChild(i).getLine(), t.getChild(i).getCharPositionInLine(), "Variable '"+t.getChild(i).getChild(0).getText()+"' is already defined", debug);
                        cListParam.alreadyDeclared(t.getChild(i), tds);
                        tds.addElement(elementVariable);

                    }
                    else if(isMethodParameter){
                        //ajout des types de chaque param�tre si c'est une method d'un objet
//                        if(elem !=null) {
//                            ((ElementMethod)elem).addParameter(t.getChild(i).getChild(1).getText());
//                        }
//                        System.out.print(t.getChild(i).getChild(0).getText());
//                        System.out.print(":");
//                        System.out.print(t.getChild(i).getChild(1).getText());
                        ElementVariable elementVariable = new ElementVariable(t.getChild(i).getChild(0).getText(), t.getChild(i).getChild(1).getText(),-2+-2*(t.getChildCount()-i),t.getLine(),t.getCharPositionInLine());
                        Control cListParam = new Control(t.getChild(i).getLine(), t.getChild(i).getCharPositionInLine(), "Variable '"+t.getChild(i).getChild(0).getText()+"' is already defined", debug);
                        cListParam.alreadyDeclared(t.getChild(i), tds);
                        
                        tds.addElement(elementVariable);
                    }
                    else{
                        //DO NOTHING
                        secondPass(t.getChild(i), tds);
                    }

                }
//                System.out.print(")");
                break;

            case GrammaireParser.ATTRIBUT: //variable de classe
                //ajout attribut a un objet de la tdt
                //nom, type, deplacement, ligne, decalage
//                if(e !=null) {
//                    elem = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, 0, 0);
//                    e.add(elem);
//                }
//                System.out.print("ATTRIBUT Node : ");
//                System.out.println("Nom = '" + t.getChild(0).getText() + "' | type= " + t.getChild(1).getText());
                Control cAttribut = new Control(t.getLine(), t.getCharPositionInLine(), "Type of variable '"+t.getChild(0).getText()+"' ( "+t.getChild(1).getText()+" ) is undefined", debug);
                cAttribut.typeCheck(t.getChild(1).getText(), tableDesTypes);
                cAttribut.setMessage("Variable '"+t.getChild(0).getText()+"' is already defined");
                cAttribut.alreadyDeclared(t, tds);


//                Control cTypeCheck = new Control(t.getLine(), t.getCharPositionInLine(), "Type '" + t.getChild(1).getText() + "' does not exist", debug);
//                cTypeCheck.attributCheck(t, tableDesTypes);

                //Ajout à la TDS
                Element attribut = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, t.getChild(0).getLine(),t.getChild(0).getCharPositionInLine());
                tds.addElement(attribut);

                break;

            case GrammaireParser.METHOD:
                //instanciation d'un element method qui sera ajout a la fin a la tdt
                //les parametres sont ajoutes dans LISTE_PARAM
                //nom, type, deplacement, ligne, decalage
//                if(e !=null) {
//                    elem = new ElementMethod(t.getChild(0).getText(), null, 0, 0, 0);
//
//                }
//                System.out.print("METHOD " + t.getChild(0));
                currentMethod = t.getChild(0).getText();

                Control cMethod = new Control(t.getLine(), t.getCharPositionInLine(), "Class '" + t.getParent().getChild(0) + "' already have a constructor", debug);
                cMethod.hasAlreadyConstructor(t, tds);

                ElementMethod elementMethod = new ElementMethod(t.getChild(0).getText(),"method",0,t.getLine(),t.getCharPositionInLine());

                cMethod.setMessage("Method '"+t.getChild(0).getText()+"' is already defined");

                cMethod.alreadyDeclared(t, tds);

                Control cResult = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);
                cResult.resultCheck(t);



                tds.addElement(elementMethod);


                //TODO verifier que c'est le cas pour les methodes courtes

                tdsNew = new TDS(++tds_counter,tds.getImbric() + 1,tds); //creation d'une nouvelle table car nouveau bloc
                tds.addTDSFilles(tdsNew);
                listeTDS.add(tdsNew);

                for(int i=1; i<t.getChildCount();i++){
                    //type de retour de la methode
//                    if(t.getChild(i).getType() == GrammaireParser.CLASSID && e != null) {
////                        System.out.print(":");
//                        elem.setType(t.getChild(i).getText());
//                    }

                    secondPass(t.getChild(i), tdsNew);

                }


                if (t.getChild(1)!=null ) {
                    if(t.getChild(1).getText().equals("override")) {
                        for (int i=0;i<t.getParent().getChildCount();i++) {
                            if (t.getParent().getChild(i).getText().equals("EXTENDS")) {
                                String classeMere=t.getParent().getChild(i).getChild(0).getText();

                                cMethod.setMessage("Method '"+t.getChild(0).getText()+"' is supposed to override but is not defined in the superclass");
                                cMethod.checkOverride(t.getChild(0).getText(), tableDesTypes, classeMere);
                            }
                        }
                    }
                }

                if (t.getChild(2)!=null ) {
                    if(t.getChild(2).getText().equals("override")) {
                        for (int i=0;i<t.getParent().getChildCount();i++) {
                            if (t.getParent().getChild(i).getText().equals("EXTENDS")) {
                                String classeMere=t.getParent().getChild(i).getChild(0).getText();
                                cMethod.setMessage("The method '"+t.getChild(0).getText()+"' is override but is not defined in the superclass");
                                cMethod.checkOverride(t.getChild(0).getText(), tableDesTypes, classeMere);
                            }
                        }
                    }
                }
//                //ajout a la TDT
//                //on remet elem a null pour dire que l'on attend plus de parametre
//                if(e !=null) {
//                    e.add(elem);
//                    elem = null;
//
                break;

            case GrammaireParser.PARAM: // PAS A FAIRE CAR DEJA FAIT DANS LIST_PARAM
                Control cParam = new Control(t.getLine(), t.getCharPositionInLine(), "Type of the variable '"+t.getChild(0).getText()+"' ( "+t.getChild(1).getText()+" ) is undefined", debug);
                cParam.typeCheck(t.getChild(1).getText(), tableDesTypes);
                secondPass(t.getChild(0), tds);
//                System.out.print(":");
                secondPass(t.getChild(1), tds);
//                System.out.println("ICI "  + t.getParent().getParent().getText());
                if(t.getParent().getParent().getText().equals("METHOD")){
                    ElementVariable elementVariable = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(),0,t.getLine(),t.getCharPositionInLine());
                    tds.addElement(elementVariable);
                }
                break;

            case GrammaireParser.EXTENDS:
//                System.out.print(" extends " + t.getChild(0));
                //ajout de la relation d'heritage
//                e.setTypeHeritage(t.getChild(0).getText());
                Control cExtends = new Control(t.getLine(), t.getCharPositionInLine(), "Type '" + t.getChild(0).getText() + "' does not exist", debug);
                cExtends.extendsCheck(t, tableDesTypes);
                break;

            case GrammaireParser.BLOCK:
                if(!t.getParent().getText().equals("METHOD")){
                    tdsNew = new TDS(++tds_counter,tds.getImbric()+1,tds);
                    tds.addTDSFilles(tdsNew);
                    listeTDS.add(tdsNew);

//                    System.out.println("{");
                    for(int i=0; i<t.getChildCount();i++){
                        secondPass(t.getChild(i), tdsNew);
                    }
//                    System.out.println("\n}");
                }
                else{
//                    System.out.println("{");
                    for(int i=0; i<t.getChildCount();i++){
                        secondPass(t.getChild(i), tds);
                    }
//                    System.out.println("\n}");
                }
                break;

            case GrammaireParser.AFFECTATION:
//                System.out.print("AFFECTATION Node : Nom = '" + t.getChild(0).getChild(0).getText() + "' | Value = ");
                // 46, 48, 45, 50, 77, 41, 56, 55, 54, 57, 26, 29  => Integers


                Control cAffectation = new Control(t.getLine(), t.getCharPositionInLine(), "The types doesn't match.", debug);
                cAffectation.checkAffectation(t, tds, tableDesTypes, currentClass, currentMethod, symbolsInt, symbolsString);

                secondPass(t.getChild(0), tds);
                secondPass(t.getChild(1), tds);
//                System.out.println();

                break;

            case GrammaireParser.VARIABLE:
                if(!dansMessage) {
                    Control cVariable = new Control(t.getLine(), t.getCharPositionInLine(), "Variable '"+t.getChild(0).getText()+"' is not defined before use", debug);
                    if(!currentClass.contentEquals("main") && tds.getImbric()>=2) {
                        if(t.getParent().getParent().getType() != GrammaireParser.SELECT){
                            cVariable.isNotDeclared(t, tds, true);
                        }
                        else{
                            Control cVariableStatic = new Control(t.getLine(), t.getCharPositionInLine(), "Static variable '"+t.getChild(0).getText()+"' is not defined before use", debug);
                            cVariableStatic.staticVariableCheckExistance(t, tableDesTypes);
                        }
                    }
                    else{
                        if(t.getParent().getParent().getType() != GrammaireParser.SELECT){
                            cVariable.isNotDeclared(t, tds, false);
                        }
                        else{
                            Control cVariableStatic = new Control(t.getLine(), t.getCharPositionInLine(), "Static variable '"+t.getChild(0).getText()+"' is not defined before use", debug);
                            cVariableStatic.staticVariableCheckExistance(t, tableDesTypes);
                        }

                    }

                }
                secondPass(t.getChild(0), tds);
                break;

            case GrammaireParser.VARIABLE_LOCALE:
//                System.out.print("VARIABLE_LOCALE Node : ");
//                System.out.print("Nom = '" + t.getChild(0).getText() + "' | type = " + t.getChild(1).getText());
                Control cVarLoc = new Control(t.getLine(), t.getCharPositionInLine(), "Type of variable '"+t.getChild(0).getText()+"' ( "+t.getChild(1).getText()+" ) is undefined", debug);
                cVarLoc.typeCheck(t.getChild(1).getText(), tableDesTypes);
                cVarLoc.setMessage("Variable '"+t.getChild(0).getText()+"' is already defined");
                cVarLoc.alreadyDeclared(t, tds);

                if(t.getChildCount() == 3){ //  VALUE
//                    System.out.print(" | Value = ");
                    secondPass(t.getChild(2), tds);
                }
//                System.out.println();

                Element elementVariable = new ElementVariable(t.getChild(0).getText(), t.getChild(1).getText(), 0, t.getChild(0).getLine(),t.getChild(0).getCharPositionInLine());
                tds.addElement(elementVariable);

                break;

            case GrammaireParser.VALUE:
                secondPass(t.getChild(0), tds);
                break;

            case GrammaireParser.IDENTIFICATEUR:
                //System.out.println(t.getLine()+" "+ t.getCharPositionInLine());
                Control cIdentif = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);


                if (currentClass.equals(currentMethod) && t.getChild(0).getText().equals("RESULT")) {
                    secondPass(t.getChild(0), tds);
                    cIdentif.setLine(t.getChild(0).getChild(0).getLine());
                    cIdentif.setPosition(t.getChild(0).getChild(0).getCharPositionInLine());
                    cIdentif.resultInConstructor();
                }

                if (t.getChild(0).getType() == GrammaireParser.RESULT) {
                    c.checkResultUsage(t, tableDesTypes, currentClass, currentMethod);
                }

                if (t.getChild(0).getText().equals("MESSAGE")){
                    secondPass(t.getChild(0), tds);
                }


                break;

            case GrammaireParser.GROUP:
//                System.out.print("(");
                secondPass(t.getChild(0), tds);
//                System.out.print(")");
                break;


            case GrammaireParser.NEW:
//                System.out.print("NEW ");
                Control checkCallOnConstructor = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);
                checkCallOnConstructor.callOnConstructor(t, tds, tableDesTypes);
                secondPass(t.getChild(0), tds);
                secondPass(t.getChild(1), tds);
                break;

            case GrammaireParser.IF:
//                System.out.print("\nIF ( ");
                secondPass(t.getChild(0), tds);
//                System.out.print(" ) ");
//                System.out.print("THEN {");
                secondPass(t.getChild(1), tds);
//                System.out.print("}");
//                System.out.print("ELSE {");
                secondPass(t.getChild(2), tds);
//                System.out.print(" }");
                break;

            case GrammaireParser.CONDITION:
                Control cCondition = new Control(t.getLine(), t.getCharPositionInLine(), "Illegal condition : condition must be if(0||1)", debug);
                cCondition.condition(t, tds, currentClass, tableDesTypes);
                secondPass(t.getChild(0), tds);
                break;

            case GrammaireParser.THEN: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                for(int i=0; i<t.getChildCount(); i++){
                    secondPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.ELSE: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                for(int i=0; i<t.getChildCount(); i++){
                    secondPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.HERITED: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
//                System.out.print(":");
                secondPass(t.getChild(0), tds);

                secondPass(t.getChild(1), tds);
                break;

            case GrammaireParser.WHILE:
//                System.out.print("\nWHILE ( ");
                secondPass(t.getChild(0), tds);
//                System.out.print(" )");
//                System.out.print("DO {");
                secondPass(t.getChild(1), tds);
//                System.out.print(" }");
                break;

            case GrammaireParser.MESSAGE:
                Control cMessage=new Control(t.getLine(), t.getCharPositionInLine(), "", debug);
                c.checkTypeParams(
                        t, tds, tableDesTypes, currentClass, currentMethod, symbolsString, symbolsOpalg
                );

                if (t.getChild(0).getText().equals("VARIABLE") && t.getChild(0).getChild(0).getText().equals("APPEL_FONCTION")==false ) { ;
                    Pair<Element, Integer> pair= tds.getByName(t.getChild(0).getChild(0).getText(), GrammaireParser.VARIABLE, false); //regarde si la variable destination existe
                    if (pair != null && cMessage.destMethod(pair,t.getChild(0).getChild(0).getText())==0 ){
                        String type=pair.getFirst().getType();
                        Element elem=null;
                        for (int i=1;i<t.getChildCount();i++) {
                            if(t.getChild(i).getText().equals("VARIABLE")) {
                                elem=cMessage.attributCheck(type, t.getChild(i).getChild(0).getText(), tableDesTypes);

                            }
                            else if (t.getChild(i).getText().equals("APPEL_FONCTION")) {
                                elem=cMessage.methodCheck(type, t.getChild(i).getChild(0).getChild(0).getText(), tableDesTypes);

                            }
                            if (elem!= null ) {
                                if (elem.getType()!=null) {
                                    type=elem.getType();
                                }

                                else if (elem.getType()==null){
                                    if (t.getChild(i+1)!= null) {
                                        cMessage.setMessage("Method '" +elem.getNom()+"' returns null, can't apply any method or attribut ");
                                        cMessage.display();
                                        break;
                                    }
                                }
                            }
                            else {
                                break;
                            }

                        }

                    }

                }


                if (t.getChild(0) != null && t.getChild(1) !=null) {

                    if (t.getChild(0).getText().equals("this")) {

                        String type=currentClass;
                        for (int i=1;i<t.getChildCount();i++) {


                            if(t.getChild(i).getText().equals("VARIABLE")) {
                                Element elem=cMessage.attributCheck(type, t.getChild(1).getChild(0).getText(), tableDesTypes);

                            }
                            else if (t.getChild(i).getText().equals("APPEL_FONCTION")) {
                                Element elem=cMessage.methodCheck(type, t.getChild(1).getChild(0).getChild(0).getText(), tableDesTypes);
                            }
                            if (elem!= null) type=elem.getType();
                            else break;
                        }
                    }

                    if (t.getChild(0).getText().equals("super")) {

                        String type;
                        if ((type=tableDesTypes.getType(currentClass).getTypeHeritage())!= null) {
                            for (int i=1;i<t.getChildCount();i++) {
                                if(t.getChild(i).getText().equals("VARIABLE")) {
                                    Element elem=cMessage.attributCheck(type, t.getChild(1).getChild(0).getText(), tableDesTypes);

                                }
                                else if (t.getChild(i).getText().equals("APPEL_FONCTION")) {
                                    Element elem=cMessage.methodCheck(type, t.getChild(1).getChild(0).getChild(0).getText(), tableDesTypes);
                                }
                                if (elem!= null) type=elem.getType();
                                else break;
                            }
                        }
                    }
                }



                secondPass(t.getChild(0), tds);
                dansMessage = true;
                for(int i=1;i<t.getChildCount();i++){
                    secondPass(t.getChild(i), tds);
                }
                dansMessage = false;
                break;

            case GrammaireParser.APPEL_FONCTION:
                if(t.getChild(0).getText().equals("super")){
//                    System.out.print("super");
                }
                else{
                    secondPass(t.getChild(0).getChild(0), tds);
                }
                Control cFonction = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);
                cFonction.numberOfParameters(t, tableDesTypes, tds);
                secondPass(t.getChild(1), tds);
                break;

            case GrammaireParser.FONCTION:
//                System.out.println("FONCTION Node");
                break;

            case GrammaireParser.DO:
                for(int i=0; i<t.getChildCount(); i++){
                    secondPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.STRING:
//                System.out.print("STRING = " + t.getChild(0).getText());
                if(t.getChildCount()>1){
//                    System.out.print(".");
                    secondPass(t.getChild(1), tds);
                }
                break;

            case GrammaireParser.SELECT:
                secondPass(t.getChild(0).getChild(0), tds);
//                System.out.print(".");
                secondPass(t.getChild(0).getChild(1), tds);
                break;


            case GrammaireParser.CLASSID:
//                System.out.print(t.getText());
                break;

            case 22: //INTEGER
//                System.out.print(t.getText());
                break;

            case GrammaireParser.ID:
//                System.out.print(t.getText());
                break;

            case 46: //+
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("+");
                secondPass(t.getChild(1), tds);
                break;

            case 45: //*
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("*");
                secondPass(t.getChild(1), tds);
                break;

            case 48: //-
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("-");
                secondPass(t.getChild(1), tds);
                break;

            case 50: // /
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("/");
                secondPass(t.getChild(1), tds);

//                Control cParam = new Control(t.getLine(), t.getCharPositionInLine(), "Illegal division : by 0 or by String, forbidden");
//                cParam.divide(t);
                break;

            case 55: // <>
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("<>");
                secondPass(t.getChild(1), tds);
                break;

            case 56: // =
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print("=");
                secondPass(t.getChild(1), tds);
                break;

            case GrammaireParser.MOINS_UNAIRE: //MOINS UNAIRE
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
//                System.out.print("-" + t.getChild(0).getText());
                break;


            case GrammaireParser.PLUS_UNAIRE: //PLUS UNAIRE
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
//                System.out.print("+" + t.getChild(0).getText());
                break;

            case GrammaireParser.CAST:
                Control cCast = new Control(t.getLine(), t.getCharPositionInLine(), "", debug);
                cCast.castValid(t, tds, tableDesTypes, currentClass, symbolsString, symbolsOpalg);
                secondPass(t.getChild(0), tds);
//                System.out.print(":");
                secondPass(t.getChild(1), tds);
                break;

            case 54: // <
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print(" < ");
                secondPass(t.getChild(1), tds);
                break;

            case 57: // >
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print(" > ");
                secondPass(t.getChild(1), tds);
                break;

            case 42: // &
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print(" & ");
                secondPass(t.getChild(1), tds);
                break;

            case 77: // ||
                c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
                secondPass(t.getChild(0), tds);
//                System.out.print(" || ");
                secondPass(t.getChild(1), tds);

            case 41: // &&
                /*c.checkOperationType(
                        t, tds, tableDesTypes,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );*/
                secondPass(t.getChild(0), tds);
//                System.out.print(" && ");
                secondPass(t.getChild(1), tds);

            case 67: //override
                //System.out.println(" " + t.getText());
                break;

            case 70: //static
                //System.out.println(" " + t.getText());
                break;

            case 73: //this
                //System.out.println(" " + t.getText());
                break;

            case 71: // super
                //System.out.println(" " + t.getText());
                break;

            case GrammaireParser.RESULT:

                break;

            default:
                if(debug == true){
                    System.out.println("Node type '" + t.getType() + "' does not exist!" + t.getText());
                }
        }

    }

}
