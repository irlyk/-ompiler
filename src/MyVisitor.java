import MLL.MLLBaseVisitor;
import MLL.MLLParser;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.TransferQueue;

public class MyVisitor extends MLLBaseVisitor<Object> {
    HashMap<String, TValue> consts = new HashMap<>();
    Stack <HashMap<String, TValue>> functionTables = new Stack<>();
    Stack <HashMap<String, TValue>> tables = new Stack<>();
    Stack <HashMap <String, TValue>> currentStack;
    HashMap<String, TValue> currentTable;


    private TValue getVariable(String varName) throws Exception {
        if (currentTable.containsKey(varName))
            return currentTable.get(varName);
        for (HashMap<String, TValue> hm : currentStack) {
            if (hm.containsKey(varName)){
                return hm.get(varName);
            }
        }
        if (consts.containsKey(varName)) {
            return consts.get(varName);
        }

        throw new Exception("No such variable in the table");
    }

    @Override
    public Object visitIfStatment(MLLParser.IfStatmentContext ctx) {
        currentStack.push(currentTable);
        System.out.println("if :");
        visitChildren(ctx);
        currentTable = currentStack.pop();
        return null;
    }

    @Override
    public Object visitConclusionList(MLLParser.ConclusionListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConclusion(MLLParser.ConclusionContext ctx) {
        return null;
    }




    @Override
    public Object visitSummExpression(MLLParser.SummExpressionContext ctx) {
        TValue left = (TValue) visit(ctx.expression(0));
        TValue right = (TValue) visit(ctx.expression(1));
        switch (ctx.op.getText()){
            case "+":
                if (left.getType() && right.getType())
                return left + right;
                break;
            case "-":
                break;
        }
        return null;
    }

    @Override public Void visitConsts(MLLParser.ConstsContext ctx) {
        currentTable = consts;
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitCompilationUnit(MLLParser.CompilationUnitContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitBlock(MLLParser.BlockContext ctx) {
        System.out.println("{");
        HashMap<String, TValue> currentBlocktable = new HashMap<>();
        currentTable = currentBlocktable;
        visitChildren(ctx);
        System.out.println("}");
        return null;
    }

    @Override
    public Void visitMainProg(MLLParser.MainProgContext ctx) {
        currentStack = tables;
        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitStatment(MLLParser.StatmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitVarDeclaration(MLLParser.VarDeclarationContext ctx) {
        String varName = ctx.varname().getText();
        String type = ctx.type().getText();
        Object value = null;
        TValue var = new TValue(varName, type, value);
        if (ctx.children.contains(ctx.expression())) {
            TValue r = (TValue) visit(ctx.expression());
            if (r.getType() == var.getType())
                var.setValue(r.getValue());
            else {
                System.out.println("!!!Error!!! type exception");
                System.exit(-1);
            }
        }
        currentTable.put(varName, var);
        System.out.println(type + " " + varName + " " + var.toString());
        return null;
    }


    @Override
    public Object visitExpressionList(MLLParser.ExpressionListContext ctx) {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < ctx.expression().size(); i ++) {
            result.add(visit(ctx.expression(i)));
        }
        return result;
    }

    @Override
    public Void visitPrint(MLLParser.PrintContext ctx) {
        ArrayList<Object> expList = (ArrayList<Object>) visit(ctx.expressionList());
        String toPrint = "";
        for (Object e : expList){
            toPrint += e.toString() + " ";
        }
        System.out.println("print( " + toPrint + ")");
        return null;
    }

    @Override
    public TValue visitVarNameExpression(MLLParser.VarNameExpressionContext ctx) {
        try {
            System.out.println("GetVariable:" + ctx.getText() + " is: " + getVariable(ctx.getText()));
            return getVariable(ctx.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object visitAssigmentExpression(MLLParser.AssigmentExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAssigment(MLLParser.AssigmentContext ctx) {
        try {
            String varName = ctx.varname().getText();
            TValue exp = (TValue) visit(ctx.expression());
            if (getVariable(varName).getType() == exp.getType()) {
                currentTable.put(varName, exp);
                System.out.println("Assigment: " + varName + " " + exp.getType() + " " + exp.getValue());
            } else
                System.out.println("ASSIGMENT ERROR TYPE");
        } catch (Exception e) {
            System.out.println("!!!Error!!!");
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    @Override
    public Object visitLiteral(MLLParser.LiteralContext ctx) {
        if (ctx.boolLiteral() != null)
            return new TValue("lit", "bool", visit(ctx.boolLiteral()));
        else if (ctx.intLiteral() != null)
            return new TValue("lit", "int", visit(ctx.intLiteral()));
        else if (ctx.floatLiteral() != null)
            return new TValue("lit", "float", visit(ctx.floatLiteral()));
        else return new TValue("lit", "char", visit(ctx.charLiteral()));
    }

    @Override
    public Float visitFloatLiteral(MLLParser.FloatLiteralContext ctx) {
        return Float.parseFloat(ctx.getText());
    }

    @Override
    public Integer visitIntLiteral(MLLParser.IntLiteralContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Boolean visitBoolLiteral(MLLParser.BoolLiteralContext ctx) {
        return Boolean.parseBoolean(ctx.getText());
    }

    @Override
    public Character visitCharLiteral(MLLParser.CharLiteralContext ctx) {
        return new Character(ctx.LETTERS().getText().charAt(0));
    }


}
