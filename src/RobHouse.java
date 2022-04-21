import java.util.Arrays;

public class RobHouse {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int totalLoot = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        totalLoot = rob (nums, memo, nums.length - 1);
//         for (int i = 0; i < nums.length; i++) {
//
//        }
        return totalLoot;
    }

    private int rob(int[] nums, int[] memo, int target) {
        if (target < 0) return 0;
        if (memo[target] != -1 ) return memo[target];

        int loot = Math.max(rob(nums, memo, target - 2) + nums[target], rob(nums, memo,target - 1));
        memo[target] = loot;
        return loot;
    }
}
