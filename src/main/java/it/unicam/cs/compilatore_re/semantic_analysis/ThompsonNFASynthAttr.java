package it.unicam.cs.compilatore_re.semantic_analysis;

import it.unicam.cs.compilatore_re.thompsonNFA.ThompsonNFA;


/**
 * Contiene al suo interno due attributi sintetizzati: un'istanza dell'NFA Thompson e una stringa che, nella radice dell'albero,
 * conterrà l'output del programma da stampare a video.
 */
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
