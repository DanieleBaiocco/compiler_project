package it.unicam.cs.compilatore_re.thompsonNFA;

public class StateNameGenerator {

    private static Integer count = 0;

    public static String generateStateName(){
        count++;
        return "S"+ count;
    }
}
