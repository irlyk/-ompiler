package CodeGen.ast;


public class Stmt extends Node {

    public Stmt() { }

    public static Stmt Null = new Stmt();

    public void gen(int b, int a) {} // called with labels begin and after

    public static Stmt Enclosing = Stmt.Null;  // used for break stmts

    public void genJVM() { }
}