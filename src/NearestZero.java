import java.util.LinkedList;
import java.util.Queue;

public class NearestZero {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int rowLength = matrix.length, columnLength = matrix[0].length;
        boolean[][] visited = new boolean[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == 0) {
                    //add in all the 0's and mark as visited
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        //This way we can get each of the four directions without repeating code
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d: dir) {
                int row = cur[0] + d[0];
                int col = cur[1] + d[1];
                if (row < 0 || row >= rowLength || col < 0 || col >= columnLength || visited[row][col]) {
                    //If we have already visited this 1, then continue looking for unvisited ones
                    continue;
                }
                visited[row][col] = true;
                //If we found a path that came from a non zero, then this is that many deep + 1
                matrix[row][col] = matrix[cur[0]][cur[1]] + 1;
                //we add this in so that we will look at it after all the 0's have been looked at
                //This way we guarantee the value stored in the matrix is the min
                queue.offer(new int[]{row, col});
            }
        }
        return matrix;
    }
}
