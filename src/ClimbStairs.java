public class ClimbStairs {
    public int climbStairs(int n) {
        //base case
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;

        int[] stepsToTake = new int[n + 1];
        stepsToTake[0] = 0;
        stepsToTake[1] = 1;
        stepsToTake[2] = 2;
        for (int i = 3; i < stepsToTake.length; i++) {
            stepsToTake[i] = stepsToTake[i - 1] + stepsToTake[i -2];
        }
        return stepsToTake[n];
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
