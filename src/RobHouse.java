public class RobHouse {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int totalLoot = 0;

        totalLoot = rob (nums, nums.length - 1);
//         for (int i = 0; i < nums.length; i++) {
//
//        }
        return totalLoot;
    }

    private int rob(int[] nums, int target) {
        if (target < 0) return 0;

        int loot = Math.max(rob(nums, target - 2) + nums[target], rob(nums, target - 1));
        return loot;
    }
}
