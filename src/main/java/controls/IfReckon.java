package controls;

import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class IfReckon { //the goal of
    public IfReckon() {
    }

    public void check(Tree t) throws IfReckonException { //check if a tree is reckonable
        try{
            Integer.parseInt(t.getText());
        }
        catch (Exception e) {
            if(t.getText().equals("+") || t.getText().equals("-") || t.getText().equals("/") || t.getText().equals("*")){
                check(t.getChild(0));
                check(t.getChild(1));
            }
            else if(t.getText().equals("GROUP")){
                check(t.getChild(0));
            }
            else{
                throw new IfReckonException();
            }
    }
    }

    public List<Object> isOk(Tree t){
        //returns a boolean (false if the tree is not reckonable) and the value of the tree
        //reckons the value of a tree like 1+3-8+7/3
        List<Object> o = new ArrayList<>();
        try{ //tree is reckonable
            check(t.getChild(0));
            o.add(true);
            o.add(reckonJob(t.getChild(0))); //tree value
        } catch (Exception e) { //tree is not reckonable
            o.add(false);
        }
        return o;
    }

    public int reckonJob(Tree t){ //reckons the value of the tree
        try{
            return Integer.parseInt(t.getText());
        } catch (Exception e) {
            if(t.getText().equals("+")){
                return reckonJob(t.getChild(0)) + reckonJob(t.getChild(1));
            }
            if(t.getText().equals("-")){
                return reckonJob(t.getChild(0)) - reckonJob(t.getChild(1));
            }
            if(t.getText().equals("/")){
                return reckonJob(t.getChild(0)) / reckonJob(t.getChild(1));
            }
            if(t.getText().equals("*")){
                return reckonJob(t.getChild(0)) * reckonJob(t.getChild(1));
            }
            if(t.getText().equals("GROUP")){
                return ( reckonJob(t.getChild(0)) ) ;
            }
        }
        return 0;
    }

}
