package assembly;

import antlr.generatedClasses.GrammaireParser;
import objet.ElementObjet;

import org.antlr.runtime.tree.Tree;
import tds.Element;
import tds.Pair;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;

public class IfAndWhile {
    private int etiquette;
    private FileWriter writer;
    private Tree t;
    private TDS tds;

    public IfAndWhile(int else_etiquette, FileWriter writer, Tree t, TDS tds) {
        this.etiquette = else_etiquette;
        this.writer = writer;
        this.t = t;
        this.tds = tds;
    }

    public void writer_else() throws IOException {
        writer.write("JEQ else" + etiquette + "-$-2" + "\n");
    }
    public void writer_etiquette_else() throws IOException {
        writer.write("else" + etiquette +"\n");
    }

    public void writer_condition_code(String currentClass) throws IOException {

        if (t.getParent().getText().equals("IF")){

            Tree t_ = t.getChild(0);
            if(t.getChild(0).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
                Tree t__ = t.getChild(0).getChild(0);
                while(t__.getType() == GrammaireParser.GROUP){
                    t__ = t__.getChild(0);

                }
                t_ = t__;
            }

            if(t_.getType() == 22){
//                if (t_.getText().equals("0")){ //case if 0
                    writer.write("if" + etiquette + " LDW "+ RESERVED_REGISTERS.if_register +", #" + t_.getText() + "\n"+
                            "\tLDW " + RESERVED_REGISTERS.if_register_2 + ", #0\n" +
                            "\tSUB " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" + //used to force flag ZF to pop
                            "\tJEQ #else" + etiquette + "-$-2" + "\n"
                    );
//                }
//                else{ //given n!=0, case if n

//                }
            }
            else if(t_.getType() == 57 ||
                    t_.getType() == 54 ||
                    t_.getType() == 77 ||
                    t_.getType() == 41 ||
                    t_.getType() == 55 ||
                    t_.getType() == 56){ // < > | && || = <> GROUP
                writer.write("if" + etiquette + " LDW " + RESERVED_REGISTERS.if_register +", #0\n" +
                        "\tSUB " + RESERVED_REGISTERS.operations_register + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" +
                        "\tJEQ #else" + etiquette + "-$-2" + "\n"

                );
            }

            else if(t_.getType() == 46 || //+
                    t_.getType() == 45 || //*
                    t_.getType() == 48 || //-
                    t_.getType() == 50)  // /
                     {
                writer.write("if" + etiquette + " LDW " + RESERVED_REGISTERS.if_register +", #0\n" +
                        "\tSUB " + RESERVED_REGISTERS.operations_register_2 + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" +
                        "\tJEQ #else" + etiquette + "-$-2" + "\n"

                );
            }

            else if (t_.getType() == GrammaireParser.VARIABLE){
                Pair<Element, Integer> p = tds.getByName(t_.getChild(0).getText(), GrammaireParser.VARIABLE, false);
                ElementObjet o = new ElementObjet(t_.getChild(0).getText(), "Objet");
                TasASM.attributDansR0(tds, o, -1, false);
//                int dec = tds.getByNameCurrentTable(t_.getChild(0).getText(), GrammaireParser.VARIABLE).getDeplacement();
                writer.write(
                        "if" + etiquette + " LDW " + RESERVED_REGISTERS.if_register_2 +", #0\n" +
                        "\tLDW " + RESERVED_REGISTERS.if_register + ", R0\n" +//(BP)-" + dec + "\n" + //Load with value of variable
                        "\tSUB " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register_2 + "\n" +
                        "\tJEQ #else" + etiquette + "-$-2" + "\n"
                );
            }
            else if(t_.getType() == GrammaireParser.IDENTIFICATEUR){
                writer.write("if" + etiquette + " LDW " + RESERVED_REGISTERS.if_register_2 +", #0\n");
                ElementObjet o = new ElementObjet(currentClass, t_.getChild(0), "Objet");
                TasASM.attributDansR0(tds, o, -1, false);
                
                        //ToolsASM.getVariableInR0(tds, t_.getChild(0).getChild(1).getChild(0).getText()) +
                        writer.write("\t\tLDW " + RESERVED_REGISTERS.if_register + ", R0\n" + //Load with value of variable
                        "\t\tSUB " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register_2 + "\n" +
                        "\tJEQ #else" + etiquette + "-$-2" + "\n"
                );
            }
        }
        else if (t.getParent().getText().equals("WHILE")){

            Tree t_ = t.getChild(0);
            if(t.getChild(0).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
                Tree t__ = t.getChild(0).getChild(0);
                while(t__.getType() == GrammaireParser.GROUP){
                    t__ = t__.getChild(0);

                }
                t_ = t__;
            }


            if(t_.getType() == 22){
                if (t_.getText().equals("0")){ //case if 0
                    writer.write("while" + etiquette + " LDW "+ RESERVED_REGISTERS.if_register +", #0\n" +
                            "\tSUB " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" + //used to force flag ZF to pop
                            "\tJEQ #while_end" + etiquette + "-$-2" + "\n"
                    );
                }
                else{ //given n!=0, case if n
                    writer.write("while" + etiquette + "\n");
                }
            }
            else if(t_.getType() == GrammaireParser.IDENTIFICATEUR){
                writer.write(
                        "\t\t//while check condition\n"+
                                "while" + etiquette + " LDW " + RESERVED_REGISTERS.if_register_2 +", #0\n" +
                                ToolsASM.getVariableInR0(tds, t_.getChild(0).getChild(1).getChild(0).getText()) +
                                "\t\tLDW " + RESERVED_REGISTERS.if_register + ", R0\n" + //Load with value of variable
                                "\t\tSUB " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register_2 + "\n" +
                                "\t\tJEQ #while_end" + etiquette + "-$-2" + "\n"
                );
            }
            else if(t_.getType() == 46 || //+
                    t_.getType() == 45 || //*
                    t_.getType() == 48 || //-
                    t_.getType() == 50)  // /
            {
                writer.write("while" + etiquette + " LDW " + RESERVED_REGISTERS.if_register +", #0\n" +
                        "\tSUB " + RESERVED_REGISTERS.operations_register_2 + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" +
                        "\tJEQ #while_end" + etiquette + "-$-2" + "\n"

                );
            }
            else if(t_.getType() == 57 ||
                    t_.getType() == 54 ||
                    t_.getType() == 77 ||
                    t_.getType() == 41 ||
                    t_.getType() == 55 ||
                    t_.getType() == 56){ // < > | && || = <>
                writer.write(
                        "\tLDW " + RESERVED_REGISTERS.if_register +", #0\n" +
                        "\tSUB " + RESERVED_REGISTERS.operations_register + ", " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register + "\n" +
                        "\tJEQ #while_end" + etiquette + "-$-2" + "\n"
                );
            }


            else if (t_.getType() == GrammaireParser.VARIABLE){
//                int dec = tds.getByNameCurrentTable(t_.getChild(0).getText(), GrammaireParser.VARIABLE).getDeplacement();
                writer.write(
                        "\t\t//while check condition\n"+
                		"while" + etiquette + " LDW " + RESERVED_REGISTERS.if_register_2 +", #0\n" +
                                ToolsASM.getVariableInR0(tds, t_.getChild(0).getText()) +
                                "\t\tLDW " + RESERVED_REGISTERS.if_register + ", R0\n" + //Load with value of variable
                                "\t\tSUB " + RESERVED_REGISTERS.if_register + ", " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register_2 + "\n" +
                                "\t\tJEQ #while_end" + etiquette + "-$-2" + "\n"
                );
            }
            else if (t_.getType() == GrammaireParser.MESSAGE){ //object type

//                int dec = tds.getByNameCurrentTable(t_.getChild(0).getText(), GrammaireParser.VARIABLE).getDeplacement();
            	ElementObjet obj = new ElementObjet(null, t_, "Objet" );
                TasASM.attributDansR0(tds, obj, etiquette, false);
                writer.write(
//                        "while" + etiquette + //pris en charge plus haut
                       "\t\t//while check contition\n"+
                       "\tLDW " + RESERVED_REGISTERS.if_register_2 +", #0\n" +
                       "\tLDW " + RESERVED_REGISTERS.object_attributes_getter + ", (R0)\n" + //Load with value of variable
                       "\tSUB " + RESERVED_REGISTERS.object_attributes_getter + ", " + RESERVED_REGISTERS.if_register_2 + ", " + RESERVED_REGISTERS.if_register_2 + "\n" +
                       "\tJEQ #while_end" + etiquette + "-$-2" + "\n"
                );
            }
        }

    }

    public void writer_jump_end_else() throws IOException {
        writer.write("JEA @then" + etiquette + "\n");
    }

    public void writer_jump_end_else_end() throws IOException {
        writer.write("then" + etiquette + "\n");
    }

    public void writer_jump_end_while_end() throws IOException {
        writer.write("while_end" + etiquette + "\n");
    }

    public void writer_jump_begining_while() throws IOException {
        writer.write("JEA @while" + etiquette + "\n");
    }

    public void writer_etiquette_while_begin() throws IOException {
        Tree t_ = t.getChild(0);

        if(t.getChild(0).getType() == GrammaireParser.GROUP){ //removing unwanted parenthesis
            Tree t__ = t.getChild(0).getChild(0);
            while(t__.getType() == GrammaireParser.GROUP){
                t__ = t__.getChild(0);

            }
            t_ = t__;
        }
        if(t_.getType() == 57 ||
                t_.getType() == 54 ||
                t_.getType() == 77 ||
                t_.getType() == 41 ||
                t_.getType() == 55 ||
                t_.getType() == 56){ // < > | && || = <>
            writer.write("while" + etiquette + "\n");}
    }
}
