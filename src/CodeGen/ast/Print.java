package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import symbol.Type;

import static jdk.internal.org.objectweb.asm.Opcodes.GETSTATIC;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class Print extends Stmt {
    Expr expr;

    public Print(Expr x) {
        expr = x;
//        if ( expr1.type == null || expr2.type == null ) error("type error");
    }



    public void genJVM() {
        System.out.println("GETSTATIC, java/lang/System, out, Ljava/io/PrintStream;");
        Compiler.mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expr.genJVM();
        String t = "";
        if (Type.Int.equals(expr.type)) t = "(I)V";
        else if (Type.Float.equals(expr.type)) t = "(F)V";
        else if (Type.Char.equals(expr.type)) t = "(C)V";
        else if (Type.Bool.equals(expr.type)) t = "(Z)V";
        Compiler.mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", t, false);
        System.out.println("INVOKEVIRTUAL, java/io/PrintStream, println, " + t);
    }
}
