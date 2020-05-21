import MLL.MLLBaseVisitor;
import MLL.MLLParser;
import java.util.HashMap;
import java.util.Stack;


public class MyVisitor extends MLLBaseVisitor<String> {

    HashMap<String, TValue> consts = new HashMap<>();
    Stack <HashMap<String, TValue>> functionTables = new Stack<>();
    Stack <HashMap<String, TValue>> tables = new Stack<>();
    Stack <HashMap <String, TValue>> currentStack;
    HashMap<String, TValue> currentTable;
    HashMap<String, TValue> literals = new HashMap<>();

    public void setVariable(TValue tv) throws Exception {
        if (currentTable.containsKey(tv.getVarName())) {
            System.out.println("SetInTable in CurTab: " + tv.getVarName() + ": " + tv.getValue());
            currentTable.replace(tv.getVarName(), tv);
            return;
        }
        for (HashMap<String, TValue> hm : currentStack) {
            if (hm.containsKey(tv.getVarName())){
                System.out.println("SetInTable in CurStack: " + tv.getVarName() + ": " + tv.getValue());
                hm.replace(tv.getVarName(), tv);
                return;
            }
        }
        currentTable.put(tv.getVarName(), tv);
        System.out.println("SetInTable put in curTab: " + tv.getVarName() + ": " + tv.getValue());
        throw new Exception("No such variable in the table");
    }

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
    public String visitIfStatment(MLLParser.IfStatmentContext ctx) {
        System.out.println("if :");
        String conclusionResult = visit(ctx.conclusionList());
        if (conclusionResult.equals("true")) {
            currentStack.push(currentTable);
            visit(ctx.block(0));
            currentTable = currentStack.pop();
        }
        return null;
    }

    @Override
    public String visitConclusionList(MLLParser.ConclusionListContext ctx) {
        for (int i = 0; i < ctx.conclusion().size(); i++) {
            String result = visitChildren(ctx);
            if (result == null) {
                System.err.println("Conclusion NULL exception");
                System.exit(1);
            }
            if (result.equals("false")) return "false";
        }
        return "true";
    }

    @Override
    public String visitExpConclusin(MLLParser.ExpConclusinContext ctx) {
        TValue tv = new TValue(visit(ctx.expression()));
        if (tv.isBool()) {
            if (tv.getBool())
                return "true";
            else return "false";
        } else return null;
    }

    @Override
    public String visitCallMethodeConlusin(MLLParser.CallMethodeConlusinContext ctx) {
        TValue tv = new TValue(visit(ctx.callMethode()));
        if (tv.isBool()) {
            if (tv.getBool())
                return "true";
            else return "false";
        } else return null;
    }

    @Override
    public String visitEqualsConclusion(MLLParser.EqualsConclusionContext ctx) {
        TValue left = new TValue(visit(ctx.expression(0)));
        TValue right = new TValue(visit(ctx.expression(1)));
        switch (ctx.op.getText()) {
            case "==":
                if (left.getType() == right.getType()) {
                    System.out.println("type equals");
                    if (left.getValue().equals(right.getValue())) {
                        return "true";
                    } else
                    if ((left.isInt() && right.isFloat())
                            || (left.isFloat() && right.isInt())
                            || (left.isFloat() && right.isFloat())){
                        if (left.getFloat() == right.getFloat()) {
                            return "true";
                        }
                    } else return "false";
                }
            case "!=":
                break;
        }
        return null;
    }

    @Override
    public String visitMultipliesExpression(MLLParser.MultipliesExpressionContext ctx) {
        TValue left =  new TValue(visit(ctx.expression(0)));
        TValue right = new TValue(visit(ctx.expression(1)));
        switch (ctx.op.getText()){ //'*' | '/' | '%'
            case "*":
                if (left.isInt() && right.isInt()) {
                    return String.valueOf(left.getInt() * right.getInt());
                } else if ((left.isInt() && right.isFloat())
                        || (left.isFloat() && right.isInt())
                        || (left.isFloat() && right.isFloat())) {
                    return String.valueOf(left.getFloat() * right.getFloat());
                }
            case "/":
                if (left.isInt() && right.isInt()) {
                    return String.valueOf(left.getInt() / right.getInt());
                } else if ((left.isInt() && right.isFloat())
                        || (left.isFloat() && right.isInt())
                        || (left.isFloat() && right.isFloat())) {
                    return String.valueOf(left.getFloat() / right.getFloat());
                }
            case "%":
                if (left.isInt() && right.isInt()) {
                    return String.valueOf(left.getInt() % right.getInt());
                } else if ((left.isInt() && right.isFloat())
                        || (left.isFloat() && right.isInt())
                        || (left.isFloat() && right.isFloat())) {
                    return String.valueOf(left.getFloat() % right.getFloat());
                }
        }
        return null;
    }

    @Override
    public String visitParenExpression(MLLParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitSummExpression(MLLParser.SummExpressionContext ctx) {
        TValue left =  new TValue(visit(ctx.expression(0)));
        TValue right = new TValue(visit(ctx.expression(1)));
        switch (ctx.op.getText()){
            case "+":
                if (left.isInt() && right.isInt()) {
                    return String.valueOf(left.getInt() + right.getInt());
                } else if ((left.isInt() && right.isFloat())
                        || (left.isFloat() && right.isInt())
                        || (left.isFloat() && right.isFloat())) {
                    return String.valueOf(left.getFloat() + right.getFloat());
                } else if (left.isChar() && right.isChar()) {
                    return String.valueOf(left.getChar() + right.getChar());
                }
            case "-":
                if (left.isInt() && right.isInt()) {
                    return String.valueOf(left.getInt() - right.getInt());
                } else if ((left.isInt() && right.isFloat())
                        || (left.isFloat() && right.isInt())
                        || (left.isFloat() && right.isFloat())) {
                    return String.valueOf(left.getFloat() - right.getFloat());
                } else if (left.isChar() && right.isChar()) {
                    return String.valueOf(left.getChar() - right.getChar());
                }
        }
        return null;
    }

    @Override
    public String visitConsts(MLLParser.ConstsContext ctx) {
        currentTable = consts;
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitCompilationUnit(MLLParser.CompilationUnitContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitBlock(MLLParser.BlockContext ctx) {
        System.out.println("{");
        HashMap<String, TValue> currentBlocktable = new HashMap<>();
        currentTable = currentBlocktable;
        visitChildren(ctx);
        System.out.println("}");
        return null;
    }

    @Override
    public String visitMainProg(MLLParser.MainProgContext ctx) {
        currentStack = tables;
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitStatment(MLLParser.StatmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitVarDeclaration(MLLParser.VarDeclarationContext ctx) {
        String varName = ctx.varname().getText();
        String type = ctx.type().getText();
        String value = null;
        TValue var = new TValue(varName, type, value);
        if (ctx.children.contains(ctx.expression())) {
            TValue r =  new TValue(visit(ctx.expression()));
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
    public String visitExpressionList(MLLParser.ExpressionListContext ctx) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ctx.expression().size(); i ++) {
            result.append(visit(ctx.expression(i)));
            result.append(" ");
        }
        return result.toString();
    }

    @Override
    public String visitPrint(MLLParser.PrintContext ctx) {
        String toPrint = visit(ctx.expressionList());
        System.out.println("print( " + toPrint + ")");
        return null;
    }

    @Override
    public String visitVarNameExpression(MLLParser.VarNameExpressionContext ctx) {
        try {
            System.out.println("GetVariable:" + ctx.getText() + " is: " + getVariable(ctx.getText()));
            return getVariable(ctx.getText()).getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String visitAssigmentExpression(MLLParser.AssigmentExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAssigment(MLLParser.AssigmentContext ctx) {
        try {
            String varName = ctx.varname().getText();
            TValue exp = new TValue(visit(ctx.expression()));
            exp.setVarName(varName);
            if (getVariable(varName).getType() == exp.getType()) {
                setVariable(exp);
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
    public String visitLiteral(MLLParser.LiteralContext ctx) {
        if (ctx.charLiteral()!= null) return ctx.charLiteral().LETTERS().getText();
        return ctx.getText();
    }
}
