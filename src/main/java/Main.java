import Pipeline.Pipeline;
import antlr.Antlr_tool;
import assembly.WriterToFile;

import org.antlr.runtime.RecognitionException;

import tdt.TDT;
import tds.TDS;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, RecognitionException {
        if(args[0].equals("pipe")){
            Pipeline p = new Pipeline();

            if(p.compare(args[1], args[2])){
                System.exit(0);
            }
            System.err.println(args[1] + " and " + args[2] + " are not the same");
            System.exit(1);
        }
        if(args[1].equals("yes")){
            System.out.println("Welcome to the compiler");
        }

        run(args[0], args[1], args[2]);
    }

    public static void run(String file_name, String debug, String asm) throws IOException, RecognitionException {
//        HashMap<String, Element> hash = new HashMap<>();
//        Element e = new Element("matthieu", "variable", "variable",12);
//        Element e2 = new Element("matthieu", "fonction", "fonction",20);
//        hash.put(e.getNom(), e);
//        hash.put(e2.getNom(), e2);
//        Element e_get = hash.get("matthieu");
//        System.out.println(e_get.getType());
        Antlr_tool antlr;
        if(debug.equals("yes")){
            antlr = new Antlr_tool(true);
        }
        else{
            antlr = new Antlr_tool(false);
        }

        InputStream file = new FileInputStream(file_name);

        antlr.init(file);

        TDS tds = new TDS(0,0,null);
        TDT tdt = new TDT();
//        System.out.println(t.getType() + " " + t.getChild(0).getParent() + " " +t.getChild(0).getChild(3).getChild(1));
        if(debug.equals("yes")) {
            System.out.println("-----------------------------");
            System.out.println("First pass");
        }

        antlr.firstPass(tdt);

        if(debug.equals("yes")) {
            System.out.println("-----------------------------\n");
            tdt.display();
            System.out.println("-----------------------------");
            System.out.println("Second pass");
        }

        antlr.secondPass(tds);

        if(debug.equals("yes")){
            System.out.println("-----------------------------\n");
            System.out.println("-----------------------------");
            System.out.println("Display of symbol table");
            tds.display();
            System.out.println("-----------------------------\n");
        }


        if(asm.equals("yes")){
            File file_erase = new File(file_name.substring(0, file_name.indexOf('.')) + ".src");
            file_erase.delete();
            FileWriter writer = new FileWriter(file_name.substring(0, file_name.indexOf('.')) + ".src", true);
            antlr.setTDS(tds);
            WriterToFile wr;
            if(debug.equals("yes")){
                wr = new WriterToFile(writer, tdt,antlr, "yes");
            }
            else{
                wr = new WriterToFile(writer, tdt,antlr, "no");
            }
            wr.initialize();
            antlr.setWriter(wr);



            BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(file_name.substring(0, file_name.indexOf('.')) + ".src"));
            lecteurAvecBuffer.close();
            antlr.fourthPass();

            wr.endFile();
            wr.close();

            if(debug.equals("yes")){
                System.out.println("-----------------------------\n");
            }
        }

    }
}
