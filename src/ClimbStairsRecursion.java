public class ClimbStairsRecursion {
    public int climbStairs(int n) {
        //base case
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        n = climbStairs(n - 1) + climbStairs(n - 2);

        return n;
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
