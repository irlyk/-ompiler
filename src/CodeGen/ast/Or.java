package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import jdk.internal.org.objectweb.asm.Opcodes;

public class Or extends Logical {

    public Or(String s, Expr x1, Expr x2) { super(s, x1, x2); }

    public void genJVM() {
        System.out.println("OR!!");
        expr1.genJVM();
        expr2.genJVM();
        System.out.println("IADD");
        Compiler.mv.visitInsn(Opcodes.IADD);
    }
}
