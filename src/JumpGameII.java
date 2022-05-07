public class JumpGameII {
    public static void main(String[] args) {
        //[2,3,1,1,4]
        System.out.println(jump(new int[] {2,3,1,1,4}));
        //2,3,0,1,4
        System.out.println(jump(new int[] {2,3,0,1,4}));
        //[7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
        System.out.println(jump(new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));

    }
    public static int jump(int[] nums) {
        //What I am thinking is basically the same as last time, except we count every time we increase our max distance
        //This can be done in an iterative DP, greedy approach (greedy bc we take the max)
        //implicit BFS, because you look at every option in the level (i < currentEnd) to find the furthest jump
        //and then go to the next level to take another jump
        int maxDistanceIndex = 0,currentEnd = 0, numJumps = 0;

        for (int i = 0; i < nums.length && currentEnd < nums.length - 1; i++) {
            maxDistanceIndex = Math.max(nums[i] + i, maxDistanceIndex);
            if (i == currentEnd) {
                currentEnd = maxDistanceIndex;
                numJumps++;
            }
        }
        return numJumps;
    }
}
