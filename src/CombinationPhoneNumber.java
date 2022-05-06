import java.util.*;

public class CombinationPhoneNumber {
    HashMap<Character, char[]> candidates = new HashMap<>() {{
        put('1',null);
        put('2',new char[] {'a','b','c'});
        put('3',new char[] {'d','e','f'});
        put('4',new char[] {'g','h','i'});
        put('5',new char[] {'j','k','l'});
        put('6',new char[] {'m','n','o'});
        put('7',new char[] {'p','q','r','s'});
        put('8',new char[] {'t','u','v'});
        put('9',new char[] {'w','x','y','z'});

    }};
    public List<String> letterCombinations(String digits) {
        //classic backtracking problem
        //We want three things, a test for a desired state (digits.length())
        //a way to get our next candidates
        //and recursive backtrack function to build our states
        //To build our states we want an object to store solved states and a temp object to store temp states
        List<String> solvedStates = new ArrayList<>();
        char[] state = new char[digits.length()];
        CombinationPhoneNumber letterCombos = new CombinationPhoneNumber();
        letterCombos.solveNumbers(digits, solvedStates, state, 0);
        return solvedStates;

    }
    private void solveNumbers (String digits, List<String> solvedStates, char[] state, int start) {
        if (state.length == digits.length()) {
            solvedStates.add(state.toString());
        }

        for (char candidate : candidates.get(digits.charAt(start))) {
            state[start] = candidate;
            solveNumbers(digits,solvedStates,state,start + 1);
        }
    }
}
