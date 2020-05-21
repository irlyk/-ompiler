public class TValue {

    private enum Type {
        INT, FLOAT, CHAR, BOOLEAN, NULL
    }

    private String varName;
    private Type type;
    private String value;

    private boolean isInteger(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean isFloat (String value){
        boolean dotFalg = false;
        if (!Character.isDigit(value.charAt(0))) return false;
        for (int i = 1; i < value.length(); i++){
            if (!Character.isDigit(value.charAt(i))) {
                if (!dotFalg && value.charAt(i) == '.')
                    dotFalg = true;
                 else return false;
            }
        }
        return true;
    }

    private boolean isBool(String value) {
        return value.equals("true") || value.equals("false");
    }

    private boolean isChar (String value) {
        return value.length() == 1;
    }

    public TValue (String value) {
        if (value == null || value.equals("")) this.value = null;
        else if (isInteger(value)){
            this.type = makeType("int");
        } else if (isFloat(value)){
            this.type = makeType("float");
        } else if (isBool(value)){
            this.type = makeType("bool");
        } else if (isChar(value)) {
            this.type = makeType("char");
        } else this.type = Type.NULL;
        this.value = value;
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


    public TValue(String varName, String type, String value){
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

    public String getValue() {
        return value;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getInt() {
        return Integer.parseInt(value);
    }

    public float getFloat() {
        return Float.parseFloat(value);
    }

    public char getChar() {
        return value.charAt(0);
    }

    public boolean getBool() {
        return value.equals("true");
    }

    public Boolean isInt(){ return type == Type.INT; }
    public Boolean isFloat(){ return type == Type.FLOAT; }
    public Boolean isChar(){ return type == Type.CHAR; }
    public Boolean isBool(){ return type == Type.BOOLEAN; }

    @Override
    public String toString() {
        if (this.value != null) {
            return value.toString();
        } else {
            return "NULL";
        }
    }
}
