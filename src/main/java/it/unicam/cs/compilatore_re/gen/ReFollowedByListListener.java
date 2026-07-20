// Generated from C:/Users/Daniele/Desktop/compilatore_re/src/main/java/it/unicam/cs/compilatore_re\ReFollowedByList.g4 by ANTLR 4.9.1

   package it.unicam.cs.compilatore_re.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReFollowedByListParser}.
 */
public interface ReFollowedByListListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code regularExprFollowedByStrings}
	 * labeled alternative in {@link ReFollowedByListParser#s}.
	 * @param ctx the parse tree
	 */
	void enterRegularExprFollowedByStrings(ReFollowedByListParser.RegularExprFollowedByStringsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regularExprFollowedByStrings}
	 * labeled alternative in {@link ReFollowedByListParser#s}.
	 * @param ctx the parse tree
	 */
	void exitRegularExprFollowedByStrings(ReFollowedByListParser.RegularExprFollowedByStringsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromRegularExprToTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 */
	void enterFromRegularExprToTerm(ReFollowedByListParser.FromRegularExprToTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromRegularExprToTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 */
	void exitFromRegularExprToTerm(ReFollowedByListParser.FromRegularExprToTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regularExprPlusTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 */
	void enterRegularExprPlusTerm(ReFollowedByListParser.RegularExprPlusTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regularExprPlusTerm}
	 * labeled alternative in {@link ReFollowedByListParser#regularExpr}.
	 * @param ctx the parse tree
	 */
	void exitRegularExprPlusTerm(ReFollowedByListParser.RegularExprPlusTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termConcatU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermConcatU(ReFollowedByListParser.TermConcatUContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termConcatU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermConcatU(ReFollowedByListParser.TermConcatUContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromTermToU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 */
	void enterFromTermToU(ReFollowedByListParser.FromTermToUContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromTermToU}
	 * labeled alternative in {@link ReFollowedByListParser#term}.
	 * @param ctx the parse tree
	 */
	void exitFromTermToU(ReFollowedByListParser.FromTermToUContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromUToWKleen}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 */
	void enterFromUToWKleen(ReFollowedByListParser.FromUToWKleenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromUToWKleen}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 */
	void exitFromUToWKleen(ReFollowedByListParser.FromUToWKleenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromUToW}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 */
	void enterFromUToW(ReFollowedByListParser.FromUToWContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromUToW}
	 * labeled alternative in {@link ReFollowedByListParser#u}.
	 * @param ctx the parse tree
	 */
	void exitFromUToW(ReFollowedByListParser.FromUToWContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromWToAlphDigit}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void enterFromWToAlphDigit(ReFollowedByListParser.FromWToAlphDigitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromWToAlphDigit}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void exitFromWToAlphDigit(ReFollowedByListParser.FromWToAlphDigitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromWToEpsilon}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void enterFromWToEpsilon(ReFollowedByListParser.FromWToEpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromWToEpsilon}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void exitFromWToEpsilon(ReFollowedByListParser.FromWToEpsilonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromWToRegularExpr}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void enterFromWToRegularExpr(ReFollowedByListParser.FromWToRegularExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromWToRegularExpr}
	 * labeled alternative in {@link ReFollowedByListParser#w}.
	 * @param ctx the parse tree
	 */
	void exitFromWToRegularExpr(ReFollowedByListParser.FromWToRegularExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceFollowedByList}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 */
	void enterSequenceFollowedByList(ReFollowedByListParser.SequenceFollowedByListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceFollowedByList}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 */
	void exitSequenceFollowedByList(ReFollowedByListParser.SequenceFollowedByListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromListToSequence}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 */
	void enterFromListToSequence(ReFollowedByListParser.FromListToSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromListToSequence}
	 * labeled alternative in {@link ReFollowedByListParser#stringsToCheck}.
	 * @param ctx the parse tree
	 */
	void exitFromListToSequence(ReFollowedByListParser.FromListToSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code digitFollowedByString}
	 * labeled alternative in {@link ReFollowedByListParser#string}.
	 * @param ctx the parse tree
	 */
	void enterDigitFollowedByString(ReFollowedByListParser.DigitFollowedByStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code digitFollowedByString}
	 * labeled alternative in {@link ReFollowedByListParser#string}.
	 * @param ctx the parse tree
	 */
	void exitDigitFollowedByString(ReFollowedByListParser.DigitFollowedByStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleDigit}
	 * labeled alternative in {@link ReFollowedByListParser#string}.
	 * @param ctx the parse tree
	 */
	void enterSingleDigit(ReFollowedByListParser.SingleDigitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleDigit}
	 * labeled alternative in {@link ReFollowedByListParser#string}.
	 * @param ctx the parse tree
	 */
	void exitSingleDigit(ReFollowedByListParser.SingleDigitContext ctx);
}