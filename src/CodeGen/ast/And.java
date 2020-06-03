package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Opcodes;


public class And extends Logical {

    public And(String s, Expr x1, Expr x2) { super(s, x1, x2); }

    public void genJVM() {
        expr1.genJVM();
        expr2.genJVM();
        Compiler.mv.visitInsn(Opcodes.IMUL);
    }
}
