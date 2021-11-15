package assembly;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import antlr.Antlr_tool;
import descripteurDeClasse.DescripteurDeClasse;
import tdt.ElementTDT;
import tdt.TDT;

public class WriterToFile {
	public static String STACK_ADRS = "f000";// je le change assez souvent pour mes tests
	public static String HEAP_ADRS = "4000";// je le change assez souvent pour mes tests
    public FileWriter writer;
    public TDT tdt;
    public Antlr_tool antlr;
    public String debug;
    public WriterToFile(FileWriter writer, TDT tdt, Antlr_tool antlr, String debug){
        this.writer = writer;
        this.tdt = tdt;
        this.antlr = antlr;
        this.debug = debug;
    }

    public void initialize() throws IOException {
        initilizeRegisters();
        //---------------------------------------------
        //stocke les descripteurs de classe dans la zone de donn�e statique
        if(debug.contentEquals("yes"))
        	System.out.println("DescripteurDeClasse\n");
        ArrayList<DescripteurDeClasse> listeDdc = new ArrayList<DescripteurDeClasse>();
        for(ElementTDT elem : tdt.getTable()) {
        	listeDdc.add(new DescripteurDeClasse(tdt, elem, debug));
        }
        new DescripteurDeClasseASM(writer, listeDdc);
        TasASM.tdt = tdt;
        TasASM.listeDdc = listeDdc;
        TasASM.writer = writer;
        //---------------------------------------------
        antlr.setFileWriter(writer);
        antlr.thirdPass();
        addBasicFunctions();
    }

    public void initilizeRegisters() throws IOException {
        writer.write("ORG \t\t0x0000\n"+
 
        		"EXIT_EXC\tEQU 64\n" +
                "READ_EXC\tEQU 65\n" +
                "WRITE_EXC\tEQU 66\n" +
                "STACK_ADRS\tEQU\t0x"+STACK_ADRS+"\n" +
                "HEAP_ADRS	EQU	0x"+HEAP_ADRS+"\n"+
                "NIL\t\t\tEQU 0\n" +
                "SP\t\t\tEQU\t" + RESERVED_REGISTERS.stackPointer_register + "\n" +
                "WR \t\t\tEQU " + RESERVED_REGISTERS.working_register + "\n" +
                "BP \t\t\tEQU " + RESERVED_REGISTERS.basePointer_register +"\n" +
                "HP \t\t\tEQU " + RESERVED_REGISTERS.heapPointer_register +"\n" +
                "ASCII_CONVERTER  \t\t\tEQU 48\n"+
                "ASCII_OFFSET  \t\t\tEQU 256\n" +
                  
                "LDW SP, #STACK_ADRS\n"+
                "LDW HP, #HEAP_ADRS\n"+
                "\n" +
                "JSR @descriptifClasses_\n"+
                "\n" +
                "rodata_line_feed_\n" +
                "BYTE                    10\n" +
                "BYTE                    0\n"
        );
    }

   
    
    public void addBasicFunctions() throws IOException {
        boolean debug_b = false;
        if(debug == "yes"){
            debug_b = true;
        }
        writer.write("\nInteger_toString\n");
        TasASM.ajoutAdressesMethodes("Integer", "toString");
    	MeTooString m = new MeTooString(writer, debug_b);
        m.variable_handler();
        writer.write(

                "print_\t//Parodi made\n" +
                "\t\tADQ -2, SP\n" +
                "\t\tSTW BP, (SP)\n" +
                "\t\tLDW BP, SP\n" +
                "\t\tLDW R0, BP\n" +
                "\t\tADQ 4, R0\n" +
                "\t\tLDW R0, (R0)\n" +
                "\t\tLDW WR, #WRITE_EXC\n" +
                "\t\tTRP WR\n" +
                "\t\tLDW SP, BP\n" +
                "\t\tLDW BP, (SP)\n" +
                "\t\tADQ 2, SP\n" +
                "\t\tLDW WR, (SP)\n" +
                "\t\tADQ 2, SP\n" +
                "\t\tJEA (WR)\n\n\n" +
                TasASM.initAdressesMethodes+
                "	JSR @main_\n\n\n"+
                "main_\n" +
        		"	ADQ -2, SP\n"+
                "	LDQ NIL, BP\n"+
                "	STW BP, (SP)\n"+
                "	LDW BP, SP\n\n\n");
    }



    public void endFile() throws IOException {
        writer.write("\n\n");
        writer.write("	// Fin" + "\n" +
                "	LDW WR, #EXIT_EXC" + "\n" +
                "	TRP WR"
        );
    }

    public void close() throws IOException {
        writer.write("\n");
        writer.close();

    }
}
