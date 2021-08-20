package it.unicam.cs.compilatore_re.semantic_analysis;

import it.unicam.cs.compilatore_re.gen.ReFollowedByListBaseVisitor;
import it.unicam.cs.compilatore_re.gen.ReFollowedByListParser.*;
import it.unicam.cs.compilatore_re.thompsonNFA.ThompsonNFA;

public class ThompsonNFAEvalVisitor extends ReFollowedByListBaseVisitor<ThompsonNFASynthAttr> {

    private ThompsonNFA finalnfa ;

    @Override
    public ThompsonNFASynthAttr visitRegularExprFollowedByStrings(RegularExprFollowedByStringsContext ctx) {
        ThompsonNFASynthAttr t = visit(ctx.regularExpr());
        this.finalnfa = t.getThompsonNFA();
        return visit(ctx.stringsToCheck());
    }

    @Override
    public ThompsonNFASynthAttr visitFromRegularExprToTerm(FromRegularExprToTermContext ctx) {
        return visit(ctx.term());
    }

    @Override
    public ThompsonNFASynthAttr visitRegularExprPlusTerm(RegularExprPlusTermContext ctx) {
        ThompsonNFASynthAttr left = visit (ctx.regularExpr());
        ThompsonNFASynthAttr right = visit(ctx.term());
        ThompsonNFA result =ThompsonNFA.union(left.getThompsonNFA(),right.getThompsonNFA());
        return new ThompsonNFASynthAttr(result);
    }

    @Override
    public ThompsonNFASynthAttr visitTermConcatU(TermConcatUContext ctx) {
        ThompsonNFASynthAttr left = visit (ctx.term());
        ThompsonNFASynthAttr right = visit(ctx.u());
        ThompsonNFA result =ThompsonNFA.concat(left.getThompsonNFA(),right.getThompsonNFA());
        return new ThompsonNFASynthAttr(result);
    }

    @Override
    public ThompsonNFASynthAttr visitFromTermToU(FromTermToUContext ctx) {
        return visit(ctx.u());
    }

    @Override
    public ThompsonNFASynthAttr visitFromUToWKleen(FromUToWKleenContext ctx) {
        ThompsonNFASynthAttr w = visit(ctx.w());
        ThompsonNFA thompsonNFA = ThompsonNFA.kleeneClosure(w.getThompsonNFA());
        return new ThompsonNFASynthAttr(thompsonNFA);
    }

    @Override
    public ThompsonNFASynthAttr visitFromUToW(FromUToWContext ctx) {
        return visit(ctx.w()); }

    @Override
    public ThompsonNFASynthAttr visitFromWToAlphDigit(FromWToAlphDigitContext ctx) {
        ThompsonNFA thompsonNFA = ThompsonNFA.buildAlphaDigitPart(ctx.ALPHDIGIT().getText());
        return new ThompsonNFASynthAttr(thompsonNFA);
    }

    @Override
    public ThompsonNFASynthAttr visitFromWToEpsilon(FromWToEpsilonContext ctx) {
        ThompsonNFA thompsonNFA = ThompsonNFA.buildEpsilonPart();
        return new ThompsonNFASynthAttr(thompsonNFA);
    }

    @Override
    public ThompsonNFASynthAttr visitFromWToRegularExpr(FromWToRegularExprContext ctx) {
        return visit(ctx.regularExpr()); }

    @Override
    public ThompsonNFASynthAttr visitSequenceFollowedByList(SequenceFollowedByListContext ctx) {
        String s  = ctx.SEQUENCE().getText();
        ThompsonNFASynthAttr t = visit(ctx.stringsToCheck());
        String result = "";
        if(this.finalnfa.accept(s))
            result = "OK , ";
        else
            result = "KO , ";
        String toReturn = result.concat(t.getResult());
        return new ThompsonNFASynthAttr(toReturn);
    }

    @Override
    public ThompsonNFASynthAttr visitFromListToSequence(FromListToSequenceContext ctx) {
        String s  = ctx.SEQUENCE().getText();
        String result = "";
        if(this.finalnfa.accept(s))
            result = "OK";
        else
            result = "KO";
        return new ThompsonNFASynthAttr(result);
    }


}
