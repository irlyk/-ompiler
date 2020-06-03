package CodeGen.ast;

import symbol.*;

public class Expr extends Node {

    public String op;
    public Type type;

    public Expr(String s, Type t) { op = s; type = t; }

    public String toString() { return op.toString(); }


    public void genJVM(){
    }
}