import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        //classic backtracking problem
        //We want three things, a test for a desired state (digits.length())
        //a function to give us our next candidates
        //a recursive backtrack function
        //We also want an object to store solved states and a temp object to store temp states
        List<String> solvedStates = new ArrayList<>();
        char[] state = new char[digits.length()];

    }

    private static void solveNumbers (String digits, List<String> solvedStates, char[] state, int start) {
        if (state.length == digits.length()) {
            solvedStates.add(state.toString());
        }

        for (char candidate : )
    }

    private static List<Character> getCandidates (int number) {

    }
}
