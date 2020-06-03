package CodeGen.ast;

import symbol.Type;

public class EList extends Expr {

    Expr x1, x2;
    String toPr;

    public EList(Expr x1, Expr x2) {
        super("elist: ", new Type("str", 0));
        this.x1 = x1;
        this.x2 = x2;
    }
}
