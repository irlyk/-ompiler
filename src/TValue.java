public class TValue {

    private enum Type {
        INT, FLOAT, CHAR, BOOLEAN
    }

    private String varName;
    private Type type;



    private Object value;


    public TValue(String varName){
        this.varName = varName;
    }

    private Type makeType(String type){
        switch (type){
            case "int":
                return Type.INT;
            case "float":
                return Type.FLOAT;
            case "char":
                return Type.CHAR;
            case "bool":
                return Type.BOOLEAN;
        }
        return null;
    }

    public TValue(String varName, String type){
        this.varName = varName;
        this.type = makeType(type);
    }


    public TValue(String varName, String type, Object value){
        this.varName = varName;
        this.type = makeType(type);
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        switch (type){
            case INT:
                return new Integer(value.toString());
            case FLOAT:
                return new Float(value.toString());
            case CHAR:
                return new Character(value.toString().charAt(0));
            case BOOLEAN:
                return new Boolean(value.toString());
        }
        return null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (this.value != null) {
            return value.toString();
        } else {
            return "NULL";
        }
    }
}
