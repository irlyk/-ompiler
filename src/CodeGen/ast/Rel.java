package CodeGen.ast;

import CodeGen.Compiler.Compiler;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import symbol.Type;

public class Rel extends Logical {


    public Rel(String s, Expr x1, Expr x2) { super(s, x1, x2); }

    public Type check(Type p1, Type p2) {
        if( p1 == p2 ) return Type.Bool;
        else return null;
    }

    public void genJVM() {
        expr1.genJVM();
        expr2.genJVM();
        Label endLabel = new Label();
        Label trueLabel = new Label();
        switch (op) {
            case ">":
                Compiler.mv.visitJumpInsn(Opcodes.IF_ICMPGE, trueLabel);
                break;
            case "<":
                Compiler.mv.visitJumpInsn(Opcodes.IF_ICMPLE, trueLabel);
                break;
            case "==":
                Compiler.mv.visitJumpInsn(Opcodes.IF_ICMPEQ, trueLabel);
                break;
            case ">=":
                Compiler.mv.visitJumpInsn(Opcodes.IF_ICMPGT, trueLabel);
                break;
            case "<=":
                Compiler.mv.visitJumpInsn(Opcodes.IF_ICMPLT, trueLabel);
                break;
        }
        Compiler.mv.visitInsn(Opcodes.ICONST_0);
        Compiler.mv.visitJumpInsn(Opcodes.GOTO, endLabel);
        Compiler.mv.visitLabel(trueLabel);
        Compiler.mv.visitInsn(Opcodes.ICONST_1);
        Compiler.mv.visitLabel(endLabel);
    }
}