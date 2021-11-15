package controls;

import antlr.generatedClasses.GrammaireParser;
import org.antlr.runtime.tree.Tree;

import tds.Element;
import tds.ElementMethod;
import tds.Pair;
import tds.TDS;
import tdt.ElementTDT;
import tdt.TDT;

import java.util.ArrayList;
import java.util.List;

public class Control {
    int line;
    int position;
    boolean debug;
    String message;

    public Control(int line, int position, String message, boolean debug) {
        this.line = line;
        this.position = position;
        this.message = message;
        this.debug = debug;
    }
    public void display(){
        System.out.println("line " + line + ":" + position + " " + message);

    }
    public void setMessage(String message) {
        this.message=message;
    }
    public void setLine(int line){this.line = line;}
    public void setPosition(int position){this.position = position;}

    public void typeCheck(String type,TDT tdt) {
        if (tdt.getType(type)==null) {
            this.display();
        }
    }

    public Element methodCheck(String type,String fct, TDT tdt) {
        this.message="Method '"+fct+"' doesn't exist in '"+type+"' type";
        Element elem;
        elem=tdt.get(type, "METHOD", fct);
        if (elem== null) {
            this.display();
            return null;
        }
        return elem;
    }

    public Element attributCheck(String type,String att, TDT tdt) {
        this.message="'"+att+"' doesn't exist in '"+type+"' type";
        Element elem;

        if ((elem=tdt.get(type, "attribut", att))== null) {
            this.display();
            return null;
        }
        return elem;
    }

    public void checkOverride(String methode,TDT tdt, String classeMere) {
        if ( tdt.get(classeMere, "METHOD", methode) == null) {
            this.display();
        }
    }

    public void resultInConstructor() {
        this.message="Use of result in a constructor : forbidden";
        this.display();
    }

    public int destMethod(Pair<Element, Integer> pair,String var) {
        if (pair==null) {
            this.message="Variable '"+var+"' is not defined before use";
            this.display();
            return 1;
        }
        return 0;
    }

    public void condition(Tree t, TDS tds, String currentClass, TDT tdt){
        if (t.getChild(0).getText().equals("STRING")) {
            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Condition must be an Integer, given: String", debug);
            c.display();
        }
        else if (t.getChild(0).getText().equals("&")) { //at the end it's a string
            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Condition must be an Integer, given: String", debug);
            c.display();
        }
        else if (t.getChild(0).getText().equals("VARIABLE")) { //at the end it's a string
//            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Condition must be an Integer, given: String");
//            c.display();
            Pair<Element, Integer> result = tds.getByName(t.getChild(0).getChild(0).getText(), GrammaireParser.VARIABLE, false);
            //already done in GrammaireParser.VARIABLE
            /*if(result == null){
                Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Variable " + t.getChild(0).getChild(0).getText() + " not declared before use");
                c.display();
            }
            else{*/
            if(result != null && !result.getFirst().getType().equals("Integer")){
                Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Variable '" + t.getChild(0).getChild(0).getText() + "' is of type : " + result.getFirst().getType() + ", required : Integer", debug);
                c.display();
            }
            //}
        }
        if(t.getChild(0).getText().equals("IDENTIFICATEUR")){
            if(t.getChild(0).getChild(0).getText().equals("MESSAGE")){
                if(t.getChild(0).getChild(0).getChild(1).getText().equals("VARIABLE")){
                    Element got = tdt.get(currentClass, "ATTRIBUT",  t.getChild(0).getChild(0).getChild(1).getChild(0).getText());
                    if(got != null){

                        if(!got.getType().equals("Integer")){
                            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Variable '" + t.getChild(0).getChild(0).getChild(1).getChild(0).getText() + "' is of type : " + got.getType() + ", required : Integer", debug);
                            c.display();
                        }
                    }
                    else{

                    }
                }
            }
        }
    }

    public void divide(Tree t){
        if(t.getChild(1).getText().equals("0")){
            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Division by 0 : forbidden", debug);
            c.display();
        }
        if(t.getChild(1).getText().equals("STRING") || t.getChild(1).getText().equals("&")){
            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Division by String : forbidden", debug);
            c.display();
        }
        if(t.getChild(0).getText().equals("STRING") || t.getChild(0).getText().equals("&")){
            Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Division of String : forbidden", debug);
            c.display();
        }
    }
    public void extendsCheck(Tree t, TDT tdt){
        String classToSearch = t.getChild(0).getText();
        if(tdt.getType(classToSearch) == null){
            this.display();
        }
    }
    public void attributCheck(Tree t, TDT tdt){
        String classToSearch = t.getChild(1).getText();
        if(tdt.getType(classToSearch) == null){
            this.display();
        }
    }

    public void numberOfParameters(Tree t, TDT tdt, TDS tds){
        if(t.getParent().getText().equals("MESSAGE")){
            if(t.getParent().getChild(0).getText().equals("VARIABLE")){
                Pair<Element, Integer> result = tds.getByName(t.getParent().getChild(0).getChild(0).getText(), GrammaireParser.VARIABLE, false); //search the definition of the instance of class used
                if(result == null){ // no definition found
//                    Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Variable " + t.getChild(0).getChild(0).getText() + " not declared before use");
//                    c.display();
                }
                else{
                    String type = result.getFirst().getType();
                    ElementTDT e = tdt.getType(type); //search for the class in the tdt
                    if(e == null){
//                        Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Variable " + t.getChild(0).getChild(0).getText() + " not declared before use");
//                        c.display();
                    }
                    else{
                        Element method = e.get("METHOD", t.getChild(0).getChild(0).getText()); //we search a method named t.getChild(0).getChild(0).getText()
                        if(method instanceof ElementMethod){ //is result found a method?
                            int expectedParamNumber = ((ElementMethod) method).getParamNumber();
                            int givenParamNumber = t.getChild(1).getChildCount();
                            if(expectedParamNumber != givenParamNumber){ //check if expected number of parameters = given number
                                Control c = new Control(t.getLine(), t.getCharPositionInLine(), "Method call on '" + t.getChild(0).getChild(0).getText() + "' incorrect number of parameters, expected : " + expectedParamNumber + ", given : " + givenParamNumber, debug);
                                c.display();
                            }
                        }
                    }
                }
            }
        }
    }

    public void nameClassCheck(Tree t, TDT tdt){ //check if a class is already defined
        String classToSearch = t.getChild(0).getText();
        if(tdt.getType(classToSearch) != null){
            this.display();
        }
    }

    public void resultCheck(Tree t){
        if(t.getChildCount() > 2){ //method with more than 2 children can have a return type
            if(
                    (t.getChild(t.getChildCount()-2).getType() != GrammaireParser.LIST_PARAM) &&
                            (t.getChild(t.getChildCount()-2).getType() != 67) && //override
                            (t.getChild(t.getChildCount()-2).getType() != 70) //|| //static

            ){ //method has a return type
                if(t.getChild(t.getChildCount() - 1).getType() == GrammaireParser.BLOCK){ //long method
                    findResult(t.getChild(t.getChildCount() - 1), true);
                    if(status == false){
                        Control c = new Control(line, position, "'result' required when precising return type", debug );
                        c.display();
                    }
                    if(isProblematic == true){
                        Control c = new Control(line, position, "'result' might have not been initialized", debug );
                        c.display();
                    }
                }
                else{ //short one
                    //TODO check if there's no semantic control to do in this case
                }
            }
        }

    }
    public boolean status = false; //is there a result in a METHOD?
    private boolean isProblematic = false; //cases where result might not have been set
    public void findResult(Tree t, boolean climb_up_boolean){
        for(int k = 0; k < t.getChildCount(); k++){
            Tree child = t.getChild(k);
            if(child.getType() == GrammaireParser.AFFECTATION){
                if(child.getChild(0).getType() == GrammaireParser.IDENTIFICATEUR){
                    if(child.getChild(0).getChild(0).getType() == GrammaireParser.RESULT){
                        if(child.getChild(0).getChild(0).getChild(0).getText().equals("result")){
                            Tree climb_up = t;
                            if(climb_up_boolean == true){
                                while(climb_up.getParent().getType() != GrammaireParser.METHOD){
                                    if(climb_up.getType() == GrammaireParser.IF){
                                        if(status == false){ //not already discovered
                                            Control c1 = new Control(0, 0, "", debug);
                                            c1.findResult(climb_up.getChild(1), false); //no go back up because we are already up
                                            boolean res1 = c1.status;
                                            Control c2 = new Control(0, 0, "", debug);
                                            c2.findResult(climb_up.getChild(2), false);
                                            boolean res2 = c2.status;
                                            if(res1 == true && res2 == true){ //no problem, defined in both THEN and ELSE

                                            }
                                            else{ //not found in one branch
                                                isProblematic = true;
                                            }

                                        }
                                    }
                                    if(climb_up.getType() == GrammaireParser.WHILE){
                                        if(status == false){ //not already discovered
                                            isProblematic = true;
                                        }
                                    }
                                    climb_up = climb_up.getParent();
                                }
                            }
                            status = true;
                        }
                    }

                }
            }
            findResult(child, climb_up_boolean);
        }
    }

    public void hasAlreadyConstructor(Tree t, TDS tds){ //check if a class is already defined
        if(tds.hasConstructor(t.getChild(0).getText())){
            this.display();
        }
    }

    public void callOnConstructor(Tree t, TDS tds, TDT tdt){
        try{
            String constructorName = t.getChild(0).getText();
            Element constructorElement = tdt.getType(constructorName).get("METHOD", constructorName); //search for constructor
            int nbOfConstructorParamsExpected = ( (ElementMethod) constructorElement).getParamNumber();
            int nbOfConstructorParamsGiven = t.getChild(1).getChildCount();
            if ( nbOfConstructorParamsExpected != nbOfConstructorParamsGiven ){
                Control name = new Control(this.line, this.position, "Call on constuctor does not constructor signature, incorrect number of parameters, expected : " + nbOfConstructorParamsExpected + ", given : " + nbOfConstructorParamsGiven, debug);
                name.display();
            }
            else{
                boolean parametersTypesAreConform = true;
                for(int i = 0; i<nbOfConstructorParamsExpected; i++){

                    if( ((ElementMethod) constructorElement).getParam().get(i).equals(null )){
                        if(! ( (ElementMethod) constructorElement).getParam().get(i).equals(tds.getByNameCurrentTable(t.getChild(1).getChild(i).getChild(0).getText(),GrammaireParser.ATTRIBUT).getType())){
                            parametersTypesAreConform = false;
                            break;
                        }
                        if ( parametersTypesAreConform == false ){
                            Control name = new Control(this.line, this.position, "Call on constuctor does not constructor signature, incorrect number of parameters, expected : " + ( (ElementMethod) constructorElement).getParam(), debug);
                            name.display();
                        }
                    }



                }

            }
        }
        catch (NullPointerException e){

        }

    }

    public void isConstructorOK(Tree t){ //check if constructor is OK
        if(Character.isUpperCase(t.getChild(0).getText().charAt(0))){ //Constructor?
            if(!t.getParent().getChild(0).getText().equals(t.getChild(0).getText())){ //Name
                Control name = new Control(this.line, this.position, "Constuctor name does not match Class name, expected : " + t.getParent().getChild(0).getText() + ", given : " + t.getChild(0).getText(), debug);
                name.display();
            }

            int classNumberOfParameters;
            if(t.getParent().getChild(1).getType() != GrammaireParser.LIST_PARAM){
                classNumberOfParameters = 0;
            }
            else{
                classNumberOfParameters = t.getParent().getChild(1).getChildCount();
            }
            int constructorNumberOfParameters = t.getChild(1).getChildCount();
            Control incorrectNumber = new Control(this.line, this.position, "Constuctor parameters number does not match Class parameters, expected : " + classNumberOfParameters + ", given : " + constructorNumberOfParameters, debug);
            if(t.getChild(1).getText().equals("LIST_PARAM")){ //Params
                if(t.getParent().getChildCount() > 0){
                    if(t.getParent().getChild(1).getText().equals("LIST_PARAM")){
                        if(classNumberOfParameters == constructorNumberOfParameters){
                            //OK
                            boolean typeAndName = true;
                            String paramsClasse = "(";
                            String paramsConstructor = "(";
                            for(int i= 0; i<classNumberOfParameters; i++){
                                if(!( t.getParent().getChild(1).getChild(i).getChild(0).getText().equals(t.getChild(1).getChild(i).getChild(0).getText()) && t.getParent().getChild(1).getChild(i).getChild(1).getText().equals(t.getChild(1).getChild(i).getChild(1).getText()) ) ){
                                    typeAndName = false;
                                }
                                paramsClasse = paramsClasse + " " + t.getParent().getChild(1).getChild(i).getChild(0).getText() + ":" + t.getParent().getChild(1).getChild(i).getChild(1).getText();
                                paramsConstructor = paramsConstructor + " " + t.getChild(1).getChild(i).getChild(0).getText() + ":" + t.getChild(1).getChild(i).getChild(1).getText();

                            }
                            paramsClasse = paramsClasse + " )";
                            paramsConstructor = paramsConstructor + " )";
                            if(typeAndName == false){

                                Control incorrectParams = new Control(this.line, this.position, "Constuctor parameters " + "does not match, expected : " + paramsClasse + ", given : " + paramsConstructor, debug);
                                incorrectParams.display();

                            }
                        }
                        else{
                            incorrectNumber.display();
                        }
                    }
                    else{
                        incorrectNumber.display();
                    }
                }
                else{
                    incorrectNumber.display();
                }

            }
            else{
                if(t.getParent().getChild(1).getText().equals("LIST_PARAM")){
                    incorrectNumber.display();
                }
            }


        }

    }

    public void checkAffectation(
            Tree t,
            TDS tds,
            TDT tdt,
            String currentClass,
            String currentMethod,
            List<Integer> symbolsInt,
            List<Integer> symbolsString) {

//        System.out.println("AFFECTATION : entrée l" + line);

        boolean doCheckResult   = false;
        int noeudGauche         = t.getChild(0).getType();
        Tree t_ = t.getChild(1);
        if(t.getChild(1).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
            Tree t__ = t_;
            while(t__.getType() == GrammaireParser.GROUP){
                if (  t_.getChild(0).getType() == GrammaireParser.CAST || t_.getChild(0).getType() == GrammaireParser.MESSAGE ){
                    break;
                }
                t__ = t__.getChild(0);

            }
            t_ = t__;
        }
        int noeudDroit          = t_.getType();
        String texteGauche      = "";
        String texteDroit       = "";
        String typeGauche       = "";
        String typeDroit        = "";
        Pair<Element, Integer> toTestIfNullTDS = null;
        Element toTestIfNullTDT = null;
        // On détermine typeGauche
        if (noeudGauche == GrammaireParser.IDENTIFICATEUR) {
            if (t.getChild(0).getChild(0).getType() == GrammaireParser.RESULT) {
                // Vérification que le type de result soit le meme que le type de retour de la méthode
                doCheckResult = true;
                toTestIfNullTDT = tdt.get(currentClass, "METHOD", currentMethod);
                if (toTestIfNullTDT != null) {
                    typeGauche = toTestIfNullTDT.getType();
                    if (typeGauche == null)
                        return;
                } else {
                    if (debug)
                        System.out.println("[AFFECTATION -> IDENTIFICATEUR -> RESULT] Méthode non trouvée : " + currentMethod);
                    return;
                }
            } else {
                texteGauche = t.getChild(0).getChild(0).getChild(1).getText();
                if (t.getChild(0).getChild(0).getType() == GrammaireParser.MESSAGE) {
                    Tree msg = t.getChild(0).getChild(0);
                    texteGauche = msg.getChild(msg.getChildCount()-1).getChild(0).getText();
                    if (texteGauche.equals("FONCTION")) {
                        this.setMessage("Can't assign value to a function");
                        this.display();
                        return;
                    }
                } else {
                    if (debug)
                        System.out.println("[CTRL AFFECTATION -> IDENTIFICATEUR] Si ceci s'affiche ce n'est pas normal. (GAUCHE) " + noeudGauche);
                }
//                System.out.println("/////// Current class = " + currentClass + " " + texteGauche + " ///////// ");
//                System.out.println( tdt.getType(currentClass));
//                tdt.display();
                toTestIfNullTDT = tdt.get(currentClass, "ATTRIBUT", texteGauche);
                if (toTestIfNullTDT != null) {

                    typeGauche = toTestIfNullTDT.getType();
                } else {
                    return;
                }
            }
        } else if (noeudGauche == GrammaireParser.VARIABLE) {
            toTestIfNullTDS = tds.getByName(
                    t.getChild(0).getChild(0).getText(),
                    GrammaireParser.VARIABLE, false);
            if (toTestIfNullTDS != null) {
                typeGauche = toTestIfNullTDS.getFirst().getType();
            } else {
                return;
            }
        }

        else if (noeudGauche == GrammaireParser.GROUP) {
            if (t.getChild(0).getChild(0).getType() == GrammaireParser.CAST) {
                typeGauche = t.getChild(0).getChild(0).getChild(0).getText();
            } else if (t.getChild(0).getChild(0).getType() == GrammaireParser.MESSAGE) {
                if (t.getChild(0).getChild(0).getChild(0).getType() == GrammaireParser.CAST) {
                    currentClass = t.getChild(0).getChild(0).getChild(0).getChild(0).getText();
                }
                texteGauche = t.getChild(0).getChild(0).getChild(1).getChild(0).getText();
                toTestIfNullTDT = tdt.get(currentClass, "ATTRIBUT", texteGauche);
                if (toTestIfNullTDT != null) {
                    typeGauche = toTestIfNullTDT.getType();
                } else {
                    return;
                }
            }
            else {
                if (debug)
                    System.out.println("[CTRL AFFECTATION -> GROUP] Si ceci s'affiche ce n'est pas normal. (GAUCHE) " + noeudGauche);
            }
        }
        else if(noeudGauche == GrammaireParser.MESSAGE){
            texteGauche = t.getChild(0).getChild(0).getChild(0).getText();
            if(!currentClass.equals("main")){
                toTestIfNullTDT = tdt.get(currentClass, "ATTRIBUT", texteGauche);
                if (toTestIfNullTDT != null) {
                    typeGauche = toTestIfNullTDT.getType();
                } else {
                    return;
                }
            }
            else{
                texteGauche = t.getChild(0).getChild(0).getChild(0).getText();
                Element e = tds.getByNameCurrentTable(texteGauche, GrammaireParser.METHOD);
                String typeGauche_generic = "";
                for(Element entry : tds.table){
                    entry.getNom();
                    if(texteGauche.equals(entry.getNom())){
                        typeGauche_generic = entry.getType();
                    }

                }
                for(int i=1; i<t.getChild(0).getChildCount(); i++){
                    toTestIfNullTDT = tdt.get(typeGauche_generic, "ATTRIBUT", t.getChild(0).getChild(i).getChild(0).getText());
                    if (toTestIfNullTDT != null) {
                        typeGauche = toTestIfNullTDT.getType();
                    } else {
                        return;
                    }
                    typeGauche_generic = typeGauche;
                }
            }

        }
        else if(noeudGauche == GrammaireParser.SELECT){
            if(t.getChild(0).getChild(0).getType() == GrammaireParser.MESSAGE){
                Element tdt_elt = null;
                if(t.getChild(0).getChild(0).getChild(1).getType() == GrammaireParser.VARIABLE){
                    tdt_elt = tdt.get(t.getChild(0).getChild(0).getChild(0).getText(), "ATTRIBUT", t.getChild(0).getChild(0).getChild(1).getChild(0).getText());
                }
                if(tdt_elt != null){
                    typeGauche = tdt_elt.getType();
                }
            }
        }
        else {
            if (debug)
                System.out.println("[CTRL AFFECTATION] Si ceci s'affiche ce n'est pas normal. (GAUCHE) " + noeudGauche);
        }

        // ----------------------
        // On determine typeDroit

        if (symbolsInt.contains(noeudDroit) ||
                noeudDroit == GrammaireParser.INT ||
                noeudDroit == GrammaireParser.PLUS_UNAIRE ||
                noeudDroit == GrammaireParser.MOINS_UNAIRE
        ) {
            typeDroit = "Integer";
        } else if (symbolsString.contains(noeudDroit)) {
            typeDroit = "String";
        } else if (noeudDroit == GrammaireParser.VARIABLE) {
            toTestIfNullTDS = tds.getByName(t_.getChild(0).getText(), GrammaireParser.VARIABLE, false);
            if (toTestIfNullTDS != null) {
                typeDroit = toTestIfNullTDS.getFirst().getType();
            } else {
                return;
            }
        } else if (noeudDroit == GrammaireParser.STRING) {
            typeDroit = "String";
        } else if (noeudDroit == GrammaireParser.NEW) {
            typeDroit = t_.getChild(0).getText();
        } else if (noeudDroit == GrammaireParser.IDENTIFICATEUR) {
//            System.out.println("Current method = " + currentMethod);
            if (t_.getChild(0).getType() == GrammaireParser.RESULT) {
                toTestIfNullTDT = tdt.get(currentClass, "METHOD", currentMethod);
                if (toTestIfNullTDT != null) {
                    typeDroit = toTestIfNullTDT.getType();   // Permet de vérifier le type de la valeur de retour d'une méthode
                } else {
                    return;
                }
            } else if (t_.getChild(0).getType() == GrammaireParser.MESSAGE) {
                Tree msg = t_.getChild(0);
                Tree msgLast = msg.getChild(msg.getChildCount() - 1);
                if (msgLast.getType() == GrammaireParser.APPEL_FONCTION) {
                    texteDroit = msgLast.getChild(0).getChild(0).getText();
                    toTestIfNullTDT = tdt.get(currentClass, "METHOD", texteDroit);
                    if (toTestIfNullTDT != null) {
                        typeDroit = toTestIfNullTDT.getType();
                    } else {
                        return;
                    }
                } else {
                    texteDroit = msgLast.getChild(0).getText();
                    toTestIfNullTDT = tdt.get(currentClass, "ATTRIBUT", texteDroit);
                    if (toTestIfNullTDT != null) {
                        typeDroit = toTestIfNullTDT.getType();
                    } else {
                        return;
                    }
                }
            } else if (t_.getChild(0).getText().equals("this")) {
                typeDroit = currentClass;
            } else {
                if (debug)
                    System.out.println("[CTRL AFFECTATION -> IDENTIFICATEUR] Si ceci s'affiche ce n'est pas normal. (DROITE) " + noeudDroit + " l" + line);
            }
        } else if (noeudDroit == GrammaireParser.MESSAGE) {
            if (currentClass.compareTo("main") == 0) {
                currentClass = tds.getByName(t_.getChild(0).getChild(0).getText(), GrammaireParser.VARIABLE, false).getFirst().getType();
            }

            if (t_.getChild(1).getType() == GrammaireParser.APPEL_FONCTION) {
                texteDroit = t_.getChild(1).getChild(0).getChild(0).getText();
                toTestIfNullTDT = tdt.get(currentClass, "METHOD", texteDroit);
                if (toTestIfNullTDT != null) {
                    typeDroit = toTestIfNullTDT.getType();
                } else {
                    return;
                }
            } else if (t_.getChild(1).getType() == GrammaireParser.VARIABLE) {
                toTestIfNullTDT = tdt.get(currentClass, "ATTRIBUT", texteDroit);
                if (toTestIfNullTDT != null) {
                    typeDroit = toTestIfNullTDT.getType();
                } else {
                    return;
                }
            } else {
                if (debug)
                    System.out.println("[CTRL AFFECTATION -> MESSAGE] Si ceci s'affiche ce n'est pas normal. (DROITE) " + noeudDroit);
            }
        }
        else if (noeudDroit == GrammaireParser.GROUP) {
            Tree grp = t_;
            if (grp.getChild(0).getType() == GrammaireParser.CAST) {
                typeDroit = grp.getChild(0).getChild(0).getText();
            }
            if(t_.getChild(0).getType() == GrammaireParser.MESSAGE){
                if(t_.getChild(0).getChild(1).getType() == GrammaireParser.APPEL_FONCTION){
                    if(t_.getChild(0).getChild(1).getChild(0).getType() == GrammaireParser.FONCTION){
                        if(t_.getChild(0).getChild(1).getChild(0).getChild(0).getText().equals("toString")){
                            typeDroit = "String";
                        }
                    }
                }
            }
            else {
                if (debug)
                    System.out.println("[CTRL AFFECTATION -> GROUP] Si ceci s'affiche ce n'est pas normal. (DROITE) " + noeudDroit);
            }
        }
        else if (noeudDroit == GrammaireParser.SELECT){ //for static

            if(t_.getChild(0).getType() == GrammaireParser.MESSAGE){
                Element tdt_elt = null;
                if(t_.getChild(0).getChild(1).getType() == GrammaireParser.VARIABLE){
                    tdt_elt = tdt.get(t_.getChild(0).getChild(0).getText(), "ATTRIBUT", t_.getChild(0).getChild(1).getChild(0).getText());
                }
                if(tdt_elt != null){
                    typeDroit = tdt_elt.getType();
                }
            }
        }
        else {
            if (debug)
                System.out.println("[CTRL AFFECTATION] Si ceci s'affiche ce n'est pas normal. (DROITE) " + noeudDroit);
        }
//        System.out.println("AFFECTATION : " + typeGauche + " , " + typeDroit);
        //-----------------------------------------
        // On regarde si le flag de result est a vrai
        if (doCheckResult) {
            Control cResult = new Control(line, position, "Return type doesn't match with signature", debug);
//            System.out.println("check this out '" + typeGauche + "' '" + typeDroit +"'");
            if (!typeGauche.equals(typeDroit) && !checkTypeParents(tdt, typeGauche, typeDroit)) {
                cResult.setMessage("Return type ('"+typeGauche+"') doesn't match with signature ('"+typeDroit+"')");
                cResult.display();
            }
            return;
        }
        // On verifie si les types sont compatibles
        if (typeGauche.compareTo(typeDroit) != 0 && !checkTypeParents(tdt, typeGauche, typeDroit)) {
            this.setMessage("Can't store '" + typeDroit + "' into variable of type '" + typeGauche + "'");
            this.display();
        }
    }

    private boolean checkTypeParents(TDT tdt, String typeGauche, String typeDroit) {
//      System.out.println("TEST : " + typeGauche + "," + typeDroit + "," + tdt.getType(typeDroit).getTypeHeritage());
        if (typeGauche.compareTo(typeDroit) == 0) {  // La classe a tester est super-classe de classe
            return true;
        } else {
            try {
                if (tdt.getType(typeDroit).getTypeHeritage() == null) {
                    return false;
                } else {
                    return checkTypeParents(tdt, typeGauche, tdt.getType(typeDroit).getTypeHeritage());
                }
            } catch (NullPointerException e) {
//                e.printStackTrace();
                return false;
            }
        }
    }

    //check if a local_variable / attribute / param / method is already defined
    //also triggers a keyword control to check if this/super/result is used as name
    public void alreadyDeclared(Tree t, TDS tds) {
        if(tds.getByNameCurrentTable(t.getChild(0).getText(), t.getType())!= null) {
            this.display();
        }
    }
    //useless already done in antlr
    //check if this/super/result is used as name
    /*public void keyword(Tree t, TDS tds) {
    	if(t.getChild(0).getText().contentEquals("this") 
    			|| t.getChild(0).getText().contentEquals("super") 
    			|| t.getChild(0).getText().contentEquals("result")) {
    		this.display();
    	}
    }*/

    //check if a variable was declared before behind used
    public void isNotDeclared(Tree t, TDS tds, boolean isInAMethod) {
    	if(t.getChild(0).getType() != GrammaireParser.APPEL_FONCTION) {
    		Pair<Element, Integer> pair = null;
	    	if(!isInAMethod) {
	             pair = tds.getByName(t.getChild(0).getText(),GrammaireParser.VARIABLE, false);
	    	}
	    	else {
	    		pair = tds.getByName(t.getChild(0).getText(),GrammaireParser.VARIABLE, true);
	    	}
	    	if(pair == null) {
	            this.display();
	        }
    	}
        
    }

    private String getTypeMessage(Tree t, TDS tds, TDT tdt, String previousType) {
        for(int i =0; i<t.getChildCount();i++) {
            if(t.getChild(i).getType() == GrammaireParser.VARIABLE) {
                if(previousType == null) {
                    Pair<Element, Integer> pair = tds.getByName(t.getChild(i).getChild(0).getText(), GrammaireParser.VARIABLE, false);
                    if(pair != null) {//controle isNotDeclared
                        previousType = pair.getFirst().getType();
                    }
                    else
                        break;
                }
                else {
                    Element e = tdt.get(previousType, "VARIABLE", t.getChild(i).getChild(0).getText());
                    if(e != null) {
                        previousType = e.getType();
                    }
                    else {
                        this.message = "Attribut '"+t.getChild(i).getChild(0).getText()+"' does not exist in class '"+previousType+"'";
                        this.display();
                        break;
                    }
                }
            }
            else {
                if(t.getChild(i).getType() == GrammaireParser.APPEL_FONCTION){//methode
                    Element e = tdt.get(previousType, "METHOD", t.getChild(i).getChild(0).getChild(0).getText());
                    if(e != null) {
                        previousType = e.getType();
                    }
                    else {
                        this.message = "Method '"+t.getChild(i).getChild(0).getChild(0).getText()+"' does not exist in class '"+previousType+"'";
                        this.display();
                        break;
                    }
                }
            }
        }
        return previousType;
    }
    public void castValid(Tree t, TDS tds, TDT tdt, String currentClass, List<Integer> symbolsString,List<Integer> symbolsOpalg) {
        String typeCast = t.getChild(0).getText();
        String typeMessage  = null;
        t = t.getChild(1);
        if(symbolsString.contains(t.getType()))
        	typeMessage = "String";
        if(symbolsOpalg.contains(t.getType()))
        	typeMessage = "Integer";
        if(t.getType() == GrammaireParser.IDENTIFICATEUR)//this ou super
            t = t.getChild(0);
        if(t.getType() == GrammaireParser.VARIABLE) {//variable
            Pair<Element, Integer>pair = tds.getByName(t.getChild(0).getText(), GrammaireParser.VARIABLE, false);
            if(pair != null)
                typeMessage = pair.getFirst().getType();
        }
        else {
        	if(t.getType() == GrammaireParser.MESSAGE)
	            if(currentClass.equals("main"))
	                typeMessage = getTypeMessage(t, tds, tdt, null);
	            else
	                typeMessage = getTypeMessage(t, tds, tdt, currentClass);
            this.message = "Cannot cast to '"+typeCast+"'";
        }

        if(typeMessage == null) {
            this.display();
        }
        else {
            this.message = "Cannot cast '"+typeMessage+"' to '"+typeCast+"'";
            if(!checkTypeParents(tdt, typeCast, typeMessage))
                this.display();
        }

        //

    }

    public void checkOperationType(Tree t,
                                   TDS tds,
                                   TDT tdt,
                                   String currentClass,
                                   String currentMethod,
                                   List<Integer> symbolsString,
                                   List<Integer> symbolsOpalg) {
        if (t.getType() == GrammaireParser.MOINS_UNAIRE ||
        t.getType() == GrammaireParser.PLUS_UNAIRE) {
            String typeDroit = checkOperationTypeRec(
                    t.getChild(0),
                    tds, tdt, currentClass, currentMethod,
                    symbolsString, symbolsOpalg
            );
            if (!typeDroit.equals("Integer")) {
                this.setMessage("Unable to perform operation " +
                        GrammaireParser.tokenNames[t.getType()] + " " +
                        "for type '" + typeDroit + "'");
                this.display();
            }
        } else {
            String typeGauche = checkOperationTypeRec(
                    t.getChild(0),
                    tds,
                    tdt,
                    currentClass,
                    currentMethod,
                    symbolsString,
                    symbolsOpalg
            );
            String typeDroit = checkOperationTypeRec(
                    t.getChild(1),
                    tds,
                    tdt,
                    currentClass,
                    currentMethod,
                    symbolsString,
                    symbolsOpalg
            );
//        System.out.println("[OPALG l"+ line + "] tg = " + typeGauche + "(" + t.getChild(0).getText() + ")" +
//                " td = " + typeDroit + "(" + t.getChild(1).getText() + ")");
            try {
                if (!typeDroit.equals(typeGauche) /*&& !checkTypeParents(tdt, typeGauche, typeDroit)*/) {
                    if (!(typeGauche == null)) {
                        this.setMessage("Unable to perform operation " +
                                GrammaireParser.tokenNames[t.getType()] + " " +
                                "between type '" + typeGauche + "' and type '" + typeDroit + "'");
                        this.display();
                    }
                }
            } catch (NullPointerException e) {
//                e.printStackTrace();
            }
        }
    }

    public String checkOperationTypeRec(Tree curNoeud,
                                        TDS tds,
                                        TDT tdt,
                                        String currentClass,
                                        String currentMethod,
                                        List<Integer> symbolsString,
                                        List<Integer> symbolsOpalg) {
        // Conditions de sortie :
        //      - Int, String, Identificateur, Select, Group (cast), Variable, Message
        // Conditions de poursuite :
        //      - Operateur, Plus unaire, Moins unaire, Group (sauf cast)
//        System.out.println("line " + line + " " + curNoeud);
        if (curNoeud.getType() == GrammaireParser.INT) {
            return "Integer";
        } else if (curNoeud.getType() == GrammaireParser.STRING) {
            return "String";
        } else if (curNoeud.getType() == GrammaireParser.IDENTIFICATEUR) {
            Tree lmn = curNoeud.getChild(0); // Noeud le plus a gauche
            if (lmn.getType() == GrammaireParser.RESULT) {
                // On récupère le type de la méthode courante
                try {
                    String tmp = tdt.get(currentClass, "METHOD", currentMethod).getType();
//                    System.out.println(tmp);
                    return tmp;
                } catch (NullPointerException e) {
//                    e.printStackTrace();
                    if (debug)
                        System.out.println("[OPALG -> IDENTIFICATEUR -> RESULT] Impossible de récupérer le type de la méthode courante");
                    return null;
                }
            } else if (lmn.getType() == GrammaireParser.MESSAGE) {
                // On récupère le type de retour du message
                return getMessageType(lmn, tds, tdt, currentClass, currentMethod,
                        symbolsString, symbolsOpalg);
            } else {
                if (debug)
                    System.out.println("[OPALG -> IDENTIFICATEUR] Structure non reconnue");
                return null;
            }
        } else if (curNoeud.getType() == GrammaireParser.SELECT) {
            // Il s'agit d'un appel d'une méthode statique sur une classe, je récupère le type de retour de cette méthode
            return getMessageType(curNoeud.getChild(0), tds, tdt, currentClass, currentMethod,
                    symbolsString, symbolsOpalg);
        } else if (curNoeud.getType() == GrammaireParser.GROUP) {
            Tree nextNode = curNoeud.getChild(0);
            if (nextNode.getType() == GrammaireParser.CAST) {
                // il s'agit d'un cast, je récupère le type du cast
                return nextNode.getChild(0).getText();
            } else {
                // ca peut etre n'importe quoi, je poursuis la récursion
                return checkOperationTypeRec(
                        curNoeud.getChild(0),
                        tds,
                        tdt,
                        currentClass,
                        currentMethod,
                        symbolsString,
                        symbolsOpalg
                );
            }
        } else if (curNoeud.getType() == GrammaireParser.VARIABLE) {
            // Il s'agit d'une variable, je récupère simplement son type
            String variable = curNoeud.getChild(0).getText();
            try {
                String tmp = tds.getByName(variable, GrammaireParser.VARIABLE, false).getFirst().getType();
                return tmp;
            } catch (NullPointerException e) {
                //e.printStackTrace();
                if (debug)
                    System.out.println("[OPALG -> VARIABLE] Impossible de récupérer la variable dans la TDS");
                return null;
            }
        } else if (curNoeud.getType() == GrammaireParser.MESSAGE) {
            // Il s'agit d'un message
            return getMessageType(curNoeud, tds, tdt,
                    currentClass, currentMethod, symbolsString, symbolsOpalg);
        } else {
            // On reste dans la récurrence
            if (curNoeud.getType() == GrammaireParser.PLUS_UNAIRE ||
            curNoeud.getType() == GrammaireParser.MOINS_UNAIRE ||
            symbolsString.contains(curNoeud.getType())) {
                // On rappelle la fonction sur l'unique fils
                return checkOperationTypeRec(
                        curNoeud.getChild(0),
                        tds, tdt,
                        currentClass, currentMethod,
                        symbolsString, symbolsOpalg
                );
            } else if (symbolsOpalg.contains(curNoeud.getType())) {
                // On rappelle la fonction sur les deux fils
                String typeGauche = checkOperationTypeRec(
                        curNoeud.getChild(0),
                        tds,
                        tdt,
                        currentClass,
                        currentMethod,
                        symbolsString,
                        symbolsOpalg
                );
                String typeDroit = checkOperationTypeRec(
                        curNoeud.getChild(1),
                        tds,
                        tdt,
                        currentClass,
                        currentMethod,
                        symbolsString,
                        symbolsOpalg
                );
//                System.out.println("[IN REC] tg = " + typeGauche + " td = " + typeGauche);
                if (!typeDroit.equals(typeGauche) /*&& !checkTypeParents(tdt, typeGauche, typeDroit)*/) {
                    // if (!(typeDroit.equals("null") || typeGauche.equals("null"))) {
//                    if (!(typeGauche == null)) {
//                        this.setMessage("Unable to perform operation " +
//                                GrammaireParser.tokenNames[curNoeud.getType()] + " " +
//                                "between type '" + typeGauche + "' and type '" + typeDroit + "'.");
//                        this.display();
//                    }
                    return null;
                } else {
                    return typeDroit;
                }
            } else {
                if (debug)
                    System.out.println("[OPALG -> REC] Opérateur non reconnu");
                return null;
            }
        }
    }

    public String getMessageSourceType(Tree msgNode,
                                       TDS tds,
                                       TDT tdt,
                                       String currentClass,
                                       String currentMethod,
                                       List<Integer> symbolsString,
                                       List<Integer> symbolsOpalg) {
        String classAChercher = "";
        Tree source = msgNode.getChild(0);

        if (source.getType() == GrammaireParser.CLASSID) {
            // C'est la classe dans laquelle chercher
            classAChercher = source.getText();
        } else if (source.getType() == GrammaireParser.ID) {
            // Il faut trouver le type de ID
            try {
                classAChercher = tds.getByName(source.getText(), GrammaireParser.VARIABLE, false).getFirst().getType();
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE -> ID] Source inconnue");
            }
        } else if (source.getText().equals("this")) {
            // C'est la currentClass
            if (!currentClass.equals("main")) {
                classAChercher = currentClass;
            } else {
                return null;
            }
        } else if (source.getText().equals("super")) {
            // c'est dans la super classe
            try {
                classAChercher = tdt.getType(currentClass).getTypeHeritage();
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE -> HERITAGE] Source inconnue");
            }
            if (classAChercher == null) {
                if (debug)
                    System.out.println("[MESSAGE] Super alors qu'il n'y a pas de super classe.");
                return null;
            }
        } else if (source.getType() == GrammaireParser.GROUP) {
            // c'est dans le type du groupe
            classAChercher = checkOperationTypeRec(source,
                    tds, tdt, currentClass, currentMethod,
                    symbolsString, symbolsOpalg
            );
        } else if (source.getType() == GrammaireParser.CAST) {
            // c'est le type du cast
            classAChercher = source.getChild(0).getText();
        } else if (source.getType() == GrammaireParser.RESULT) {
            // type de retour de la fonction
            try {
                classAChercher = tdt.get(currentClass, "METHOD", currentMethod).getType();
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE -> ID] Source inconnue");
            }
        } else if (symbolsOpalg.contains(source.getType())) {
            classAChercher = "Integer";
        } else if (symbolsString.contains(source.getType())) {
            classAChercher = "String";
        } else if (source.getType() == GrammaireParser.VARIABLE) {
            // Il faut trouver le type de VARIABLE
            try {
                classAChercher = tds.getByName(source.getChild(0).getText(), GrammaireParser.VARIABLE, false).getFirst().getType();
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE -> VARIABLE] Source inconnue");
            }
        } else {
            // Là tu me pose une colle
            if (debug)
                System.out.println("[MESSAGE] Source inconnue - l" + line + " - s = " + source.getText());
            return null;
        }

        return classAChercher;
    }

    public String getMessageType(Tree msgNode,
                                 TDS tds,
                                 TDT tdt,
                                 String currentClass,
                                 String currentMethod,
                                 List<Integer> symbolsString,
                                 List<Integer> symbolsOpalg) {
        // Il faut d'abord determiner dans quelle classe chercher
//        Tree source = msgNode.getChild(0);
        String classAChercher = getMessageSourceType(msgNode, tds, tdt, currentClass, currentMethod,
                symbolsString, symbolsOpalg);

        // On récupère le type de retour du message (noeud le + à droite)
        Tree rmn = msgNode.getChild(msgNode.getChildCount() - 1);
        if (rmn.getType() == GrammaireParser.APPEL_FONCTION) {
            // Il s'agit d'un appel de fonction, on récupère le type de retour
            try {
                String tmp = tdt.get(classAChercher, "METHOD", rmn.getChild(0).getChild(0).getText()).getType();
                return tmp;
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE] Methode inconnue");
                return null;
            }
        } else if (rmn.getType() == GrammaireParser.VARIABLE) {
            // Il s'agit d'un attribut, on récupère son type
            try {
                String tmp = tdt.get(classAChercher, "ATTRIBUT", rmn.getChild(0).getText()).getType();
                return tmp;
            } catch (NullPointerException e) {
//                e.printStackTrace();
                if (debug)
                    System.out.println("[MESSAGE] Attribut inconnu");
                return null;
            }
        } else {
            if (debug)
                System.out.println("[MESSAGE] Structure non reconnue");
            return null;
        }
    }

    public void checkTypeParams(Tree msgNode,
                                TDS tds,
                                TDT tdt,
                                String currentClass,
                                String currentMethod,
                                List<Integer> symbolsString,
                                List<Integer> symbolsOpalg) {

        // On part d'un noeud message obligatoirement, on parcours tous ses fils et on traite uniquement les appel_fonction
        String msgType      = getMessageSourceType(msgNode, tds, tdt, currentClass, currentMethod,
                symbolsString, symbolsOpalg);
        String sourceType   = msgType;
        String prevType     = msgType;

        for (int j = 1 ; j < msgNode.getChildCount() ; j++) {
            // curNoeud est le noeud appelFonction
            Tree curNoeud = msgNode.getChild(j);
            if (curNoeud.getType() == GrammaireParser.APPEL_FONCTION) {
                String fonction                 = curNoeud.getChild(0).getChild(0).getText();
                ArrayList<String> actualTypes   = new ArrayList<>();

                Tree noeudListParam     = curNoeud.getChild(1);

                // On récupère le type des paramètres de la fonction
//                System.out.println(fonction + " " + prevType);
                try {
                    actualTypes = ((ElementMethod) tdt.get(prevType, "METHOD", fonction)).getParam();
                    prevType    = tdt.get(prevType, "METHOD", fonction).getType();
                } catch (NullPointerException e) {
                    // On trouve pas la fonction, oof
//                    System.out.println("### L" + line);
//                    e.printStackTrace();
                }

                // On peut comparer le nombre de paramètre ; s'il est différent, on arrete là, sinon on poursuit
                if (noeudListParam.getChildCount() != actualTypes.size()) {
                    return;
                }

                for (int i = 0 ; i < noeudListParam.getChildCount() ; i++) {
                    // On récupère le type de chaque paramètre
                    String curType = checkOperationTypeRec(
                            noeudListParam.getChild(i), tds, tdt, currentClass, currentMethod,
                            symbolsString, symbolsOpalg
                    );
                    //  On parcours les types des paramètres spécifiés avec la déclaration,
                    // et on les compare a ceux qui ont été entrés.
                    //  Dans la boucle, si les types sont différents alors on affiche une erreur,
                    // puis on continue la boucle à la recherche d'autre erreurs.
                    if(curType != null)
	                    if (!curType.equals(actualTypes.get(i))) {
	                        this.setMessage("Param no. " + String.valueOf(i+1) + " in function '" + fonction + "' have type '" + curType + "' instead of '" + actualTypes.get(i) + "'");
	                        this.display();
	                    }

                }
            } else if (curNoeud.getType() == GrammaireParser.VARIABLE) {
                // Mise a jour de source type
//                System.out.println(tdt.get(sourceType, "ATTRIBUT", curNoeud.getChild(0).getText()));
                try {
                    sourceType = tdt.get(sourceType, "ATTRIBUT", curNoeud.getChild(0).getText()).getType();
                    prevType = sourceType;
//                    System.out.println(" ### " + prevType);
                } catch (NullPointerException e) {
//                    e.printStackTrace();
                }
            }
        }
    }

    public void checkResultUsage(Tree resultNode, TDT tdt, String currentClass, String currentMethod) {
        String methodType = "";
        if (currentClass.equals("main")) {
            this.setMessage("Use of result forbidden : can't use 'result' in the main body");
            this.display();
            return;
        }
        try {
            methodType = tdt.get(currentClass,"METHOD", currentMethod).getType();
            if (methodType == null && !currentClass.equals(currentMethod)) {
                this.setMessage("Use of result forbidden : function '" + currentMethod + "' does not return anything");
                this.display();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void staticVariableCheckExistance(Tree t, TDT tdt){
        if(t.getParent().getType() == GrammaireParser.MESSAGE){
            if(t.getParent().getParent().getType() == GrammaireParser.SELECT){
                Element tdt_elt = null;
                if(t.getParent().getChildCount() > 1){
                    tdt_elt = tdt.get(t.getParent().getChild(0).getText(), "ATTRIBUT", t.getChild(0).getText());
                }
                if(tdt_elt == null){
                    this.display();
                }
            }
        }

    }
}
