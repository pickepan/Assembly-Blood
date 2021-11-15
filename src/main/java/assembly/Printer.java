 package assembly;

import antlr.generatedClasses.GrammaireParser;
import org.antlr.runtime.tree.Tree;

import descripteurDeClasse.DescripteurDeClasse;
import objet.ElementObjet;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Printer {

    private FileWriter writer;
    private static int ln_is_already_done = 0;
    private static ArrayList<Integer> hashes = new ArrayList<Integer>();

    public Printer(FileWriter writer){
        this.writer = writer;
    }
    public void addPrintAVariable(ElementObjet obj, TDS tds) throws IOException {
        writer.write("//debut print\n");
        if(obj.getNature().contentEquals("String")) {
            TasASM.allocationString(obj.getNom(), false, false);
        }
        else {
            obj.getListeAttributOuParam().remove(obj.getListeAttributOuParam().size()-1);
            if(obj.getListeAttributOuParam().isEmpty()) {
                writer.write(ToolsASM.getVariableInR0(tds, obj.getNom())+"	LDW R1, R0\n");
            }
            else {
                TasASM.attributDansR0(tds, obj, -1, false);
                writer.write("	LDW R1, (R0)\n");
            }
        }
        writer.write(
                "	ADQ -2, SP\n" +
                        "	STW R1, (SP)\n" +
                        "	JSR @print_\n"+
                        "	ADQ 2, SP\n" +
                        "//fin print\n\n"
        );
    }
    public void addPrintR1(boolean ln) throws IOException {

    	writer.write(
    	        "//inR1\n" +
                "	ADQ -2, SP\n" +
                "	STW R1, (SP)\n" +
                "	JSR @print_\n"+
                "	ADQ 2, SP\n" +
                "//fin print\n\n"
        );
    	if(ln) {
    		ElementObjet e = new ElementObjet("\"\\n\"", "String");
    		addPrintAVariable(e, null);
    	}
    }
    public void addPrintAVariableIdentificateur(ElementObjet obj, TDS tds, String type, boolean ln) throws IOException {
    	DescripteurDeClasse ddc = TasASM.get(type);
    	//il faut aller chercher la string dans R11
    	writer.write("//debut print\n");
    	obj.getListeAttributOuParam().remove(obj.getListeAttributOuParam().size()-1);
    	//si pas d'autres attribut on se met a l'adresse de la string
    	if(obj.getListeAttributOuParam().isEmpty()) {
    		
    		writer.write("	LDW R0, R11\n"
    			+ "	ADQ "+ddc.getDeplacementAttribut(obj.getNom())+", R0\n"
    			+ "	LDW R1, (R0)\n");
    	}
    	else {
    		TasASM.attributDansR0(tds, obj, -1, false);
    		writer.write("	LDW R1, (R0)\n");
    	}
    	writer.write(
                "	ADQ -2, SP\n" +
                "	STW R1, (SP)\n" +
                "	JSR @print_\n"+
                "	ADQ 2, SP\n" +
                "//fin print\n\n"
        );
    		
    }
    public void addPrintlnAVariable(ElementObjet obj, TDS tds) throws IOException {
    	writer.write("//debut print\n");
    	if(obj.getNature().contentEquals("String")) {
    		TasASM.allocationString(obj.getNom(), false, false);
    	}
    	else {
    		obj.getListeAttributOuParam().remove(obj.getListeAttributOuParam().size()-1);
    	    if(obj.getListeAttributOuParam().isEmpty()) {
    	    	writer.write(ToolsASM.getVariableInR0(tds, obj.getNom())+"	LDW R1, R0\n");
    	    }
    	    else {
    	    	TasASM.attributDansR0(tds, obj, -1, false);
    	    	writer.write("	LDW R1, (R0)\n");
    	    }
    	}
        writer.write(
                "	ADQ -2, SP\n" +
                        "	STW R1, (SP)\n" +
                        "	JSR @print_\n"+
                        "	ADQ 2, SP\n" +
                        "//fin print\n\n"
        );
        ElementObjet e = new ElementObjet("\"\\n\"", "String");
        addPrintAVariable(e, null);
    }

    public String esperluateConcat(Tree t){
        List<String> s = new ArrayList<>();
        String result = "";

        while(t.getChild(0).getText().equals("&")){
            s.add(removeQuotes(t.getChild(1).getChild(0).getText()) );
            t = t.getChild(0);
        }
        s.add(removeQuotes(t.getChild(1).getChild(0).getText()));
        s.add(removeQuotes(t.getChild(0).getChild(0).getText()));

        for (int i = s.size() - 1; -1<i; i--){
            result = result + s.get(i);
        }
        return result;
    }

    public Boolean esperluateConcat_check(Tree t){
    	try {
    		if(t.getChildCount()==0)
        		return false;
            while(t.getChild(0).getText().equals("&")){
                if(!t.getChild(1).getText().equals("STRING")){
                    return false;
                }
                t = t.getChild(0);
            }
            if(!t.getChild(1).getText().equals("STRING") || !t.getChild(0).getText().equals("STRING")){
                return false;
            }
            return true;
    	}catch(java.lang.NullPointerException e) {
    		return false;
    	}
    	
    }

    public void esperluette_concat(Tree t) throws IOException {
        Tree t_ = t;
        while(t_.getType() == 42){
            t_ = t_.getChild(0);
        }
        t_ = t_.getParent();
        writer.write("//begining of esperluette work\n");
        handle_string(t_.getChild(0), false);
        handle_string(t_.getChild(1), true);
        while(t_.getType() == 42){
            t_ = t_.getParent();
            handle_string(t_.getChild(1), true);
        }
        writer.write(
                "\tLDW R9, #ASCII_OFFSET\n" +
                "\tMUL R9, R10, R10\n" +
                "\tLDW R0, R10\n" +
                "\tSTW R0, (HP)\n" +
                "\tADQ 2, HP\n" +
                "\tLDW R10, #0x0000 //erasing R10 register for next use\n"
        );
        writer.write("	LDW R0, #0x0000\n"+
                "	STW R0, (HP)\n"+
                "	ADQ 2, HP\n" +
                "//end of esperluette work\n"
        );
    }

    public void handle_string(Tree t, boolean isInConcat) throws IOException {
        if(t.getType() == GrammaireParser.STRING){
            TasASM.allocationString(t.getChild(0).getText(), true, isInConcat);
        }
        //TODO do it for the other kinds
    }

    private String removeQuotes(String s){
        return s.substring(1, s.length()-1);
    }
}
