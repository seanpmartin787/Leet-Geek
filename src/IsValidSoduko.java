public class IsValidSoduko {
    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
}
    public static boolean isValidSudoku(char[][] board) {
        //for each char that is not null, we have three validations
        //we could probably optimize time with extra memory,
        //keeping track of numbers used in each row, column, and box
        //but that would be 27 additional sets to keep track of
        int[] startIndex = new int[2];
        int[] endIndex = new int[2];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                char current = board[i][j];
                if (Character.isDigit(current)) {
                    if (!isValidRow(board, i, current)) return false;
                    if (!isValidCol(board, j, current)) return false;
                    getBoxIndexes (i,j,startIndex,endIndex);
                    if (!isValidBox(board, startIndex, endIndex, current)) return false;
                }
            }
        }
        return true;
    }
    private static void getBoxIndexes (int i, int j, int[] startIndex, int[] endIndex) {
        switch (i) {
            case 0: case 1: case 2:
                startIndex[0] = 0;
                endIndex[0] = 2;
                break;
            case 3: case 4: case 5:
                startIndex[0] = 3;
                endIndex[0] = 5;
                break;
            default:
                startIndex[0] = 6;
                endIndex[0] = 8;
                break;
        }

        switch (j) {
            case 0: case 1: case 2:
                startIndex[1] = 0;
                endIndex[1] = 2;
                break;
            case 3: case 4: case 5:
                startIndex[1] = 3;
                endIndex[1] = 5;
                break;
            default:
                startIndex[1] = 6;
                endIndex[1] = 8;
                break;
        }
    }
    private static boolean isValidBox (char[][] board, int[] startIndex, int[] endIndex, char search) {
        int freq = 0;

        for (int i=startIndex[0]; i <= endIndex[0]; i++) {
            for (int j=startIndex[1]; j <= endIndex[1]; j++) {
                if (board[i][j] == search) freq++;
            }
        }
        return freq == 1;
    }

    private static boolean isValidRow (char[][] board, int startRow, char search) {
        int freq = 0;

        for (int i=0; i<board[startRow].length; i++) {
            if (board[startRow][i] == search) freq++;
        }
        return freq == 1;
    }

    private static boolean isValidCol (char[][] board, int startCol, char search) {
        int freq = 0;

        for (int i=0; i<board.length; i++) {
            if (board[i][startCol] == search) freq++;
        }
        return freq == 1;
    }
}
