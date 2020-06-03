package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import org.objectweb.asm.Opcodes;
import symbol.*;


public class Id extends Expr {

        public int offset;     // relative address

        public Id(String id, Type p, int b) { super(id, p); offset = b; }

        public String toString(){ return op.toString(); }

        public void genJVM(){
                if (Type.Int.equals(type) || Type.Bool.equals(type) || Type.Char.equals(type)) {
                        Compiler.mv.visitIntInsn(Opcodes.ILOAD, offset);
                } else if (Type.Float.equals(type)){
                        Compiler.mv.visitIntInsn(Opcodes.FLOAD, offset);
                }
        }
}
