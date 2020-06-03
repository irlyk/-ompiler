package CodeGen.Compiler;

import CodeGen.ast.Stmt;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Compiler {

    Stmt main;
    Stmt consts;
    public static MethodVisitor mv;
    private static ClassWriter cw;

    public Compiler() {}

    public Compiler(Stmt s) {main = s;}
    public Compiler (Stmt main, Stmt consts) { this.main = main; this.consts = consts; }

    public void generateClass(File file)
    {
        String className = file.getName();
        if(className.contains(".")) className = className.substring(0, className.lastIndexOf('.'));

        cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        FieldVisitor fv;
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

        // Сгенерировать константы
        if (consts != null) generateConst();



        mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMaxs(1,1);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");


        mv.visitInsn(Opcodes.RETURN);
        mv.visitEnd();

        // сгенерировать Main
        generateMain();

        cw.visitEnd();
        this.WriteClass(cw, file);
    }

    public void WriteClass(ClassWriter cw, File file){
        FileOutputStream fos;
        FileWriter test;
        try{
            fos = new FileOutputStream(file);
            fos.write(cw.toByteArray());
            fos.close();
        }
        catch (IOException ex){
            System.out.println("Writing class Error!");
        }
    }


    public void generateMain() {
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        if (main != null) main.genJVM();
        else System.out.println("Statement is clear");
        mv.visitMaxs(1,1);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitEnd();
    }


    public void generateConst() {
//        for (CValue cv : consts) {
//            cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC + Opcodes.ACC_FINAL,
//                    cv.varName,
//                    cv.getType(),
//                    null,
//                    cv.getValue());
//        }
    }


    public void generateFunction() {

    }
}
