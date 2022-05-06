public class JumpGame {
    public boolean canJump(int[] nums) {
        return solveJump(nums, 0);
    }

    public static boolean solveJump (int[] nums, int index) {
        if (index >= nums.length) return false; //is this a valid state?
        if (index == nums.length - 1) return true; //is this a solved state?

        for (int i = nums[index]; i > 0; i--) {
            if (solveJump(nums,index + i)) return true;
        }
        return false;
    }
}
