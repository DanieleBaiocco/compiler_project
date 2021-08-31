package it.unicam.cs.compilatore_re.thompsonNFA;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta un automa a stati finiti non deterministico Thomspon, che ha uno stato iniziale
 * di partenza e uno finale. Ha un metodo che, data una stringa, dice se questa è accettata o meno dall'automa
 * e ha dei metodi di utilità per la creazione di un nuovo automa Thompson.
 */
public class ThompsonNFA {
    private NFAState nfaStart;
    private NFAState nfaEnd;

    public ThompsonNFA(NFAState nfaStart, NFAState nfaEnd) {
        this.nfaStart = nfaStart;
        this.nfaEnd = nfaEnd;
    }

    public NFAState getNfaStart() {
        return nfaStart;
    }

    public void setNfaStart(NFAState nfaStart) {
        this.nfaStart = nfaStart;
    }

    public NFAState getNfaEnd() {
        return nfaEnd;
    }

    public void setNfaEnd(NFAState nfaEnd) {
        this.nfaEnd = nfaEnd;
    }

    /**
     * Permette di dire se una stringa è o meno accettata dall'automa Thompson su cui questo metodo viene chiamato.
     * Si fa un'epsilon-closure iniziale e si inizializza un insieme degli stati correnti. Poi si itera per tutti i
     * caratteri della stringa; per ogni carattere, si vede se esistono nell'insieme degli stati correnti
     * delle transizioni possibili con quello specifico carattere. Si fa quindi la epsilon-closure dei nuovi stati correnti
     * generati. Quando la stringa termina, si controlla se nell'insieme degli stati correnti c'è uno stato finale, in caso
     * affermativo la stringa è accettata dall'automa e si ritorna true, altrimenti false.
     * l'insieme degli stati
     * @param s la stringa su cui opera l'algoritmo di accettazione.
     * @return true nel caso in cui la stringa in input sia accettata, ovvero quando al termine dello scorrimento dei caratteri
     * è presente almeno uno stato finale nell'insieme degli stati correnti, false altrimenti.
     */
    public boolean accept(String s){
        Set<NFAState> currentStates = this.calculateEpsilonClosure(this.nfaStart);
        for(char character : s.toCharArray()) {
            Set<NFAState> intermediateStates = buildIntermediateStates(currentStates, character);
            if(intermediateStates.isEmpty())
                return false;
            currentStates.clear();
            intermediateStates.forEach(intermediateState ->
                    currentStates.addAll(this.calculateEpsilonClosure(intermediateState)));
        }
        Optional<NFAState> opt = currentStates.stream()
                .filter(state -> state.getState().equals(StateEnum.FINAL)).findAny();
        return opt.isPresent();
    }

    /**
     * Costruisce un nuovo set di stati, dal set di stati precedenti, utilizzando il carattere passato. Nella pratica,
     * prende, dal vecchio set di stati, tutte e sole le transizioni che hanno come valore il carattere in input. Da queste
     * prende tutti gli stati di arrivo e li ritorna.
     * @param currentStates il set di stati da cui parto
     * @param character il carattere della stringa che sto scorrendo che porta al nuovo set di stati
     * @return il nuovo set di stati a cui arrivo dopo aver letto il carattere in input
     */
    private Set<NFAState> buildIntermediateStates(Set<NFAState> currentStates, char character) {
        Set<NFAState> intermediateStatesToReturn = currentStates
                .stream()
                .map(currentState -> {
                    NFATransition nfaTransition = currentState
                            .getTransitions()
                            .stream()
                            .filter(transition -> transition.getValue().equals(String.valueOf(character)))
                            .findFirst()
                            .orElse(null);
                    if (nfaTransition == null)
                        return null;
                    else return nfaTransition.getEndingState();
                }).collect(Collectors.toSet());
        intermediateStatesToReturn.remove(null);
        return intermediateStatesToReturn;
    }


    /**
     * Calcola la epsilon-closure dello stato in input. Nel caso in cui non ci siano delle transizioni con epsilon,
     * ritorna un Set con solo un elemento, che altro non è che lo stato in input. Nel caso in cui ci sono, si aggiungono
     * alla collezione da ritornare gli stati di arrivo di queste transizioni con epsilon. Si continua a aggiungere stati finchè
     * l'insieme di stati analizzato non ha più transizioni con epsilon.
     * @param state lo stato su cui viene fatta l'epsilon-closure
     * @return gli stati risultato dell'epsilon-closure
     */
    private Set<NFAState> calculateEpsilonClosure(NFAState state){
        Set<NFAState> states = new HashSet<>();
        Set<NFATransition> epsilonTransitions = new HashSet<>();
        states.add(state);
        calculateEpsilonTransitions(states,epsilonTransitions);

        while(!epsilonTransitions.isEmpty()) {
            Set<NFAState> endingStates = epsilonTransitions
                    .stream()
                    .map(NFATransition::getEndingState)
                    .collect(Collectors.toSet());
            states.addAll(endingStates);
            epsilonTransitions.clear();
            calculateEpsilonTransitions(endingStates, epsilonTransitions);
        }
        return states;

    }


    /**
     * Per ogni stato, controlla se ha delle transizioni con epsilon e, in caso affermativo,
     * le aggiunge alla collezione di transizioni in input
     * @param states gli stati su cui vedere se ci sono transizioni con epsilon
     * @param epsilonTransitions la collezione su cui vengono aggiunte eventuali transizioni con epsilon scoperte
     */
    private void calculateEpsilonTransitions(Set<NFAState> states, Set<NFATransition> epsilonTransitions) {
        states.forEach(state -> {
            Set<NFATransition> transitions = state.getTransitions()
                    .stream()
                    .filter(NFATransition::isValueEpsilon)
                    .collect(Collectors.toSet());
            epsilonTransitions.addAll(transitions);
        });
    }

    /**
     * Permette di realizzare l'unione tra due automi Thompson
     * @param s1 il primo automa Thompson
     * @param s2 il secondo automa Thompson
     * @return l'automa Thompson risultante dall'unione
     */
    public static ThompsonNFA union(ThompsonNFA s1, ThompsonNFA s2){
        s1.getNfaStart().setState(StateEnum.MIDDLE);
        s1.getNfaEnd().setState(StateEnum.MIDDLE);
        s2.getNfaStart().setState(StateEnum.MIDDLE);
        s2.getNfaEnd().setState(StateEnum.MIDDLE);
        NFAState newStart= new NFAState(StateEnum.INITIAL);
        NFAState newEnd = new NFAState(StateEnum.FINAL);

        buildEpsilonConnection(newStart, s1.getNfaStart());
        buildEpsilonConnection(newStart, s2.getNfaStart());
        buildEpsilonConnection(s1.getNfaEnd(), newEnd);
        buildEpsilonConnection(s2.getNfaEnd(), newEnd);

        return new ThompsonNFA(newStart, newEnd);


    }

    /**
     * Permette di realizzare la concatenazione tra due automi Thompson
     * @param s1 il primo automa Thompson
     * @param s2 il secondo automa Thompson
     * @return l'automa Thompson risultante dalla concatenazione
     */
    public static ThompsonNFA concat(ThompsonNFA s1, ThompsonNFA s2){
        s1.getNfaEnd().setState(StateEnum.MIDDLE);

        List<NFATransition> transposedTransitions = new ArrayList<>();
        s2.getNfaStart().getTransitions().forEach(transition -> {
            NFATransition tran =
                    new NFATransition(s1.getNfaEnd(),transition.getEndingState(),transition.getValue());
            transposedTransitions.add(tran);
        });
        s1.getNfaEnd().setTransitions(transposedTransitions);
        s2.setNfaStart(s1.getNfaEnd());
        return new ThompsonNFA(s1.getNfaStart(), s2.getNfaEnd());
    }

    /**
     * Permette di realizzare la chiusura di Kleene su di un automa Thompson
     * @param s l'automa Thompson su cui fare la chiusura di kleene
     * @return l'automa Thompson risultante dalla chiusura di Kleene
     */
    public static ThompsonNFA kleeneClosure(ThompsonNFA s){
        s.getNfaStart().setState(StateEnum.MIDDLE);
        s.getNfaEnd().setState(StateEnum.MIDDLE);

        NFAState newStart= new NFAState(StateEnum.INITIAL);
        NFAState newEnd = new NFAState(StateEnum.FINAL);
        buildEpsilonConnection(newStart, s.getNfaStart());
        buildEpsilonConnection(s.getNfaEnd(), newEnd);
        buildEpsilonConnection(s.getNfaEnd(),s.getNfaStart());
        buildEpsilonConnection(newStart, newEnd);
        return new ThompsonNFA(newStart, newEnd);
    }

    /**
     * Costruisce un automa Thompson formato da uno stato iniziale, uno finale e una transizione
     * che ha come valore la stringa passata.
     * @param value la stringa da utilizzare come valore della transizione dell'automa formato
     * @return un automa Thompson con due stati, uno iniziale e uno finale, e una transizione
     */
    public static ThompsonNFA buildAlphaDigitPart(String value){
        NFAState start = new NFAState(StateEnum.INITIAL);
        NFAState end = new NFAState(StateEnum.FINAL);
        NFATransition transition = new NFATransition(start, end, value);
        start.addTransition(transition);
        return new ThompsonNFA(start,end);
    }

    /**
     * Costruisce un automa Thompson formato da uno stato iniziale, uno finale e una transizione con epsilon.
     * @return un automa Thompson con due stati, uno iniziale e uno finale, e una transizione con epsilon
     */
    public static ThompsonNFA buildEpsilonPart(){
        NFAState start = new NFAState(StateEnum.INITIAL);
        NFAState end = new NFAState(StateEnum.FINAL);
        buildEpsilonConnection(start,end);
        return new ThompsonNFA(start,end);
    }

    /**
     * Metodo di utilità per la creazione di un collegamento tra due stati tramite una transizione epsilon
     * @param starting lo stato di partenza
     * @param ending lo stato di arrivo
     */
    private static void buildEpsilonConnection(NFAState starting, NFAState ending){
        NFATransition transition = NFATransition.buildEpsilonProduction(starting,  ending);
        starting.addTransition(transition);
    }
}
