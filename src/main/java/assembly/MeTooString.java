package assembly;

import java.io.FileWriter;
import java.io.IOException;

public class MeTooString {
    FileWriter writer;
    boolean debug;
    public MeTooString(FileWriter writer, boolean debug){
        this.writer = writer;
        this.debug = debug;
    }

    public void int_direct_handler(String integ) throws IOException {
        TasASM.allocationString(integ, false, false);
    }

    public void variable_handler() throws IOException {
        // ex : for 1523:
        writer.write(
                ToolsASM.link() +

                        "	LDW R8, #0\n"+
                        "	SUB R11, R8, R8\n" +
                        "	JLE #toStringSigned-$-2 //si le int a convertir est negatif, saut a toStringSigned\n" +

                        "	LDW R8, #10\n" +
                        "	DIV R11, R8, R6 //recuperation de la valeur a convertir stockee dans R11\n" + // R7 contains the result : 3
                        "	ADQ ASCII_CONVERTER, R11\n" +
                        "	LDW R10, #ASCII_OFFSET\n " + // we must do this to stop the string
                        "	MUL R11, R10, R11\n"+


                        "	DIV R6, R8, R9\n" + // R6 contains the result : 2
                        "	ADQ ASCII_CONVERTER, R6\n" +

                        "	DIV R9, R8, R4\n" + // R9 contains the result : 5
                        "	ADQ ASCII_CONVERTER, R9\n" +
                        "	LDW R10, #ASCII_OFFSET\n " +
                        "	MUL R9, R10, R9\n"+

                        "	ADD R6, R9, R6\n" +


                        "	DIV R4, R8, R3\n" + // R4 contains the result : 1
                        "	ADQ ASCII_CONVERTER, R4\n" +

                        "	DIV R3, R8, R9\n" + // R3 contains the result : 0
                        "	ADQ ASCII_CONVERTER, R3\n" +
                        "	LDW R10, #ASCII_OFFSET\n " +
                        "	MUL R3, R10, R3\n"+

                        "	ADD R4, R3, R4\n" +

                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +

                        "\n\tLDW R8, #0x3030\n"+
                        "\tSUB R4, R8, R8\n"+
                        "	JEQ #toString1" + "-$-2\n" +
                        "\tLDW R1, R4\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\ntoString1\n" +

                        "\tLDW R10, R8\n" +
                        "\tLDW R8, #0x3030\n" +
                        "\tSUB R4, R8, R4\n" +
                        "\tSUB R8, R6, R8\n" +
                        "\tSUB R4, R8, R8\n" +
                        "\tJEQ #toString2" + "-$-2\n" +

                        "\tLDW R1, R6\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +


                        "\ntoString2\n" +
                        "\tLDW R1, R11\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +
                        "\tJMP #endtoStringSigned-$-2\n" +

                        "\n\ntoStringSigned\n" +
                        "	LDW R8, #-1 //changement de signe\n" +
                        "	MUL R11, R8, R11\n" +

                        "	LDW R3, R11\n" +

                        "	LDW R8, #10\n" +
                        "	DIV R11, R8, R7 //recuperation de la valeur a convertir stockee dans R11\n" +
                        "	ADQ ASCII_CONVERTER, R11\n" +

                        "	DIV R7, R8, R6\n" + // R5 contains the result : 5
                        "	ADQ ASCII_CONVERTER, R7\n" +
                        "	LDW R10, #ASCII_OFFSET\n " +
                        "	MUL R7, R10, R7\n"+
                        "	ADD R7, R11, R7\n" +


                        "	LDW R8, #10\n" +
                        "	DIV R6, R8, R11\n" + // R6 contains the result : 2
                        "	ADQ ASCII_CONVERTER, R6\n" +

                        "	DIV R11, R8, R4\n" + // R11 contains the result : 5
                        "	ADQ ASCII_CONVERTER, R11\n" +
                        "	LDW R10, #ASCII_OFFSET\n " +
                        "	MUL R11, R10, R11\n"+
                        "	ADD R6, R11, R6\n" +



                        "	LDW R8, #10\n" +
                        "	DIV R4, R8, R3\n" + // R6 contains the result : 2
                        "	ADQ ASCII_CONVERTER, R4\n" +
                        "	LDW R9, #0x2d00 //integration du signe dans le registre\n" +
                        "	ADD R9, R4, R9\n" +

                        "\tLDW R8, #0x0030\n" +
                        "\tSUB R4, R8, R8\n"+
                        "\tJNE #ok-$-2 //IF NE : -n____ avec n different de 0\n" +
                        "\tLDW R8, #0x3030\n"+
                        "\tSUB R6, R8, R8\n"+
                        "\tJNE #ok1-$-2 //IF NE -0nm__ avec nm different de 00\n"+


                        "\tLDW R8, #0x3030\n"+
                        "\tSUB R7, R8, R8\n" +
                        "\tJNE #ok2-$-2 //IF NE -000nm avec nm different de 00\n"+

                        //Everything is 00 we have to shift it all

                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +
                        "\tLDW R8, #0x3000\n" + //result is just 0 at the end
                        "\tLDW R1, R8\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tJMP #endtoStringSigned-$-2\n" + // finished go to the end


                        "\nok2\n" +

                        "\tLDW R10, #ASCII_OFFSET\n " +
                        "\tDIV R7, R10, R6\n"+
                        "\tLDW R8, #0x0030\n"+
                        "\tSUB R6, R8, R8\n"+
                        "\tJEQ #oktiers-$-2\n"+
                        "\tLDW R8, #0x2d00\n"+
                        "\tADD R8, R6, R8\n"+
                        "\tMUL R7, R10, R7\n"+


                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +

                        "\tLDW R1, R8\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R7\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +


                        "\tJMP #endtoStringSigned-$-2\n" +  // finished go to the end

                        "\nok1\n" + //when only -0____ but not -000__

                        "\tLDW R8, #0x3130\n" +
                        "\tSUB R6, R8, R8\n" +
                        "\tJGE #ok3-$-2\n" +

                        //when only -00___
                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +
                        "\tLDW R8, #0x3000\n" +
                        "\tSUB R6, R8, R6\n" +
                        "\tLDW R8, #0x2d00\n" +
                        "\tADD R6, R8, R6\n" +

                        "\tLDW R1, R6\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R7\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, #0x0000\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +


                        "\tJMP #endtoStringSigned-$-2\n" +  // finished go to the end

                        "\nok3\n" +


                        "\tLDW R10, #ASCII_OFFSET\n " +
                        "\tDIV R11, R10, R8\n"+
                        "\tLDW R11, R8\n"+
                        "\tLDW R8, #0x2d00\n" +
                        "\tADD R8, R11, R3\n" +

                        "\tMUL R11, R10, R11\n"+
                        "\tSUB R6, R11, R6\n" +
                        "\tMUL R6, R10, R6\n"+
                        "\tLDW R10, #ASCII_OFFSET\n " +
                        "\tDIV R7, R10, R8\n"+
                        "\tSTW R7, R9\n" +
                        "\tLDW R7, R8\n"+
                        "\tADD R6, R7, R6\n" +
                        "\tMUL R9, R10, R9\n"+


                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +

                        "\tLDW R1, R3\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R6\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R9\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +



                        "JMP #endtoStringSigned-$-2\n" +

                        "\nok\n" +



                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +

                        "\tLDW R1, R9\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R6\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, R7\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, #0x0000\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +
                        "JMP #endtoStringSigned-$-2\n" +

                        "oktiers\n" +
                        "\tLDW R10, #ASCII_OFFSET\n " +
                        "\tDIV R7, R10, R6\n"+
                        "\tLDW R8, #0x2d00\n"+
                        "\tADD R8, R7, R8\n" +

                        "\t//debut stockage string----------\n" +
                        "\t//link-------------\n" +
                        "\tADQ -2, SP\t\n" +
                        "\tSTW BP, (SP)\n" +
                        "\tLDW BP, SP\n" +
                        "\t//fin link---------\n" +
                        "\tLDW SP, HP\t\n" +

                        "\tLDW R1, R8\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +

                        "\tLDW R1, #0x0000\n" +
                        "\tSTW R1, (SP)\n" +
                        "\tADQ 2, SP\n" +


                        "endtoStringSigned\n" +

                        " \tLDW R1, HP\n" +
                        "\tLDW HP, SP\n" +
                        "\t//unlink-----------\n" +
                        "\tLDW SP, BP\n" +
                        "\tLDW BP, (SP)\n" +
                        "\tADQ 2, SP\n" +
                        "\t//fin unlink-------\n" +
                        "\tSTW R1, R10 //Stockage de l'adresse de la conversion dans R10\n" +

                        ToolsASM.unlink() +

                        "\tRTS\n" +
                        "\n"
        );
    }
//        }

}
