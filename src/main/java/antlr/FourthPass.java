package antlr;

import antlr.generatedClasses.GrammaireParser;
import assembly.*;
import objet.ElementObjet;

import org.antlr.runtime.tree.Tree;

import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FourthPass {

    private boolean debug;
    private boolean dansMessage = false; //variable qui permet de differencier une variable d'une sous variable dans un message
    private static int tds_counter_3rd_pass = -1;
    private String currentClass = "main";
    private String currentMethod;
    private static int else_etiquette = 0;
    private boolean premierLink = true;

    private EtiquetteGenerator etiquetteGenerator;

    private FileWriter writer;
    private WriterToFile writer_;

    public FourthPass(boolean debug, FileWriter fw, WriterToFile wtf, EtiquetteGenerator etiquetteGenerator) {
        this.debug = debug;
        this.writer = fw;
        this.writer_ = wtf;
        this.etiquetteGenerator = etiquetteGenerator;
    }

    public void launch(Tree tree, TDS tds) throws IOException {
        fourthPass(tree, tds);
        if(debug){
            System.out.println("fourth pass OK");
        }
    }

    public void fourthPass(Tree t, TDS tds) throws IOException{
        OperateurCondition c = new OperateurCondition(writer);
        String resultRegister = "R6";
        switch (t.getType()){
            case 31: //root node
                for(int i = 0; i<t.getChildCount();i++){
                    fourthPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.CLASSE:
                currentClass = t.getChild(0).getText();
                tds_counter_3rd_pass++;
                tds = SecondPass.listeTDS.get(tds_counter_3rd_pass);
                fourthPass(t.getChild(1), tds);
                for(int i=2; i<t.getChildCount();i++){
                    if(!t.getChild(i).getText().equals("EXTENDS")){
                        fourthPass(t.getChild(i), tds);
                    }

                }

                currentClass = "main";
//                tds_counter_3rd_pass--;
                break;

            case GrammaireParser.LIST_PARAM:
                boolean isClassParameter = t.getParent().getText().equals("CLASSE");
                boolean isMethodParameter = t.getParent().getText().equals("METHOD");

                for(int i=0; i<t.getChildCount();i++){
                    if(isClassParameter){ //parameter of a class

                    }
                    else if(isMethodParameter){

                    }
                    else{
                        fourthPass(t.getChild(i), tds);
                    }

                }
                break;

            case GrammaireParser.ATTRIBUT: //variable de classe
                break;

            case GrammaireParser.METHOD:
                tds_counter_3rd_pass++;
                tds = SecondPass.listeTDS.get(tds_counter_3rd_pass);;
                for(int i=1; i<t.getChildCount();i++){
                    fourthPass(t.getChild(i), tds);
                }


                if (t.getChild(1)!=null ) {
                    if(t.getChild(1).getText().equals("override")) {
                        for (int i=0;i<t.getParent().getChildCount();i++) {
                            if (t.getParent().getChild(i).getText().equals("EXTENDS")) {
                                String classeMere=t.getParent().getChild(i).getChild(0).getText();
                            }
                        }
                    }
                }

                if (t.getChild(2)!=null ) {
                    if(t.getChild(2).getText().equals("override")) {
                        for (int i=0;i<t.getParent().getChildCount();i++) {
                            if (t.getParent().getChild(i).getText().equals("EXTENDS")) {
                                String classeMere=t.getParent().getChild(i).getChild(0).getText();

                            }
                        }
                    }
                }


                break;

            case GrammaireParser.PARAM: // PAS A FAIRE CAR DEJA FAIT DANS LIST_PARAM

                fourthPass(t.getChild(0), tds);
                fourthPass(t.getChild(1), tds);
                if(t.getParent().getParent().getText().equals("METHOD")){

                }
                break;

            case GrammaireParser.EXTENDS:

                break;

            case GrammaireParser.BLOCK:

                if(currentClass.contentEquals("main")) {
                	if(premierLink)
                		premierLink = false;
                	else
                		writer.write(ToolsASM.link());
                }
                if(!t.getParent().getText().contentEquals("METHOD")) {
                    tds_counter_3rd_pass++;
                    tds = SecondPass.listeTDS.get(tds_counter_3rd_pass);
                }
                if(currentClass.contentEquals("main"))
                    VariableManipuation.variableDeclaration(tds, writer);
                // Generation du code assembleur pour la declaration et l'affectation des variables du bloc
                if (t.getParent().getType() == GrammaireParser.ROOT) {
                    // On est dans le bloc principal
                    //VariableManipuation.variableDeclaration(tds, writer);
                }

                if(!t.getParent().getText().equals("METHOD")){
                	
                    for(int i=0; i<t.getChildCount();i++){
                        fourthPass(t.getChild(i), tds);
                        
                    }

                }
                else{
                    for(int i=0; i<t.getChildCount();i++){
                        fourthPass(t.getChild(i), tds);
                    }
                }

                if (currentClass.contentEquals("main")) { 
                    writer.write(ToolsASM.unlink());
                }

                break;

            case GrammaireParser.AFFECTATION:
                // 46, 48, 45, 50, 77, 41, 56, 55, 54, 57, 26, 29  => Integers

                if(currentClass.contentEquals("main")) {
                    if(Arrays.binarySearch(ToolsASM.tab, t.getChild(0).getType()) >= 0){
                        fourthPass(t.getChild(0), tds);
                    }
                    if(Arrays.binarySearch(ToolsASM.tab, t.getChild(1).getType()) >= 0){
                        fourthPass(t.getChild(1), tds);
                    }

                    VariableManipuation.variableAffectation(t, tds, writer, currentClass); //affectation si bouleen

                }
//                if (t.getChild(0).getType() == GrammaireParser.VARIABLE) {
//                    if (t.getChild(1).getType() == GrammaireParser.T__46) {
//                        // On a une addition
////                        OperateurArithmetique.addition(t.getChild(1), tds,
////                                t.getChild(0).getChild(0).getText(), writer);
//                        Addition a = new Addition(writer,
//                                t.getChild(0).getChild(0).getText(),
//                                tds);
//                        a.makeOperation(t.getChild(1).getChild(0), "R1",
//                                t.getChild(1).getChild(1), "R2",
//                                false);
//                    }
//                }

                break;

            case GrammaireParser.VARIABLE:
                if(!dansMessage) {

                }
                fourthPass(t.getChild(0), tds);
                break;

            case GrammaireParser.VARIABLE_LOCALE:
                if(t.getChildCount() == 3){ //  VALUE
                    fourthPass(t.getChild(2), tds);
                }

                break;

            case GrammaireParser.VALUE:
                fourthPass(t.getChild(0), tds);
                if(currentClass.contentEquals("main"))
                    VariableManipuation.variableAffectationAndDeclare(t, tds,currentClass, writer); //affectation si bouleen
                break;

            case GrammaireParser.IDENTIFICATEUR:

                if (currentClass.equals(currentMethod) && t.getChild(0).getText().equals("RESULT")) {
                    fourthPass(t.getChild(0), tds);
                }

                if (t.getChild(0).getType() == GrammaireParser.RESULT) {
                }

                if (t.getChild(0).getText().equals("MESSAGE")){
                    fourthPass(t.getChild(0), tds);
                }


                break;

            case GrammaireParser.GROUP:
                fourthPass(t.getChild(0), tds);
                break;


            case GrammaireParser.NEW:
                fourthPass(t.getChild(0), tds);
                fourthPass(t.getChild(1), tds);
                break;

            case GrammaireParser.IF:
                etiquetteGenerator.else_etiquette = etiquetteGenerator.else_etiquette + 1;
                IfAndWhile if_ = new IfAndWhile(etiquetteGenerator.else_etiquette, writer, t.getChild(0), tds);
                fourthPass(t.getChild(0), tds);
                if(currentClass.contentEquals("main")) {
                    if_.writer_condition_code(currentClass);
                }
                fourthPass(t.getChild(1), tds);
                if(currentClass.contentEquals("main"))
                    if_.writer_jump_end_else();

                if(currentClass.contentEquals("main")) {
                    if_.writer_etiquette_else(); // etiquette pour sauter a else
                }
                fourthPass(t.getChild(2), tds);
                if(currentClass.contentEquals("main")){
                    if_.writer_jump_end_else_end(); //etiquette pour sauter depuis then
                }
                break;

            case GrammaireParser.CONDITION:
                fourthPass(t.getChild(0), tds);
                if(currentClass.contentEquals("main")) {

                    Tree t_ = t.getChild(0);
                    if(t.getChild(0).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
                        Tree t__ = t.getChild(0).getChild(0);
                        while(t__.getType() == GrammaireParser.GROUP){
                            t__ = t__.getChild(0);

                        }
                        t_ = t__;
                    }

//                    if (t_.getType() == GrammaireParser.T__46 ) {  //addition
//                        // On a une addition
////                        OperateurArithmetique.addition(t.getChild(1), tds,
////                                t.getChild(0).getChild(0).getText(), writer);
//                        Addition a = new Addition(writer,
//                                tds,
//                                "R1");
//                        a.makeOperation(t_.getChild(0), "R1",
//                                t_.getChild(1), "R2",
//                                true);
//                    }
                }
                break;

            case GrammaireParser.THEN: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                IfAndWhile if__ = new IfAndWhile(etiquetteGenerator.else_etiquette, writer, t, tds);

                for(int i=0; i<t.getChildCount(); i++){
                    fourthPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.ELSE: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                for(int i=0; i<t.getChildCount(); i++){
                    fourthPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.HERITED: //CREATION D UNE TDS SEULEMENT QUAND SUIVI D UN BLOCK
                fourthPass(t.getChild(0), tds);

                fourthPass(t.getChild(1), tds);
                break;

            case GrammaireParser.WHILE:
                IfAndWhile if____ = null;
                etiquetteGenerator.else_etiquette = etiquetteGenerator.else_etiquette + 1;
                if(currentClass.contentEquals("main")){
                    if____ = new IfAndWhile(etiquetteGenerator.else_etiquette, writer, t.getChild(0), tds);
                    if____.writer_etiquette_while_begin();
                }

                fourthPass(t.getChild(0), tds); //condition
                if(currentClass.contentEquals("main")) {
                    if____.writer_condition_code(currentClass);
                }
                fourthPass(t.getChild(1), tds); //do
                if(currentClass.contentEquals("main")) {
                    if____.writer_jump_begining_while();
                    if____.writer_jump_end_while_end();
                }
                break;

            case GrammaireParser.MESSAGE:
                if (t.getChild(0) != null && t.getChild(1) !=null) {

                    if (t.getChild(0).getText().equals("this")) {
                    }

                    if (t.getChild(0).getText().equals("super")) {
                    }
                }
                //seul un message finissant par appel_fonction a besoin d'etre genere
                if(t.getChild(t.getChildCount()-1).getType()==GrammaireParser.APPEL_FONCTION && currentClass.contentEquals("main")) {
                    Printer p = new Printer(writer);
                    if(!p.esperluateConcat_check(t.getChild(0))) {
                        ElementObjet obj = new ElementObjet(currentClass,t, "Objet");
                        //on a pas besoin du resultat dans R0 mais ce n'est pas grave si il y est
                        //donc on appelle cette fonction qui fait exactement ce que l'on veut
                        TasASM.attributDansR0(tds, obj, -1, false);
                    }
                }

                fourthPass(t.getChild(0), tds);
                dansMessage = true;
                for(int i=1;i<t.getChildCount();i++){
                    fourthPass(t.getChild(i), tds);
                }
                dansMessage = false;
                break;

            case GrammaireParser.APPEL_FONCTION:
                if(t.getChild(0).getText().equals("super")){
                }
                else{
                    fourthPass(t.getChild(0).getChild(0), tds);

                    Printer p = new Printer(writer);
                    if(currentClass.contentEquals("main"))
                        if(t.getChild(0).getChild(0).getText().equals("print")){

//	                        if(t.getParent().getText().equals("MESSAGE") && t.getParent().getParent().getText().equals("GROUP") && (p.esperluateConcat_check(t.getParent().getChild(0)) == true)){ //if string is like "coucou" (& "salut")*
//	                        	ElementObjet obj = new ElementObjet(p.esperluateConcat(t.getParent().getChild(0)), "String");
//	                            p.addPrintAVariable(obj, tds);
//	                        }
                            if(t.getParent().getText().equals("STRING")){ //thing like "coucou".print()
                                ElementObjet obj = new ElementObjet(t.getParent().getChild(0).getText(), "String");
                                p.addPrintAVariable(obj, tds);
                            }
                        }
                        else if(t.getChild(0).getChild(0).getText().equals("println")){ //same for prinln
//	                        if(t.getParent().getText().equals("MESSAGE") && t.getParent().getParent().getText().equals("GROUP") && (p.esperluateConcat_check(t.getParent().getChild(0)) == true) ){ //if string is like "coucou" (& "salut")*
//	                        	ElementObjet obj = new ElementObjet(p.esperluateConcat(t.getParent().getChild(0)), "String");
//	                            p.addPrintlnAVariable(obj, tds);
//	                        }
                            if(t.getParent().getText().equals("STRING")){
                                ElementObjet obj = new ElementObjet(t.getParent().getChild(0).getText(), "String");
                                p.addPrintlnAVariable(obj, tds);
                            }
                        }

                }
                fourthPass(t.getChild(1), tds);
                break;

            case GrammaireParser.FONCTION:
                break;

            case GrammaireParser.DO:
                for(int i=0; i<t.getChildCount(); i++){
                    fourthPass(t.getChild(i), tds);
                }
                break;

            case GrammaireParser.STRING:
                if(t.getChildCount()>1){
                    fourthPass(t.getChild(1), tds);
                }

                break;

            case GrammaireParser.SELECT:
                if(!dansMessage) {
                    ElementObjet obj = new ElementObjet(currentClass,t, "Objet");
                    //on a pas besoin du resultat dans R0 mais ce n'est pas grave si il y est
                    //donc on appelle cette fonction qui fait exactement ce que l'on veut
                    TasASM.attributDansR0(tds, obj, -1, false);
                }
                break;


            case GrammaireParser.CLASSID:
                break;

            case 22: //INTEGER
                break;

            case GrammaireParser.ID:
                break;

            case 46: //+

            case 45: //*

            case 48: //-

            case 50: // /
            	if(currentClass.contentEquals("main")) {
	                new OperateurArithmetique(writer, tds, t, resultRegister, currentClass);
	
	                if (ClimbUp.climbUp(t).getType() == GrammaireParser.AFFECTATION) {
	                    if (ClimbUp.climbUp(t).getChild(0).getType() == GrammaireParser.VARIABLE) {
	                        ToolsASM.changerVariableEtEcrire(writer,
	                                tds,
	                                ClimbUp.climbUp(t).getChild(0).getChild(0).getText(),
	                                resultRegister);
	                    } else if (ClimbUp.climbUp(t).getChild(0).getType() == GrammaireParser.MESSAGE) {
                            ElementObjet obj = new ElementObjet("",
                                    ClimbUp.climbUp(t).getChild(0),
                                    "Objet" );
                            TasASM.attributDansR0(tds,
                                    obj,
                                    -1,
                                    true);
                            writer.write("	LDW R6, (SP)\n"
        							+ "	ADQ 2, SP\n"
                            		+ "	STW " + resultRegister + ", (R0)\n");
                        }
	                }
            	}

                break;

            case 55: // <>


                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);
                    String R1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String R2=c.registre( writer,1,t,tds,currentClass);
                    c.different(t, R1,R2, writer, etiquetteGenerator.else_etiquette);
                }
                else{
                    fourthPass(t.getChild(0), tds);
                    fourthPass(t.getChild(1), tds);
                }

                break;

            case 56: // =


                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);
                    String re1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String re2=c.registre( writer,1,t,tds,currentClass);
                    c.egal(t, re1,re2, writer, etiquetteGenerator.else_etiquette);
                }

                else{
                    fourthPass(t.getChild(0), tds);
                    fourthPass(t.getChild(1), tds);
                }
                break;

            case GrammaireParser.MOINS_UNAIRE: //MOINS UNAIRE

                break;


            case GrammaireParser.PLUS_UNAIRE: //PLUS UNAIRE

                break;

            case GrammaireParser.CAST:
                fourthPass(t.getChild(0), tds);
                fourthPass(t.getChild(1), tds);
                break;

            case 54: // <


                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);

                    String r1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String r2=c.registre( writer,1,t,tds,currentClass);
                    c.inferieur(t, r1,r2, writer, etiquetteGenerator.else_etiquette);
                }

                else{
                    fourthPass(t.getChild(0), tds);
                    fourthPass(t.getChild(1), tds);
                }
                break;

            case 57: // >


                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);
                    String regi1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String regi2=c.registre( writer,1,t,tds,currentClass);
                    c.superieur(t, regi1,regi2, writer, etiquetteGenerator.else_etiquette);
                }

                else{
                    fourthPass(t.getChild(0), tds);
                    fourthPass(t.getChild(1), tds);
                }
                break;

            case 42: // &

                fourthPass(t.getChild(0), tds);
                fourthPass(t.getChild(1), tds);
                break;

            case 77: // ||

                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);
                    String registre1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String registre2=c.registre(writer,1,t,tds,currentClass);
                    c.ou(writer,registre1,registre2);
                }

                break;

            case 41: // &&


                if(currentClass.contentEquals("main")){
                    fourthPass(t.getChild(0), tds);
                    String reg1=c.registre( writer,0,t,tds,currentClass);
                    fourthPass(t.getChild(1), tds);
                    String reg2=c.registre(writer,1,t,tds,currentClass);
                    c.et(writer,reg1,reg2);
                }

                else{
                    fourthPass(t.getChild(0), tds);
                    fourthPass(t.getChild(1), tds);
                }

                break;

            case 67: //override
                break;

            case 70: //static
                break;

            case 73: //this
                break;

            case 71: // super
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
