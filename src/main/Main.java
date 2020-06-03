package main;

import MLL.MLLLexer;
import MLL.MLLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.MyVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        try {
            if (args.length < 1) {
                System.out.println("input file path required!");
                return;
            }
            String inputFile = args[0];
            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(new File( inputFile))
            );
            MLLLexer lexer = new MLLLexer(input);
            MLLParser parser = new MLLParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.compilationUnit();
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
