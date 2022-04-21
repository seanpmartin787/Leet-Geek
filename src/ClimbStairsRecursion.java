public class ClimbStairsRecursion {
    public static void main(String[] args) {
        int[] test = new int[8];
        System.out.println(test[2]);
    }
    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        n = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);

        return n;
    }
    private static int climbStairs(int n, int[] memo) {
        //base case
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];

        int res = climbStairs(n-2, memo) + climbStairs(n-1, memo);
        memo[n] = res;
        return res;
    }
    /*

 5
1 1 1 1 1
1 1 1 2
1 1 2 1
1 2 1 1

2 1 1 1
1 2 2
2 1 2
2 2 1

4
1 1 1 1
1 1 2
1 2 1
2 1 1
2 2

3
1 1 1
1 2
2 1

2
1 1
2

1
1
     */
}
