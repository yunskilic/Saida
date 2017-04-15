package Compiler;// Generated from C:/Users/YUNUS/IdeaProjects/Saida/src\Saida.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SaidaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SaidaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SaidaParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(SaidaParser.RContext ctx);
}