import MLL.MLLLexer;
import MLL.MLLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

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
                    new FileInputStream(new File("src/example.txt"))
            );
            MLLLexer lexer = new MLLLexer(input);
            MLLParser parser = new MLLParser(new CommonTokenStream(lexer));
            parser.addParseListener(new MyListener());
            parser.compilationUnit();
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
