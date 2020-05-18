import MLL.MLLBaseVisitor;
import MLL.MLLParser;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Stack;

public class MyVisitor extends MLLBaseVisitor<Object> {
    HashMap<String, Object> consts = new HashMap<>();
    Stack <HashMap<String, Object>> functionTables = new Stack<>();
    Stack <HashMap<String, Object>> tables = new Stack<>();
    Stack <HashMap <String, Object>> currentStack;
    HashMap<String, Object> currentTable;

    @Override public Object visitConsts(MLLParser.ConstsContext ctx) {
        currentTable = consts;
        return visitChildren(ctx);
    }

    @Override
    public Object visitCompilationUnit(MLLParser.CompilationUnitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBlock(MLLParser.BlockContext ctx) {
        HashMap<String, Object> currentBlocktable = new HashMap<>();
        currentTable = currentBlocktable;
        tables.add(currentBlocktable);
        return visitChildren(ctx);
    }

    @Override
    public Object visitMainProg(MLLParser.MainProgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatment(MLLParser.StatmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVarDeclaration(MLLParser.VarDeclarationContext ctx) {
        String varName = ctx.varname().getText();
        String type = ctx.type().getText();
        //Object value = visit(ctx.expression());
        //currentTable.put(varName, value);
        //System.out.println("VarDecalaration: " + type + " " + varName + " " + value.toString());
        return visitChildren(ctx);
    }


    @Override
    public Object visitLiteral(MLLParser.LiteralContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFloatLiteral(MLLParser.FloatLiteralContext ctx) {
        System.out.println("Float: " + ctx.getText());
        return Float.parseFloat(ctx.getText());
    }

    @Override
    public Object visitIntLiteral(MLLParser.IntLiteralContext ctx) {
        System.out.println("Integer: " + ctx.getText());
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitBoolLiteral(MLLParser.BoolLiteralContext ctx) {
        System.out.println("Boolean: " + ctx.getText());
        return Boolean.parseBoolean(ctx.getText());
    }

    @Override
    public Object visitCharLiteral(MLLParser.CharLiteralContext ctx) {
        System.out.println("Char: " + ctx.getText());
        return Character.codePointOf(ctx.getText());
    }


}
