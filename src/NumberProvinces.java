public class NumberProvinces {
    public int findCircleNum(int[][] grid) {
        int provinceCount = 0;
        int[] visited = new int[grid.length];

        for (int i = 0; i < visited.length; i++) {
            //if we haven't visited this province
            if (visited[i] == 0) {
                //find cycle
                visitNeighbors(grid, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }
    public static void visitNeighbors (int[][] grid, int[] visited, int province) {

        for (int j = 0; j < grid.length; j++) {
            if (province == j) continue; //same vertex

            if (grid[province][j] == 1 && visited[j] == 0) {
                //if we find a new path to traverse
                visited[j] = 1;
                visitNeighbors(grid, visited, j);
            }
        }

    }
}
