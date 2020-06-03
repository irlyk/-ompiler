package CodeGen.ast;
import symbol.Type;

public class ObjConstant extends Stmt {

    public String varName;
    public String value;
    public Type type;

    public String getVarName() { return varName; }

    public String getValue() { return value; }

    public Type getType() { return type; }
    // Expr expr;

    public ObjConstant (String varName, Type type, String value) {
        this.varName = varName; this.type = type; this.value = value;
    }

}
