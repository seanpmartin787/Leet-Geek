import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        //I am thinking DFS backtracking solution with an adjacency matrix to keep track of visited
        //current state will be board + m + x
        //validate state is if index == length.word  char[word.length()]
        //next candidates are all adjacent squares matching current index plus 1
        if (board == null) return false; //if invalid object (null)
        int m = board.length, n = board[0].length;
        if (m * n < word.length()) return false; //If not enough letters
        //Otherwise, we can search to start our backtrack
        char[] state = new char[word.length()];
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
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
    private static boolean solveWord(char[][] board, String word, char [] state, int[][] visited, int m, int n, int index) {
        if (index == word.length() - 1) return true;

        //if there isn't a next valid candidate no reason to add the current value
        for (int[] candidate: getCandidates(m, n, word.charAt(index + 1), visited, board)) {
            visited[m][n] = 1;
            int newM = candidate[0];
            int newN = candidate[1];
            if (solveWord(board, word, state, visited, newM, newN, index + 1)) return true;
            visited[m][n] = 0;
        }

        return false;
    }

    private static List<int[]> getCandidates (int m, int n, char next, int[][] visited, char[][] board) {
         List<int[]> candidates = new ArrayList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] d : dir) {
            int newM = m + d[0];
            int newN = n + d[1];
            if (newM >= 0 && newM < visited.length && newN >= 0 && newN < visited[0].length
                    && visited[newM][newN] == 0 && board[newM][newN] == next) {
                     candidates.add(new int[] {newM, newN});
            }
        }
        return candidates;
    }
}
