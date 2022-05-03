public class SurroundedRegions {
    public static void main(String[] args) {
        //char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = new char[][] {{'O'}};
        char[][] board = new char[][] {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        solve(board);
        System.out.println("all solved!");
    }
    public static void solve(char[][] board) {
        //This feels like flood fill, but only island size is greater than 1
        //Solve with DFS
        //check boundaries first, then if any are unvisited in the middle, flood fill
        int[][] visited = new int[board.length][board[0].length];
        //check boundaries first
        for (int m = 0; m < board.length; m++) {
            if (board[m][0] == 'O') floodFill(visited, board, m, 0, 'O');
            if (board[m][board[0].length-1] == 'O') floodFill(visited, board, m, board[0].length-1, 'O');
        }
        //now we check the internal squares for any unvisited O's which would therefore be surrounded
        for (int n = 1; n < board[0].length-1; n++) {
            if (board[0][n] == 'O') floodFill(visited, board, 0, n, 'O');
            if (board[board.length - 1][n] == 'O') floodFill(visited, board,board.length-1, n, 'O');
        }

        for (int m = 1; m < board.length -1; m++) {
            for (int n = 1; n < board[0].length -1; n++) {
                if (board[m][n] == 'O' && visited[m][n] == 0 ) {
                    board[m][n] = 'O';
                }
            }
        }
    }
    public static void floodFill(int[][] visited, char[][] board, int x, int y, char color) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                && board[x][y] == 'O' && visited[x][y] == 0) {
            board[x][y] = color;
            visited[x][y] = 1;
            int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] d: dir) {
                floodFill(visited, board, x + d[0], y + d[1], color);
            }
        }
    }

}
