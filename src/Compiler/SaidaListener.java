package Compiler;// Generated from C:/Users/YUNUS/IdeaProjects/Saida/src\Saida.g4 by ANTLR 4.6

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SaidaParser}.
 */
public interface SaidaListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link SaidaParser#r}.
     *
     * @param ctx the parse tree
     */
    void enterR(SaidaParser.RContext ctx);

    /**
     * Exit a parse tree produced by {@link SaidaParser#r}.
     *
     * @param ctx the parse tree
     */
    void exitR(SaidaParser.RContext ctx);
}