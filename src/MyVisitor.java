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

    private Object getVariable(String varName) throws Exception {
        for (HashMap<String, Object> hm : currentStack) {
            if (hm.containsKey(varName)){
                return hm.get(varName);
            }
        }
        if (consts.containsKey(varName)) {
            return consts.get(varName);
        }

        throw new Exception("No such variable in the table");
    }

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
        currentStack = tables;
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
        Object value = null;
        if (ctx.children.contains(ctx.expression()))
            value = visit(ctx.expression());
        currentTable.put(varName, value);
        if (value != null)
            System.out.println("VarDeclaration: " + type + " " + varName + " " + value.toString());
        else
            System.out.println("VarDeclaration (no value): " + type + " " + varName + " as NULL");
        return null;
    }


    @Override
    public Object visitVarNameExpression(MLLParser.VarNameExpressionContext ctx) {
        try {
            System.out.println("GetVariable:" + ctx.getText() + " is: " + getVariable(ctx.getText()));
            return getVariable(ctx.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        System.out.println("Char: " + ctx.LETTERS().getText());
        return new Character(ctx.LETTERS().getText().charAt(0));
    }


}
