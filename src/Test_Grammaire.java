import org.antlr.runtime.*;

public class Test_Grammaire {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        GrammaireLexer lexer = new GrammaireLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammaireParser parser = new GrammaireParser(tokens);
        parser.prog();
    }
}