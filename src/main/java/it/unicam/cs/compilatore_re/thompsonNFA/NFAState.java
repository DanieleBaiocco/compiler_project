package it.unicam.cs.compilatore_re.thompsonNFA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta uno stato in un automa a stati finiti non deterministico Thompson.
 * Questo può essere iniziale, finale o intermedio e ha una lista di transizioni e un nome a esso associati.
 */
public class NFAState {

    private StateEnum state;
    private List<NFATransition> transitions;
    private String name;

    public NFAState(StateEnum state){
        this.state = state;
        this.transitions = new ArrayList<>();
        this.name = StateNameGenerator.generateStateName();
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public List<NFATransition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<NFATransition> transitions) {
        this.transitions = transitions;
    }

    public void addTransition(NFATransition transition){
        this.transitions.add(transition);
    }

    /**
     * Override del metodo equals; due NFAState sono uguali secondo equals se hanno lo stesso nome.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final NFAState other = (NFAState) obj;
        return Objects.equals(this.name, other.name);
    }

    /**
     * Override dell'hashCode che genera l'hash utilizzando il nome dell'NFAState.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

}
