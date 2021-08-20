package it.unicam.cs.compilatore_re.thompsonNFA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

}
