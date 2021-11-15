package antlr;

import antlr.generatedClasses.GrammaireLexer;
import antlr.generatedClasses.GrammaireParser;
import assembly.*;
import controls.Control;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.Tree;

import tdt.ElementTDT;
import tdt.TDT;
import tds.Element;
import tds.ElementMethod;
import tds.ElementVariable;
import tds.Pair;
import tds.TDS;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Antlr_tool {
    private static int tds_counter = 0;
	private TDT tableDesTypes;
	private TDS tds;
	private Element elem;
	private ElementTDT e;
    private static int else_etiquette = 0;

	private static final ArrayList<Integer> symbolsInt = new ArrayList<>();
	private static final ArrayList<Integer> symbolsString = new ArrayList<>();
    private static final ArrayList<Integer> symbolsOpalg = new ArrayList<>();

	private String currentClass = "main";
	private String currentMethod;
	private boolean dansMessage = false; //variable qui permet de differencier une variable d'une sous variable dans un message
    private boolean debug;

    private FileWriter writer;
    private WriterToFile writer_;
    EtiquetteGenerator etiquetteGenerator;

    public Antlr_tool(boolean debug){
        this.debug = debug;
        etiquetteGenerator = new EtiquetteGenerator();
    }

    public Tree getTree() {
        return tree;
    }

    private Tree tree;

    private static int tds_counter_3rd_pass = 0;

    public void init(InputStream file) throws IOException, RecognitionException {
        ANTLRInputStream inputStream = new ANTLRInputStream(file);
        GrammaireLexer lexer = new GrammaireLexer(inputStream);

        TokenStream tokens = new CommonTokenStream(lexer);
        GrammaireParser parser = new GrammaireParser(tokens);

        if(debug == true){
            System.out.println("ANTLR initialization done!");
        }

        tree = (Tree) parser.prog().getTree();

        if(debug == true){
            System.out.println("ParseTree recovered OK");
        }


        List<Integer> temp1 = Arrays.asList(46, 48, 45, 50, 77, 41, 56, 55, 54, 57, 26, 29);
        List<Integer> temp2 = Arrays.asList(42);
//        List<Integer> temp3 = Arrays.asList(46, 48, 45, 50);

        symbolsInt.addAll(temp1);
        symbolsString.addAll(temp2);
        symbolsOpalg.addAll(temp1);
    }

    public void firstPass(TDT tdt) {
        FirstPass fp = new FirstPass(debug);
        fp.launch(tdt, tree);
        tableDesTypes = fp.getTableDesTypes();
    }

    public void secondPass(TDS tds) {
        SecondPass sp = new SecondPass(debug);
        sp.launch(tds, tree, tableDesTypes);
    }

    public void thirdPass() throws IOException {
        ThirdPass fp = new ThirdPass(debug, writer, etiquetteGenerator);
        fp.launch(tree, tds);
    }
    public void fourthPass() throws IOException {
        FourthPass fp = new FourthPass(debug, writer, writer_, etiquetteGenerator);
        fp.launch(tree, tds);
    }

    public void setWriter(WriterToFile writer) {
    	this.writer = writer.writer;
        this.writer_ = writer;
    }
    public void setFileWriter(FileWriter writer) {
    	this.writer = writer;
    }

    public void setTDS(TDS tds) {
        this.tds = tds;
    }
    public static ArrayList<Integer> getSymbolsInt() {
        return symbolsInt;
    }

    public static ArrayList<Integer> getSymbolsOpalg() {
        return symbolsOpalg;
    }

    public static ArrayList<Integer> getSymbolsString() {
        return symbolsString;
    }
}

