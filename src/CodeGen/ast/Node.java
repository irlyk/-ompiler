package CodeGen.ast;


public class Node {
    int lexline = 0;

    Node() {}
    Node(int i) { lexline = i; }

    void error(String s) { throw new Error("near line " + " ? " + ": " + s); }
}
