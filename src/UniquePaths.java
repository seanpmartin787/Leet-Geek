public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
    public static int uniquePaths(int m, int n) {
        //this feels like a DFS because we want to find every possible
        //lets solve this that way, recursively
        //then lets see if we can optimize with memo
        //then lets see can do a top down solution iteratively
            //which seems very doable considering this feels a lot like the stair step problem, but 2d
        return solvePaths(m,n,0,0);
    }
    private static int solvePaths (int m, int n, int i, int j) {
        if (i == m-1 && j == n-1) return 1;
        int solvedPaths = 0;
        if (i >= 0 && i < m && j >= 0 && j < n) {
            solvedPaths += solvePaths(m,n,i+1,j);
            solvedPaths += solvePaths(m,n,i,j+1);
        }
        return solvedPaths;
    }
}
