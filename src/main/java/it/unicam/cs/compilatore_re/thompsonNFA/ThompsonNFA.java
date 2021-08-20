package it.unicam.cs.compilatore_re.thompsonNFA;

import java.util.*;
import java.util.stream.Collectors;

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

    public boolean accept(String s){
        Set<NFAState> currentStates = this.calculateEpsilonClosure(this.nfaStart);
        for(char character : s.toCharArray()) {
            Set<NFAState> intermediateStates = new HashSet<>();
            intermediateStates = currentStates
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
            intermediateStates.remove(null);
            if(intermediateStates.isEmpty())
                return false;
            Set<NFAState> statesToReturn = new HashSet<>();
            intermediateStates.forEach(intermediateState ->
                    statesToReturn.addAll(this.calculateEpsilonClosure(intermediateState)));
            currentStates = statesToReturn;
        }
        Optional<NFAState> opt = currentStates.stream().filter(state -> state.getState().equals(StateEnum.FINAL)).findAny();
        return opt.isPresent();
    }

    //potrebbero esserci delle dipendenze circolari con il fatto che aggiungo elementi già visti, anche
    //non vengono aggiunti grazie al set. Quindi c'è da fare un controllo sul fatto che gli elementi del
    //set sono cambiati o meno
    private Set<NFAState> calculateEpsilonClosure(NFAState state){
        Set<NFAState> states = new HashSet<>();
        states.add(state);
        Set<NFATransition> epsilonTransitions = new HashSet<>();
        epsilonTransitions = state.getTransitions()
                .stream()
                .filter(NFATransition::isValueEpsilon)
                .collect(Collectors.toSet());

        // sulla guardia ci andrebbe il metodo che controlla se il set di adesso è uguale a quello di prima
        while(!epsilonTransitions.isEmpty()) {
            Set<NFAState> endingStates = epsilonTransitions
                    .stream()
                    .map(NFATransition::getEndingState)
                    .collect(Collectors.toSet());
            states.addAll(endingStates);

            calculateEpsilonTransitions(endingStates, epsilonTransitions);
        }
        return states;

    }

    private void calculateEpsilonTransitions(Set<NFAState> states, Set<NFATransition> epsilonTransitions) {
        epsilonTransitions.clear();
        states.forEach(state -> {
            Set<NFATransition> transitions = state.getTransitions()
                    .stream()
                    .filter(NFATransition::isValueEpsilon)
                    .collect(Collectors.toSet());
            epsilonTransitions.addAll(transitions);
        });
    }

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
    private static void buildEpsilonConnection(NFAState starting, NFAState ending){
        NFATransition transition = NFATransition.buildEpsilonProduction(starting,  ending);
        starting.addTransition(transition);
    }
    public static ThompsonNFA concat(ThompsonNFA s1, ThompsonNFA s2){
        s1.getNfaEnd().setState(StateEnum.MIDDLE);

        List<NFATransition> transposedTransitions = new ArrayList<>();
        s2.getNfaStart().getTransitions().forEach(transition -> {
            NFATransition tran =
                    new NFATransition(s1.getNfaEnd(),transition.getEndingState(),transition.getValue());
            transposedTransitions.add(tran);
        });
        s1.getNfaEnd().setTransitions(transposedTransitions);
        //non so se serve
        s2.setNfaStart(s1.getNfaEnd());
        return new ThompsonNFA(s1.getNfaStart(), s2.getNfaEnd());
    }
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
    public static ThompsonNFA buildAlphaDigitPart(String value){
        NFAState start = new NFAState(StateEnum.INITIAL);
        NFAState end = new NFAState(StateEnum.FINAL);
        NFATransition transition = new NFATransition(start, end, value);
        start.addTransition(transition);
        return new ThompsonNFA(start,end);
    }
    public static ThompsonNFA buildEpsilonPart(){
        NFAState start = new NFAState(StateEnum.INITIAL);
        NFAState end = new NFAState(StateEnum.FINAL);
        buildEpsilonConnection(start,end);
        return new ThompsonNFA(start,end);
    }
}
