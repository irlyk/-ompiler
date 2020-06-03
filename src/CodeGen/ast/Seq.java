package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import jdk.internal.org.objectweb.asm.Label;

public class Seq extends Stmt {

    Stmt stmt1; Stmt stmt2;

    public Seq(Stmt s1, Stmt s2) { stmt1 = s1; stmt2 = s2; }


    public void genJVM() {
        if ( stmt1 == Stmt.Null ) {
            stmt2.genJVM();
        }
        else if ( stmt2 == Stmt.Null ) {
            stmt1.genJVM();
        }
        else {
            Label l1 = new Label();
            Compiler.mv.visitLabel(l1);
            stmt1.genJVM();
            Label l2 = new Label();
            Compiler.mv.visitLabel(l1);
            stmt2.genJVM();
        }
    }
}