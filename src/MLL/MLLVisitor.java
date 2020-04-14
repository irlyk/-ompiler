// Generated from C:/Users/irlyk/Desktop/Compiler/src/MLL\MLL.g4 by ANTLR 4.8
package MLL;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MLLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MLLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MLLParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(MLLParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(MLLParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MLLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#consts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsts(MLLParser.ConstsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#callMethode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethode(MLLParser.CallMethodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#mainProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainProg(MLLParser.MainProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatment(MLLParser.StatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MLLParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MLLParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MLLParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MLLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MLLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#floatLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(MLLParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MLLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#varname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarname(MLLParser.VarnameContext ctx);
}