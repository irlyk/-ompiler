package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import symbol.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class Arith extends Op {

    public Expr expr1, expr2;

    public Arith(String s, Expr x1, Expr x2)  {
        super(s, null); expr1 = x1; expr2 = x2;
        type = Type.max(expr1.type, expr2.type);
        if (type == null ) error("type error");
    }

    public void genJVM() {
        expr1.genJVM();
        expr2.genJVM();
        switch (op) {
            case "+":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(FADD);
                else Compiler.mv.visitInsn(IADD);
                break;
            case "-":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(FSUB);
                else Compiler.mv.visitInsn(ISUB);
                break;
            case "*":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(FMUL);
                else Compiler.mv.visitInsn(IMUL);
                break;
            case "/":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(FDIV);
                else Compiler.mv.visitInsn(IDIV);
                break;
        }

    }
}
