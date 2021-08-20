package it.unicam.cs.compilatore_re.thompsonNFA;

public class NFATransition  {
  private NFAState startingState;
  private NFAState endingState;
  private String value;

  public NFATransition(NFAState startingState, NFAState endingState, String value){
      this.startingState = startingState;
      this.endingState = endingState;
      this.value = value;
  }

  public static NFATransition buildEpsilonProduction(NFAState startingState, NFAState endingState){
      return new NFATransition(startingState, endingState, "epsilon");
  }

  public boolean isValueEpsilon(){
      return value.equals("epsilon");
  }

    public NFAState getStartingState() {
        return startingState;
    }

    public void setStartingState(NFAState startingState) {
        this.startingState = startingState;
    }

    public NFAState getEndingState() {
        return endingState;
    }

    public void setEndingState(NFAState endingState) {
        this.endingState = endingState;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
