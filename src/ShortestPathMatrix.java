import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathMatrix {
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][] {{0,0,0},{1,0,0},{1,1,0}}));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int shortestPath = 0;
        Queue<int[]> coordinates = new LinkedList<>() {};
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] jumpDirections = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        int n = grid.length;
        coordinates.add(new int[] {0,0}); //add first leg of the search

        while (!coordinates.isEmpty()) {
            shortestPath++;
            int size = coordinates.size();
            for (int i = 0; i < size; i++ ) {
                int[] curr = coordinates.poll();
                if (curr[0] == n-1 && curr[1] == n-1) return shortestPath;
                visited[curr[0]][curr[1]] = 1;

                for (int[] jumps : jumpDirections) {
                    int[] nextJump = new int[] {curr[0]+jumps[0],curr[1]+jumps[1]};
                    if (nextJump[0] >= 0
                            && nextJump[0] < n
                            && nextJump[1] >= 0 && nextJump[1] < n
                            && visited[nextJump[0]][nextJump[1]] != 1
                            && grid[nextJump[0]][nextJump[1]] == 0) {
                        coordinates.add(nextJump);
                    }
                }

            }
        }
        return -1;
    }
}
