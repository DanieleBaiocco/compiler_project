// Generated from C:/Users/Daniele/Desktop/compilatore_re/src/main/java/it/unicam/cs/compilatore_re\ReFollowedByList.g4 by ANTLR 4.9.1

   package it.unicam.cs.compilatore_re.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ReFollowedByListParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ReFollowedByListVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code regularExprFollowedByStrings}
	 * labeled alternative in {@link ReFollowedByListParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExprFollowedByStrings(ReFollowedByListParser.RegularExprFollowedByStringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromRegularExprToTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromRegularExprToTerm(ReFollowedByListParser.FromRegularExprToTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regularExprPlusTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExprPlusTerm(ReFollowedByListParser.RegularExprPlusTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termConcatU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermConcatU(ReFollowedByListParser.TermConcatUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromTermToU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromTermToU(ReFollowedByListParser.FromTermToUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromUToWKleen}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromUToWKleen(ReFollowedByListParser.FromUToWKleenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromUToW}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromUToW(ReFollowedByListParser.FromUToWContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromWToAlphDigit}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromWToAlphDigit(ReFollowedByListParser.FromWToAlphDigitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromWToEpsilon}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromWToEpsilon(ReFollowedByListParser.FromWToEpsilonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromWToRegularExpr}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromWToRegularExpr(ReFollowedByListParser.FromWToRegularExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceFollowedByList}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceFollowedByList(ReFollowedByListParser.SequenceFollowedByListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromListToSequence}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromListToSequence(ReFollowedByListParser.FromListToSequenceContext ctx);
}