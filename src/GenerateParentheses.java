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
        solveStates(solvedStates, state, new char[] {'('}, 0, 0);

        return solvedStates;
    }

    private static void solveStates (List<String> solvedStates, char[] state, char[] candidates, int start, int balance) {
        //early exit opportunity if too many rights or lefts
        if (balance < 0 || balance > state.length/2) return;

        //if we are in a desired state
        if (start == state.length) {
            if (balance == 0) solvedStates.add(new String(state));
            return;
        }
        int weight = 0;
        for (char candidate: candidates) {
            state[start] = candidate;
            if (candidate == '(') weight = 1;
            else weight = -1;
            solveStates(solvedStates, state, new char[] {'(',')'}, start + 1, balance + weight);
        }
    }
}
