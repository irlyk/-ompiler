package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import symbol.Type;

public class If extends Stmt {

    Expr expr; Stmt stmt;


    public If(Expr x, Stmt s) {
        expr = x;  stmt = s;
        if( expr.type != Type.Bool ) expr.error("boolean required in if");
    }


    public void genJVM() {
        expr.genJVM();
        Label trueLabel = new Label();
        Label endLabel = new Label();
        Compiler.mv.visitJumpInsn(Opcodes.IFNE, trueLabel);
        Compiler.mv.visitJumpInsn(Opcodes.GOTO, endLabel);
        Compiler.mv.visitLabel(trueLabel);

        stmt.genJVM();
        Compiler.mv.visitLabel(endLabel);
    }
}
