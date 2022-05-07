public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
        System.out.println(uniquePaths(7,3));
        System.out.println(uniquePaths(3,2));
        System.out.println(uniquePaths(23,12));
    }
    public static int uniquePaths(int m, int n) {
        //this feels like a DFS because we want to find every possible
        //lets solve this that way, recursively
        //then lets see if we can optimize with memo
        //then lets see can do a top-down solution iteratively
            //which seems very doable considering this feels a lot like the stair step problem, but 2d
        if (m <= 1 || n <= 1) return 1;
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = Math.max(1, memo[i-1][j]) + Math.max(1, memo[i][j-1]);
            }
        }
        return memo[m-1][n-1];
    }
}
