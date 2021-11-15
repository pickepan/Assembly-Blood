package assembly;
import antlr.generatedClasses.GrammaireParser;
import org.antlr.runtime.tree.Tree;
import tds.Element;
import tds.ElementVariable;
import tds.TDS;
import tdt.TDT;
import objet.ElementObjet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OperateurCondition {

	private FileWriter writer;
	private ArrayList<String> symbolComp;
	private ArrayList<String> symbolOp;

	public OperateurCondition(FileWriter writer) throws IOException {
		this.writer = writer;
		symbolComp=new ArrayList<String>();
		symbolComp.add("<");
		symbolComp.add(">");
		symbolComp.add("<>");
		symbolComp.add("=");
		symbolComp.add("&&");
		symbolComp.add("||");
		symbolOp=new ArrayList<String>();
		symbolOp.add("+");
		symbolOp.add("-");
		symbolOp.add("/");
		symbolOp.add("*");
	}

	public void superieur(Tree t, String reg1,String reg2, FileWriter writer, int else_etiquette) throws IOException {
//		if (t.getParent().getText().equals("CONDITION")){
//			if(t.getParent().getParent().getText().equals("WHILE")){
//				writer.write(ToolsASM.link()+"while"+else_etiquette);
//			}
//			else if(t.getParent().getParent().getText().equals("IF")){
//				//TODO
//			}
//		}

		writer.write("\n"
				+"\tLDW R5, #1\n"
				+"\tSUB R"+reg1+",R"+reg2+",R1\n"
				+"\tJGT #4\n"
				+"\tLDW R5 , #0\n"
		);

	}

	public void inferieur(Tree t, String reg1,String reg2, FileWriter writer, int else_etiquette) throws IOException {
//		if (t.getParent().getText().equals("CONDITION")){
////			if(t.getParent().getParent().getText().equals("WHILE")){
////				writer.write("while"+else_etiquette);
////			}
////			else if(t.getParent().getParent().getText().equals("IF")){
////				//TODO
////			}
//		}


		writer.write("\n\n"
				+"\tLDW R5, #1\n"
				+"\tSUB R"+reg1+",R"+reg2+",R1\n"
				+"\tJLW #4\n"
				+"\tLDW R5, #0\n" );
	}

	public void egal(Tree t,String reg1,String reg2, FileWriter writer, int else_etiquette) throws IOException {
//		if (t.getParent().getText().equals("CONDITION")){
//			if(t.getParent().getParent().getText().equals("WHILE")){
//				writer.write(ToolsASM.link()+"while"+else_etiquette);
//			}
//			else if(t.getParent().getParent().getText().equals("IF")){
//				//TODO
//			}
//		}


		writer.write("\n\n"
				+"	LDW R5,#1\n"
				+"	SUB R"+reg1+",R"+reg2+",R1\n"
				+"	JEQ #4\n"
				+"	LDW R5 , #0\n" );


	}

	public void different(Tree t, String reg1,String reg2, FileWriter writer, int else_etiquette) throws IOException {
//		if (t.getParent().getText().equals("CONDITION")){
//			if(t.getParent().getParent().getText().equals("WHILE")){
//				writer.write(ToolsASM.link()+"while"+else_etiquette);
//			}
//			else if(t.getParent().getParent().getText().equals("IF")){
//				//TODO
//			}
//		}


		writer.write("\n\n"
				+"	LDW R5 , #0\n"
				+"	SUB R"+reg1+",R"+reg2+",R1\n"
				+"	JEQ #4\n"
				+"	LDW R5 , #1\n" );


	}

	public void ou(FileWriter writer,String registre1,String registre2) throws IOException {
		writer.write("\n\n"
						+"	LDW R5, #0 \n"
						+"	OR R"+registre1+",R"+registre2+"," + RESERVED_REGISTERS.operations_register +  "\n"
//				+"	JEQ #4\n"
//				+"	LDW R5, #1   \n"
		);
	}

	public void et(FileWriter writer,String registre1,String registre2) throws IOException {
		writer.write("\n\n"
						+"	LDW R5, #0\n"
						+"	AND R"+registre1+",R"+registre2+"," + RESERVED_REGISTERS.operations_register  + "\n"
//				+"	JEQ #4\n"
//				+"	LDW R5, #1\n"
		);
	}

	public String registre(FileWriter writer,int numFils,Tree t,TDS tds,String currentClass) throws IOException { // numFils : 0=fils gauche, 1=fils droit, on met le fils gauche dans r3 et le droit dans r4

		if (t.getChild(numFils).getType()== GrammaireParser.INT) {
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+", #"+Integer.parseInt(t.getChild(numFils).getText())+"\n");
		}
		else if (t.getChild(numFils).getType()==GrammaireParser.VARIABLE) {

			writer.write("\n\n"
					+ ToolsASM.getVariableInR0(tds, t.getChild(numFils).getChild(0).getText())
					+"\tLDW R"+ String.valueOf(numFils+3)+", R0\n");
		}
		else if (symbolComp.contains(t.getChild(numFils).getText())) {
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+", R5\n");
		}

		else if (symbolOp.contains(t.getChild(numFils).getText())) {
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+",R6\n");
		}

		else if(t.getChild(numFils).getText().equals("MESSAGE")) {
			ElementObjet obj=new ElementObjet(currentClass,t.getChild(numFils),"Objet");
			TasASM.attributDansR0(tds, obj, -1, false);
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+", R0\n");
		}
		else if(t.getChild(numFils).getText().equals("SELECT")) {
			ElementObjet obj=new ElementObjet(currentClass,t.getChild(numFils),"Objet");
			TasASM.attributDansR0(tds, obj, -1, false);
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+", R0\n");
		}

		else if(t.getChild(numFils).getText().equals("IDENTIFICATEUR") && t.getChild(numFils).getChild(0).getText().equals("MESSAGE")) {
			ElementObjet obj=new ElementObjet(currentClass,t.getChild(numFils).getChild(0),"Objet");
			TasASM.attributDansR0(tds, obj, -1, false);
			writer.write("\n\n"
					+"\tLDW R"+ String.valueOf(numFils+3)+", R0\n");
		}

		return String.valueOf(numFils+3);

	}
}