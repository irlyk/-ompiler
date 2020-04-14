// Generated from C:/Users/irlyk/Desktop/Compiler/src/MLL\MLL.g4 by ANTLR 4.8
package MLL;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MLLParser}.
 */
public interface MLLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MLLParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(MLLParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(MLLParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(MLLParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(MLLParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MLLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MLLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#consts}.
	 * @param ctx the parse tree
	 */
	void enterConsts(MLLParser.ConstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#consts}.
	 * @param ctx the parse tree
	 */
	void exitConsts(MLLParser.ConstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#callMethode}.
	 * @param ctx the parse tree
	 */
	void enterCallMethode(MLLParser.CallMethodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#callMethode}.
	 * @param ctx the parse tree
	 */
	void exitCallMethode(MLLParser.CallMethodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#mainProg}.
	 * @param ctx the parse tree
	 */
	void enterMainProg(MLLParser.MainProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#mainProg}.
	 * @param ctx the parse tree
	 */
	void exitMainProg(MLLParser.MainProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#statment}.
	 * @param ctx the parse tree
	 */
	void enterStatment(MLLParser.StatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#statment}.
	 * @param ctx the parse tree
	 */
	void exitStatment(MLLParser.StatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MLLParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MLLParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MLLParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MLLParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MLLParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MLLParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MLLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MLLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MLLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MLLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(MLLParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(MLLParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MLLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MLLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#varname}.
	 * @param ctx the parse tree
	 */
	void enterVarname(MLLParser.VarnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#varname}.
	 * @param ctx the parse tree
	 */
	void exitVarname(MLLParser.VarnameContext ctx);
}