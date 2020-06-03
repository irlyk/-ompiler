package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import symbol.*;

import static jdk.internal.org.objectweb.asm.Opcodes.FLOAD;
import static jdk.internal.org.objectweb.asm.Opcodes.ILOAD;

public class Id extends Expr {

        public int offset;     // relative address

        public Id(String id, Type p, int b) { super(id, p); offset = b; }

        public String toString(){ return op.toString(); }

        public void genJVM(){
                if (Type.Int.equals(type) || Type.Bool.equals(type) || Type.Char.equals(type)) {
                        Compiler.mv.visitIntInsn(ILOAD, offset);
                } else if (Type.Float.equals(type)){
                        Compiler.mv.visitIntInsn(FLOAD, offset);
                }
                System.out.println("LOAD_" + offset);
        }
}
