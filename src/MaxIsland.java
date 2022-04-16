public class MaxIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;
        //traverse vertically
        for (int i = 0; i < grid.length; i ++) {
            //traverse horizontally
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxIsland = Math.max(maxIsland, getMaxIsland(grid, i, j));
                }
            }
        }

        return maxIsland;
    }

    public static int getMaxIsland (int[][] grid, int i, int j) {
        int islandSize = 0;

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            islandSize++;
            islandSize += getMaxIsland(grid, i+1, j);
            islandSize += getMaxIsland(grid, i-1, j);
            islandSize += getMaxIsland(grid, i, j+1);
            islandSize += getMaxIsland(grid, i, j-1);
        }

        return islandSize;
    }
}
