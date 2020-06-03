package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.Opcodes;
import symbol.Type;

public class Else extends Stmt {

    Expr expr; Stmt stmt1, stmt2;

    public Else(Expr x, Stmt s1, Stmt s2) {
        expr = x; stmt1 = s1; stmt2 = s2;
        if( expr.type != Type.Bool ) expr.error("boolean required in if");
    }

    public void genJVM(){
        expr.genJVM();
        Label trueLabel = new Label();
        Label endLabel = new Label();
        Compiler.mv.visitJumpInsn(Opcodes.IFNE, trueLabel);
        stmt2.genJVM();
        Compiler.mv.visitJumpInsn(Opcodes.GOTO, endLabel);
        Compiler.mv.visitLabel(trueLabel);
        stmt1.genJVM();
        Compiler.mv.visitLabel(endLabel);
    }
}
