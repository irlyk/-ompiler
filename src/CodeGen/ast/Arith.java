package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Opcodes;
import symbol.Type;


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
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(Opcodes.FADD);
                else Compiler.mv.visitInsn(Opcodes.IADD);
                break;
            case "-":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(Opcodes.FSUB);
                else Compiler.mv.visitInsn(Opcodes.ISUB);
                break;
            case "*":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(Opcodes.FMUL);
                else Compiler.mv.visitInsn(Opcodes.IMUL);
                break;
            case "/":
                if (Type.Float.equals(type)) Compiler.mv.visitInsn(Opcodes.FDIV);
                else Compiler.mv.visitInsn(Opcodes.IDIV);
                break;
        }

    }
}
