import java.util.HashMap;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        //I am thinking DFS backtracking solution with an adjacency matrix to keep track of visited
        //current state will be board + m + x
        //validate state is if index == length.word  char[word.length()]
        //next candidates are all adjacent squares matching current index plus 1
        if (board == null) return false; //if invalid object (null)
        int m = board.length, n = board[0].length;
        if (m * n < word.length()) return false; //If not enough letters
        //Otherwise, we can backtrack
        char[] state = new char[word.length()];
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; i < n; j ++) {
                //if we have the first letter, lets start a dfs backtrack
                if (board[i][j] == word.charAt(0)) {
                    //if we have a winner return true
                    if (solveWord(board, word, state, visited, i, j, 0)) return true;
                }
            }
        }
        //if we looped through and didn't find a solution
        return false;
    }
    private boolean solveWord(char[][] board, String word, char [] state, int[][] visited, int m, int n, int index) {
        if (index == word.length()) return true;

        HashMap<Character, int[]> candidates = getCandidates(m, n, word.charAt(index), visited);
        for (char candidate: candidates.keySet()) {
            state[index] = word.charAt(index);
            visited[m][n] = 1;
            int newM = candidates.get(candidate)[0];
            int newN = candidates.get(candidate)[1];
            solveWord(board, word, state, visited, newM, newN, index + 1);
        }

        return false;
    }

    private HashMap<Character, int[]> getCandidates (int m, int n, char next, int[][] visited) {

    }
}
