// Generated from C:/Users/Daniele/Desktop/compilatore_re/src/main/java/it/unicam/cs/compilatore_re\ReFollowedByList.g4 by ANTLR 4.9.1

   package it.unicam.cs.compilatore_re.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReFollowedByListParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ALPHDIGIT=7, SEQUENCE=8, 
		WS=9;
	public static final int
		RULE_s = 0, RULE_regularExpr = 1, RULE_term = 2, RULE_u = 3, RULE_w = 4, 
		RULE_stringsToCheck = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "regularExpr", "term", "u", "w", "stringsToCheck"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'+'", "'*'", "'epsilon'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "ALPHDIGIT", "SEQUENCE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ReFollowedByList.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ReFollowedByListParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SContext extends ParserRuleContext {
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
	 
		public SContext() { }
		public void copyFrom(SContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RegularExprFollowedByStringsContext extends SContext {
		public RegularExprContext regularExpr() {
			return getRuleContext(RegularExprContext.class,0);
		}
		public StringsToCheckContext stringsToCheck() {
			return getRuleContext(StringsToCheckContext.class,0);
		}
		public RegularExprFollowedByStringsContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterRegularExprFollowedByStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitRegularExprFollowedByStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitRegularExprFollowedByStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			_localctx = new RegularExprFollowedByStringsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			regularExpr(0);
			setState(13);
			match(T__0);
			setState(14);
			stringsToCheck();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegularExprContext extends ParserRuleContext {
		public RegularExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularExpr; }
	 
		public RegularExprContext() { }
		public void copyFrom(RegularExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FromRegularExprToTermContext extends RegularExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FromRegularExprToTermContext(RegularExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromRegularExprToTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromRegularExprToTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromRegularExprToTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegularExprPlusTermContext extends RegularExprContext {
		public RegularExprContext regularExpr() {
			return getRuleContext(RegularExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RegularExprPlusTermContext(RegularExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterRegularExprPlusTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitRegularExprPlusTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitRegularExprPlusTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularExprContext regularExpr() throws RecognitionException {
		return regularExpr(0);
	}

	private RegularExprContext regularExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RegularExprContext _localctx = new RegularExprContext(_ctx, _parentState);
		RegularExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_regularExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FromRegularExprToTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(17);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(24);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RegularExprPlusTermContext(new RegularExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_regularExpr);
					setState(19);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(20);
					match(T__1);
					setState(21);
					term(0);
					}
					} 
				}
				setState(26);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermConcatUContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public UContext u() {
			return getRuleContext(UContext.class,0);
		}
		public TermConcatUContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterTermConcatU(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitTermConcatU(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitTermConcatU(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FromTermToUContext extends TermContext {
		public UContext u() {
			return getRuleContext(UContext.class,0);
		}
		public FromTermToUContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromTermToU(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromTermToU(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromTermToU(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FromTermToUContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(28);
			u();
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermConcatUContext(new TermContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(30);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(31);
					u();
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UContext extends ParserRuleContext {
		public UContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_u; }
	 
		public UContext() { }
		public void copyFrom(UContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FromUToWContext extends UContext {
		public WContext w() {
			return getRuleContext(WContext.class,0);
		}
		public FromUToWContext(UContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromUToW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromUToW(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromUToW(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FromUToWKleenContext extends UContext {
		public WContext w() {
			return getRuleContext(WContext.class,0);
		}
		public FromUToWKleenContext(UContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromUToWKleen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromUToWKleen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromUToWKleen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UContext u() throws RecognitionException {
		UContext _localctx = new UContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_u);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FromUToWKleenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				w();
				setState(38);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new FromUToWContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				w();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WContext extends ParserRuleContext {
		public WContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_w; }
	 
		public WContext() { }
		public void copyFrom(WContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FromWToAlphDigitContext extends WContext {
		public TerminalNode ALPHDIGIT() { return getToken(ReFollowedByListParser.ALPHDIGIT, 0); }
		public FromWToAlphDigitContext(WContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromWToAlphDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromWToAlphDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromWToAlphDigit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FromWToRegularExprContext extends WContext {
		public RegularExprContext regularExpr() {
			return getRuleContext(RegularExprContext.class,0);
		}
		public FromWToRegularExprContext(WContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromWToRegularExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromWToRegularExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromWToRegularExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FromWToEpsilonContext extends WContext {
		public FromWToEpsilonContext(WContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromWToEpsilon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromWToEpsilon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromWToEpsilon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WContext w() throws RecognitionException {
		WContext _localctx = new WContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_w);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALPHDIGIT:
				_localctx = new FromWToAlphDigitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(ALPHDIGIT);
				}
				break;
			case T__3:
				_localctx = new FromWToEpsilonContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new FromWToRegularExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(T__4);
				setState(46);
				regularExpr(0);
				setState(47);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringsToCheckContext extends ParserRuleContext {
		public StringsToCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringsToCheck; }
	 
		public StringsToCheckContext() { }
		public void copyFrom(StringsToCheckContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FromListToSequenceContext extends StringsToCheckContext {
		public TerminalNode SEQUENCE() { return getToken(ReFollowedByListParser.SEQUENCE, 0); }
		public FromListToSequenceContext(StringsToCheckContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterFromListToSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitFromListToSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitFromListToSequence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequenceFollowedByListContext extends StringsToCheckContext {
		public TerminalNode SEQUENCE() { return getToken(ReFollowedByListParser.SEQUENCE, 0); }
		public StringsToCheckContext stringsToCheck() {
			return getRuleContext(StringsToCheckContext.class,0);
		}
		public SequenceFollowedByListContext(StringsToCheckContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).enterSequenceFollowedByList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReFollowedByListListener ) ((ReFollowedByListListener)listener).exitSequenceFollowedByList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ReFollowedByListVisitor ) return ((ReFollowedByListVisitor<? extends T>)visitor).visitSequenceFollowedByList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringsToCheckContext stringsToCheck() throws RecognitionException {
		StringsToCheckContext _localctx = new StringsToCheckContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stringsToCheck);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SequenceFollowedByListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(SEQUENCE);
				setState(52);
				match(T__0);
				setState(53);
				stringsToCheck();
				}
				break;
			case 2:
				_localctx = new FromListToSequenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(SEQUENCE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return regularExpr_sempred((RegularExprContext)_localctx, predIndex);
		case 2:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean regularExpr_sempred(RegularExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13<\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\3\4\7\4#\n\4\f\4\16\4"+
		"&\13\4\3\5\3\5\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\64\n\6\3\7"+
		"\3\7\3\7\3\7\5\7:\n\7\3\7\2\4\4\6\b\2\4\6\b\n\f\2\2\2;\2\16\3\2\2\2\4"+
		"\22\3\2\2\2\6\35\3\2\2\2\b+\3\2\2\2\n\63\3\2\2\2\f9\3\2\2\2\16\17\5\4"+
		"\3\2\17\20\7\3\2\2\20\21\5\f\7\2\21\3\3\2\2\2\22\23\b\3\1\2\23\24\5\6"+
		"\4\2\24\32\3\2\2\2\25\26\f\4\2\2\26\27\7\4\2\2\27\31\5\6\4\2\30\25\3\2"+
		"\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2"+
		"\2\2\35\36\b\4\1\2\36\37\5\b\5\2\37$\3\2\2\2 !\f\4\2\2!#\5\b\5\2\" \3"+
		"\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\7\3\2\2\2&$\3\2\2\2\'(\5\n\6\2"+
		"()\7\5\2\2),\3\2\2\2*,\5\n\6\2+\'\3\2\2\2+*\3\2\2\2,\t\3\2\2\2-\64\7\t"+
		"\2\2.\64\7\6\2\2/\60\7\7\2\2\60\61\5\4\3\2\61\62\7\b\2\2\62\64\3\2\2\2"+
		"\63-\3\2\2\2\63.\3\2\2\2\63/\3\2\2\2\64\13\3\2\2\2\65\66\7\n\2\2\66\67"+
		"\7\3\2\2\67:\5\f\7\28:\7\n\2\29\65\3\2\2\298\3\2\2\2:\r\3\2\2\2\7\32$"+
		"+\639";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}