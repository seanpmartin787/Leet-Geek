public class RobHouseII {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,1,1}));
    }
    public static int rob(int[] nums) {
        //treat array like a circular array where 0 and length - 1 are adjacent
        //DP: break problem down into the smallest bits
        //I can have all the money I would've gotten from the previous every other house plus this house
        //or, I can give up the current house's loot and take current - 1 and all the loot that goes with that
        //aka I will take max(current + current - 2, current - 1)
        //not sure how the circular array will play out yet... with two house robbers!!
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);


        return Math.max(robHouses(nums, 0, nums.length-2),robHouses(nums, 1, nums.length-1));
    }

    private static int robHouses (int[] nums, int start, int last) {
        int riches = 0, prev1 = 0, prev2 = 0;
        for (int i = start; i <= last; i++) {
            riches = nums[i];
            riches = Math.max(prev2 + riches, prev1);
            prev2 = prev1;
            prev1 = riches;
        }
        return riches;
    }
}
