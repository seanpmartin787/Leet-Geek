public class JumpGame {
    public boolean canJump(int[] nums) {
        //okay memo saved the day, but what about a bottom up approach?

        return solveJump(nums, new int[nums.length],0);
    }

    public static boolean solveJump (int[] nums, int[] memo, int index) {
        if (index >= nums.length || memo[index] == -1) return false; //is this a valid state or a bad path?
        if (index == nums.length - 1) return true; //is this a solved state?

        for (int i = nums[index]; i > 0; i--) {
            if (solveJump(nums, memo,index + i)) return true;
            memo[index] = -1;
        }
        return false;
    }
}
