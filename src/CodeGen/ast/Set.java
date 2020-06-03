package CodeGen.ast;

import CodeGen.Compiler.Compiler;
import symbol.*;

import static jdk.internal.org.objectweb.asm.Opcodes.FSTORE;
import static jdk.internal.org.objectweb.asm.Opcodes.ISTORE;

public class Set extends Stmt {

    public Id id; public Expr expr;

    public Set (Id i) {
        id = i; expr = null;
    }

    public Set(Id i, Expr x) {
        id = i; expr = x;
        if ( check(id.type, expr.type) == null ) error("type error");
    }

    public Type check(Type p1, Type p2) {
        if ( Type.numeric(p1) && Type.numeric(p2) ) return p2;
        else if ( p1 == Type.Bool && p2 == Type.Bool ) return p2;
        else return null;
    }

    public void genJVM(){
        Type p = id.type;
        expr.genJVM();
        if (Type.Int.equals(p)) {
            Compiler.mv.visitVarInsn(ISTORE, id.offset);
        } else if (Type.Float.equals(p)) {
            Compiler.mv.visitVarInsn(FSTORE, id.offset);
        } else if (Type.Char.equals(p)) {
            Compiler.mv.visitVarInsn(ISTORE, id.offset);
        } else if (Type.Bool.equals(p)) {
            Compiler.mv.visitVarInsn(ISTORE, id.offset);
        }
    }
}
