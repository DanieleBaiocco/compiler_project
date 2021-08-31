package it.unicam.cs.compilatore_re.thompsonNFA;

/**
 * Classe di utilità che genera dei nomi di stati, per quando si costruisce l'automa Thompson
 */
public class StateNameGenerator {

    private static Integer count = 0;

    /**
     * Metodo generatore di nomi di stati
     * @return la stringa col nome 
     */
    public static String generateStateName(){
        count++;
        return "S"+ count;
    }
}
