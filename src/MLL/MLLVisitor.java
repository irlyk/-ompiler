// Generated from C:/Users/irlyk/Desktop/Compile 1.1/src/MLL\MLL.g4 by ANTLR 4.8
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
	 * Visit a parse tree produced by {@link MLLParser#ifStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatment(MLLParser.IfStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#conclusionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConclusionList(MLLParser.ConclusionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#forStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatment(MLLParser.ForStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#forInside}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInside(MLLParser.ForInsideContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MLLParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#whileStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatment(MLLParser.WhileStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpConclusin}
	 * labeled alternative in {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpConclusin(MLLParser.ExpConclusinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallMethodeConlusin}
	 * labeled alternative in {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethodeConlusin(MLLParser.CallMethodeConlusinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualsConclusion}
	 * labeled alternative in {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsConclusion(MLLParser.EqualsConclusionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreThenConclusion}
	 * labeled alternative in {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreThenConclusion(MLLParser.MoreThenConclusionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThenConclusion}
	 * labeled alternative in {@link MLLParser#conclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThenConclusion(MLLParser.LessThenConclusionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MLLParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#assigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigment(MLLParser.AssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MLLParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MLLParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SummExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummExpression(MLLParser.SummExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallMethodeExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethodeExpression(MLLParser.CallMethodeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarNameExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarNameExpression(MLLParser.VarNameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(MLLParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(MLLParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultipliesExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipliesExpression(MLLParser.MultipliesExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssigmentExpression}
	 * labeled alternative in {@link MLLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigmentExpression(MLLParser.AssigmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MLLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(MLLParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(MLLParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MLLParser#charLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(MLLParser.CharLiteralContext ctx);
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