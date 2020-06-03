package CodeGen.ast;
import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Opcodes;
import symbol.Type;


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
                Compiler.mv.visitIntInsn(Opcodes.SIPUSH, i);
            }
            else {
                Compiler.mv.visitIntInsn(Opcodes.BIPUSH, i);
            }
        } else if (Type.Float.equals(p)) {
            Compiler.mv.visitLdcInsn(Float.parseFloat(op.toString()));
        } else if (Type.Char.equals(p)) {
            Compiler.mv.visitIntInsn(Opcodes.BIPUSH, (int) (op.toString().charAt(0)));
        } else if (Type.Bool.equals(p)) {
            if (Boolean.parseBoolean(op.toString())) Compiler.mv.visitInsn(Opcodes.ICONST_1);
            else Compiler.mv.visitInsn(Opcodes.ICONST_0);
        }

    }
}
