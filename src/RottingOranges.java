import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] matrix) {
        int numberMinutes = -1;
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rowLength = matrix.length, columnLength = matrix[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 2) {
                    //add in all the 0's and mark as visited
                    queue.offer(new int[]{i, j});
                } else if (matrix[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if(countFresh == 0) return 0;
        //This way we can get each of the four directions without repeating code
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            ++numberMinutes;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dir) {
                    int row = cur[0] + d[0];
                    int col = cur[1] + d[1];
                    if (row < 0 || row >= rowLength || col < 0 || col >= columnLength || matrix[row][col] == 0
                            || matrix[row][col] == 2) {
                        //If we have already visited this 1, then continue looking for unvisited ones
                        continue;
                    }
                    matrix[row][col] = 2;
                    //add this one to look at now to see if any oranges are adjacent to this one
                    queue.offer(new int[]{row, col});
                    countFresh--;

                }
            }
        }
        if (countFresh > 0) return -1;
        else return numberMinutes;
    }
}

