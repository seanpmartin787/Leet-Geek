import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        //This feels like a DFS solution / backtracking solution
        //Maybe brute force it and verify test if each of the end results are valid?
        char[] state = new char[n*2]; //x2 because each n is 2 chars
        List<String> solvedStates = new ArrayList<>();
        solveStates(solvedStates, state, new char[] {'('}, 0);

        return solvedStates;
    }

    private static void solveStates (List<String> solvedStates, char[] state, char[] candidates, int start) {
        if (start == state.length) {
            if (isValidState(state)) solvedStates.add(new String(state));
            return;
        }

        for (char candidate: candidates) {
            state[start] = candidate;
            solveStates(solvedStates, state, new char[] {'(',')'}, start + 1);
        }
    }

    private static boolean isValidState (char[] state) {
        int balance = 0;
        for (int i = 0; i < state.length; i++) {
            balance += (state[i] == '(') ? 1 : -1 ;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
