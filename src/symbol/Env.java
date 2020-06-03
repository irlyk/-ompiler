package symbol;

import CodeGen.ast.Id;

import java.util.HashMap;

public class Env {
    private HashMap<String, Id> table;
    protected Env prev;

    public Env(Env n) { table = new HashMap<>(); prev = n; }

    public void put(String v, Id i) { table.put(v, i); }

    public Id get(String t) {
        for(Env e = this; e != null; e = e.prev ) {
            Id found = (Id)(e.table.get(t));
            if( found != null ) return found;
        }
        return null;
    }
}
