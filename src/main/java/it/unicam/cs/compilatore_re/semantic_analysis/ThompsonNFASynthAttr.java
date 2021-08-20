package it.unicam.cs.compilatore_re.semantic_analysis;

import it.unicam.cs.compilatore_re.thompsonNFA.ThompsonNFA;


//Probabilmente il prof vuole la stampa come side effect, quindi forse devi levare la stringa result
public class ThompsonNFASynthAttr {
    private ThompsonNFA thompsonNFA;
    private String result;


    public ThompsonNFASynthAttr(ThompsonNFA thompsonNFA) {
        super();
        this.thompsonNFA = thompsonNFA;
        this.result="";
    }

    public ThompsonNFASynthAttr(String result) {
        this.result = result;
    }


    public ThompsonNFA getThompsonNFA() {
        return thompsonNFA;
    }

    public void setThompsonNFA(ThompsonNFA thompsonNFA) {
        this.thompsonNFA = thompsonNFA;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
