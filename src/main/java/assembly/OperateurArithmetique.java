package assembly;

import antlr.generatedClasses.GrammaireParser;
import objet.ElementObjet;
import org.antlr.runtime.tree.Tree;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;

public class OperateurArithmetique {

    private FileWriter writer;

//    String operation = "##";
    private String leftLoad = "\t[!!!leftLoad!!!]\n";
    private String rightLoad = "\t[!!!rightLoad!!!]\n";

    private String currentClass;

//    String destVar = "##";      // Variable dans laquelle stocker le résultat

    private String leftRegister = "[!!!RL!!!]";           // Registre de l'operande de gauche
    private String rightRegister = "[!!!RR!!!]";           // Registre de l'operande de droite
    private String resultRegister = "[!!!RES!!!]";          // registre où est stocké le résultat

//    OperandPosition myPosition;

    private TDS tds;
//
//    public enum OperandPosition {
//        RIGHT,
//        LEFT
//    }

    private void initialize(FileWriter writer, TDS tds, Tree operandNode,
                                 String leftRegister, String rightRegister, String resultRegister, String currentClass) {
        this.writer         = writer;
        this.tds            = tds;
        this.currentClass   = currentClass;

        this.leftRegister   = leftRegister;
        this.rightRegister  = rightRegister;
        this.resultRegister = resultRegister;
        try {
            writer.write(loadOperand(operandNode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OperateurArithmetique(FileWriter writer, TDS tds, Tree operandNode, String currentClass) {
        initialize(writer, tds, operandNode, "R1", "R2", "R6", currentClass);
    }

    public OperateurArithmetique(FileWriter writer, TDS tds, Tree operandNode, String resultRegister, String currentClass) {
        initialize(writer, tds, operandNode, "R1", "R2", resultRegister, currentClass);
    }

    public OperateurArithmetique(FileWriter writer, TDS tds, Tree operandNode,
                                 String leftRegister, String rightRegister, String resultRegister, String currentClass) {
        initialize(writer, tds, operandNode, leftRegister, rightRegister, resultRegister, currentClass);
    }

    private String loadOperand(Tree operandNode) throws IOException {
        String output = "";
        if (operandNode.getType() == GrammaireParser.INT) {
            String val = operandNode.getText();
            output += "\tLDW " + resultRegister + ", #" + val + "\n" + push(resultRegister);  // On met la valeur dans la pile
        } else if (operandNode.getType() == GrammaireParser.VARIABLE) {
            String varName = operandNode.getChild(0).getText();
            writer.write(ToolsASM.getVariableInR0(tds, varName));   // On recupere la valeur de la variable dans R0
            output += "\tLDW " + resultRegister + ", R0\n" + push(resultRegister);    // On met la valeur dans la pile ; c'est crade, mais c'est pour standardiser un maximum
        } else if (operandNode.getType() == 46) {
            output += operation("ADD", resultRegister, operandNode.getChild(0), operandNode.getChild(1));
        } else if (operandNode.getType() == 45) {
            output += operation("MUL", resultRegister, operandNode.getChild(0), operandNode.getChild(1));
        } else if (operandNode.getType() == 48) {
            output += operation("SUB", resultRegister, operandNode.getChild(0), operandNode.getChild(1));
        } else if (operandNode.getType() == 50) {
            output += operation("DIV", resultRegister, operandNode.getChild(0), operandNode.getChild(1));
        } else if (operandNode.getType() == GrammaireParser.GROUP) {
            writer.write(loadOperand(operandNode.getChild(0)));
        } else if (operandNode.getType() == GrammaireParser.MOINS_UNAIRE) {
            writer.write(loadOperand(operandNode.getChild(0)));
            output += pop(this.resultRegister);
            output += "\tLDW R0, #-1\n";
            output += "\tMUL R0, " + resultRegister + ", " + resultRegister + "\n";
            output += push(resultRegister);
        } else if (operandNode.getType() == GrammaireParser.PLUS_UNAIRE) {
            writer.write(loadOperand(operandNode.getChild(0)));
        } else if (operandNode.getType() == GrammaireParser.MESSAGE) {
            ElementObjet obj = new ElementObjet("", operandNode, "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
            output += "\tLDW " + resultRegister + ", R0\n";
            output += push(resultRegister);
        } else if (operandNode.getType() == GrammaireParser.IDENTIFICATEUR) {
            ElementObjet obj = new ElementObjet(currentClass, operandNode.getChild(0), "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
            output += "\tLDW " + resultRegister + ", R0\n";
            output += push(resultRegister);
        }
        else if (operandNode.getType() == GrammaireParser.SELECT) {
            ElementObjet obj = new ElementObjet(currentClass, operandNode, "Objet");
            TasASM.attributDansR0(tds, obj, -1, false);
            output += "\tLDW " + resultRegister + ", R0\n";
            output += push(resultRegister);
        }
        else {
            System.out.println(operandNode.getText());
            System.err.println("[OperateurArithmetique - loadOperand] Erreur de chargement");
        }
        return output;
    }

    private String operation(String operation, String r, Tree left, Tree right) throws IOException {
        String output = "\t// -- Debut operation --\n";
        writer.write(loadOperand(left));
        writer.write(loadOperand(right));
        output += pop(this.rightRegister);   // On depile la seconde valeur
        output += pop(this.leftRegister);    // On depile la premiere valeur
        output += "\t" + operation + " " + leftRegister + ", " + rightRegister + ", " + resultRegister + "\n";
        output += "\t// -- Fin operation --\n";
        if(left.getParent().getParent().getType() != GrammaireParser.LIST_PARAM){
            output += push(this.resultRegister);
        }

        return output;
    }

    private String push(String r) {
        return "\tADQ -2, SP\n\tSTW " + r + ", (SP)\n";
    }

    private String pop(String r) {
        return "\tLDW " + r + ", (SP)\n\tADQ 2, SP\n";
    }

}
