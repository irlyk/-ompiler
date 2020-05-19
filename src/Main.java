import MLL.MLLLexer;
import MLL.MLLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        try {
            ANTLRInputStream input = new ANTLRInputStream(
                    //new FileInputStream(args[0])
                    new FileInputStream(new File("src/expl2"))
            );
            MLLLexer lexer = new MLLLexer(input);
            MLLParser parser = new MLLParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.compilationUnit();
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
