public class NumIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == '1') {
                    islandCount++;
                    //perform dfs to set all adjacent land to 0
                    traverseIsland(grid, m,n);
                }
            }
        }
        return islandCount;
    }

    public static void traverseIsland (char[][] grid, int m, int n) {
        if (m >= 0 && m < grid.length && n >= 0 && n < grid[m].length && grid[m][n] == '1') {
            grid[m][n] = '0';
            int[][] traversals = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] t : traversals) {
                traverseIsland(grid, m + t[0], n + t[1]);
            }
        }
    }
}
