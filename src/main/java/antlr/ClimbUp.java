package antlr;

import antlr.generatedClasses.GrammaireParser;
import org.antlr.runtime.tree.Tree;

public class ClimbUp {
    public static Tree climbUp(Tree t){
        Tree t__2 = t.getParent();
        while(t__2.getType() == GrammaireParser.GROUP){
            t__2 = t__2.getParent();
        }
        return t__2;
    }
}
