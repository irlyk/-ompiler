package CodeGen.ast;
import CodeGen.Compiler.Compiler;
import symbol.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class Constant extends Expr {

    public Constant(String s, Type t) {
        super(s, t);
    }

    public static final Constant
            True = new Constant("true", Type.Bool),
            False = new Constant("false", Type.Bool);


    public void genJVM(){
        Type p = type;
        if (Type.Int.equals(p)) {
            int i = Integer.parseInt(op.toString());
            if (Math.abs(i) >= 128) {
                Compiler.mv.visitIntInsn(SIPUSH, i);
                System.out.println("SIPUSH_" + i);
            }
            else {
                Compiler.mv.visitIntInsn(BIPUSH, i);
                System.out.println("BIPUSH_" + i);
            }
        } else if (Type.Float.equals(p)) {
            Compiler.mv.visitLdcInsn(Float.parseFloat(op.toString()));
            System.out.println("LDC_" + op);
        } else if (Type.Char.equals(p)) {
            Compiler.mv.visitIntInsn(BIPUSH, (int) (op.toString().charAt(0)));
            System.out.println("BIPUSH_" + (int)op.charAt(0));
        } else if (Type.Bool.equals(p)) {
            if (Boolean.parseBoolean(op.toString())) Compiler.mv.visitInsn(ICONST_1);
            else Compiler.mv.visitInsn(ICONST_0);
            System.out.println("ICONST_" + op);
        }

    }
}
