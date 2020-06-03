package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;


public class While extends Stmt {

    Expr expr; Stmt stmt;

    public While(Expr x, Stmt s) { expr = null; stmt = null; }

    public void genJVM() {
        Label startCicle = new Label();
        Label endCicle = new Label();
        Label statments = new Label();
        Compiler.mv.visitLabel(startCicle);
        expr.genJVM();
        Compiler.mv.visitJumpInsn(Opcodes.IFNE, statments);
        Compiler.mv.visitJumpInsn(Opcodes.GOTO, endCicle);
        Compiler.mv.visitLabel(statments);
        stmt.genJVM();
        Compiler.mv.visitJumpInsn(Opcodes.GOTO, startCicle);
        Compiler.mv.visitLabel(endCicle);
    }
}

