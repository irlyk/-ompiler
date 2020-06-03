package visitor;

import CodeGen.ast.*;
import CodeGen.Compiler.Compiler;
import CodeGen.ast.Node;
import MLL.MLLBaseVisitor;
import MLL.MLLParser;
import symbol.Env;
import symbol.Type;

import java.io.File;
import java.util.Stack;

public class MyVisitor extends MLLBaseVisitor<Node> {
    Env consts = null;
    Env top = null;
    int used = 0;

    void error(String s) { throw new Error("near line " + s); }

    @Override
    public Node visitConsts(MLLParser.ConstsContext ctx) {

        consts = new Env(null);
        Stack<Stmt> stack = new Stack<>();
        for (int i = 0; i < ctx.varDeclaration().size(); i++) {
            String varName = ctx.varDeclaration(i).varname().getText();
            Id id = consts.get(varName);
            if (id != null) {
                Type type = Type.getType(ctx.varDeclaration(i).type().getText());
                String value = ctx.varDeclaration(i).expression().toString();
                ObjConstant con = new ObjConstant(varName, type, value);
                consts.put(varName, new Id(varName, type, 0));
                stack.push((Stmt)con);
            } else error(ctx.start.getText() + " const already exist");
        }
        if (stack.size() > 1) {
            Stmt s1 = stack.pop();
            Seq seq = new Seq(stack.pop(), s1);
            while (!stack.empty()) {
                seq = new Seq(stack.pop(), s1);
            }
            return seq;
        } else {
            return stack.pop();
        }
    }

    @Override
    public Node visitCompilationUnit(MLLParser.CompilationUnitContext ctx) {
        // Stmt con = (Stmt) visit(ctx.consts());
        Stmt main = (Stmt)visit(ctx.mainProg());

        // jvm код
        Compiler t = new Compiler(main);
        t.generateClass(new File("test.class"));

        return main;
    }

    @Override
    public Node visitMainProg(MLLParser.MainProgContext ctx) {
        top = new Env(consts);
        return visit(ctx.block());
    }

    @Override
    public Node visitBlock(MLLParser.BlockContext ctx) {
        Env savedEnv = top;
        top = new Env(top);

        // проход по всем Stmt и объединение их в Seq(Stmt1, Seq(Stmt2, Seq(Stmt3, Stmt.Null)))
        Stack<Stmt> stack = new Stack<>();
        for (int i = 0; i < ctx.statment().size(); i++) {
            stack.push((Stmt) visit(ctx.statment(i)));
        }
        Seq seq = new Seq(stack.pop(), Stmt.Null);
        while (!stack.empty()) {
            seq = new Seq(stack.pop(), seq);
        }

        Stmt s = seq;
        top = savedEnv;
        return s;
    }

    @Override
    public Node visitStatment(MLLParser.StatmentContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitWhileStatment(MLLParser.WhileStatmentContext ctx) {
        Expr x = (Expr)visit(ctx.conclusionList());
        Stmt s1 = (Stmt) visit(ctx.block());
        return new While(x, s1);
    }

    @Override
    public Node visitIfStatment(MLLParser.IfStatmentContext ctx) {
        Expr x; Stmt s1, s2;
        x = (Expr) visit(ctx.conclusionList());
        s1 = (Stmt) visit(ctx.block(0));
        if (ctx.block(1) != null) {
            s2 = (Stmt) visit(ctx.block(1));
            return new Else(x, s1, s2);
        }
        return new If(x, s1);
    }

    @Override
    public Node visitConclusionList(MLLParser.ConclusionListContext ctx) {
        Expr x = (Expr)visit(ctx.conclusion(0));
        if (ctx.conclusion().size() > 1) {
            for (int i = 1; i < ctx.conclusion().size(); i++) {
                switch (ctx.pob.getText()) {
                    case "and":
                        x = new And("and", x, (Expr) visit(ctx.conclusion(i)));
                    case "or":
                        x = new Or("or", x, (Expr) visit(ctx.conclusion(i)));
                }
            }
        }
        return x;
    }

    @Override
    public Node visitEqualsConclusion(MLLParser.EqualsConclusionContext ctx) {
        return new Rel(ctx.op.getText(), (Expr) visit(ctx.expression(0)), (Expr) visit(ctx.expression(1)));
    }

    @Override
    public Node visitLessThenConclusion(MLLParser.LessThenConclusionContext ctx) {
        return new Rel(ctx.op.getText(), (Expr) visit(ctx.expression(0)), (Expr) visit(ctx.expression(1)));
    }

    @Override
    public Node visitMoreThenConclusion(MLLParser.MoreThenConclusionContext ctx) {
        return new Rel(ctx.op.getText(), (Expr) visit(ctx.expression(0)), (Expr) visit(ctx.expression(1)));
    }

    @Override
    public Node visitVarNameExpression(MLLParser.VarNameExpressionContext ctx) {
        String s = ctx.varname().getText();
        Id id = top.get(s);
        if( id == null ) error( ctx.start.getLine() + ": " + s + " undeclared");
        return id;
    }

    @Override
    public Node visitAssigment(MLLParser.AssigmentContext ctx) {
        String varName = ctx.varname().getText();
        Id id = top.get(varName);
        if( id == null ) error(  ctx.start.getLine() + ": " + varName + " undeclared");
        Expr x = (Expr) visit(ctx.expression());
        if ( x == null ) error( ctx.start.getLine() + ": " + " bad expression");
        return new Set(id, x);
    }

    // return Declare
    @Override
    public Node visitVarDeclaration(MLLParser.VarDeclarationContext ctx) {
        String varName = ctx.varname().getText();
        Type p = Type.getType(ctx.type().getText());
        if (p == null) error(ctx.start.getLine() + ": " + varName + " null type exception");
        Id id = new Id(varName, p, ++used );
        top.put(varName, id);
        if (ctx.expression() != null) {
            Expr x = (Expr) visit(ctx.expression());
            top.put(varName, id);
            return new Declare(id, x);
        }
        return new Declare(id);
    }

    @Override
    public Node visitPrint(MLLParser.PrintContext ctx) {
        return visit(ctx.expressionList());
    }

    @Override
    public Node visitExpressionList(MLLParser.ExpressionListContext ctx) {
        Stack<Expr> e = new Stack<>();
        for (int i = 0; i < ctx.expression().size(); i++)
            e.push((Expr) visit(ctx.expression(i)));
        Expr x1, x2;
        if (e.size() > 1) {
            x1 = e.pop();
            x2 = e.pop();
        } else return new Print(e.pop());
        EList p = new EList(x2, x1);
        while (!e.empty())
            p = new EList(e.pop(), p);
        return new Print(p);
    }

    // return: int|float|char|bool and Type in Constant
    @Override
    public Node visitLiteralExpression(MLLParser.LiteralExpressionContext ctx) {
        return visitChildren(ctx);
    }

    // return: 100 type.Int
    @Override
    public Node visitIntLiteral(MLLParser.IntLiteralContext ctx) {
        return new Constant(ctx.getText(), Type.Int);
    }

    // return: true Type.Bool
    @Override
    public Node visitBoolLiteral(MLLParser.BoolLiteralContext ctx) {
        switch (ctx.getText()) {
            case "true":
                return Constant.True;
            case "false":
                return Constant.False;
        }
        return null;
    }

    @Override
    public Node visitSummExpression(MLLParser.SummExpressionContext ctx) {
        return new Arith(ctx.op.getText(), (Expr) visit(ctx.expression(0)), (Expr) visit(ctx.expression(1)));
    }

    @Override
    public Node visitParenExpression(MLLParser.ParenExpressionContext ctx) {
        return (Expr) visit(ctx.expression());
    }

    @Override
    public Node visitMultipliesExpression(MLLParser.MultipliesExpressionContext ctx) {
        return new Arith(ctx.op.getText(), (Expr) visit(ctx.expression(0)), (Expr) visit(ctx.expression(1)));
    }

    // return: 3.0 Type .Float
    @Override
    public Node visitFloatLiteral(MLLParser.FloatLiteralContext ctx) {
        return new Constant(ctx.getText(), Type.Float);
    }

    // return: a-z Type.Char
    @Override
    public Node visitCharLiteral(MLLParser.CharLiteralContext ctx) {
        return new Constant(ctx.LETTERS().getText(), Type.Char);
    }
}
