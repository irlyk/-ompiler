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
	 * Enter a parse tree produced by {@link MLLParser#ifStatment}.
	 * @param ctx the parse tree
	 */
	void enterIfStatment(MLLParser.IfStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#ifStatment}.
	 * @param ctx the parse tree
	 */
	void exitIfStatment(MLLParser.IfStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#conclusionList}.
	 * @param ctx the parse tree
	 */
	void enterConclusionList(MLLParser.ConclusionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#conclusionList}.
	 * @param ctx the parse tree
	 */
	void exitConclusionList(MLLParser.ConclusionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#forStatment}.
	 * @param ctx the parse tree
	 */
	void enterForStatment(MLLParser.ForStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#forStatment}.
	 * @param ctx the parse tree
	 */
	void exitForStatment(MLLParser.ForStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#forInside}.
	 * @param ctx the parse tree
	 */
	void enterForInside(MLLParser.ForInsideContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#forInside}.
	 * @param ctx the parse tree
	 */
	void exitForInside(MLLParser.ForInsideContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MLLParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MLLParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#whileStatment}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatment(MLLParser.WhileStatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#whileStatment}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatment(MLLParser.WhileStatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 */
	void enterConclusion(MLLParser.ConclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 */
	void exitConclusion(MLLParser.ConclusionContext ctx);
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
	 * Enter a parse tree produced by {@link MLLParser#assigment}.
	 * @param ctx the parse tree
	 */
	void enterAssigment(MLLParser.AssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#assigment}.
	 * @param ctx the parse tree
	 */
	void exitAssigment(MLLParser.AssigmentContext ctx);
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
	 * Enter a parse tree produced by {@link MLLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MLLParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MLLParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SummExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSummExpression(MLLParser.SummExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SummExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSummExpression(MLLParser.SummExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallMethodeExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallMethodeExpression(MLLParser.CallMethodeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallMethodeExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallMethodeExpression(MLLParser.CallMethodeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarNameExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarNameExpression(MLLParser.VarNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarNameExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarNameExpression(MLLParser.VarNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(MLLParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(MLLParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(MLLParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(MLLParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipliesExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultipliesExpression(MLLParser.MultipliesExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipliesExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultipliesExpression(MLLParser.MultipliesExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssigmentExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssigmentExpression(MLLParser.AssigmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssigmentExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssigmentExpression(MLLParser.AssigmentExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link MLLParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(MLLParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(MLLParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(MLLParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(MLLParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MLLParser#charLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(MLLParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MLLParser#charLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(MLLParser.CharLiteralContext ctx);
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