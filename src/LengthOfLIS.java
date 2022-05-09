public class LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int [] {10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int [] {0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int [] {7,7,7,7,7,7,7}));
    }
    public static int lengthOfLIS(int[] nums) {
        //okay we watched a video on this
        //[3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
        //for each point we want to
        //[10,9,2,5,3,7,101,18]
        //LIS: [2,3,7,101]
        //lets find the longest increasing sub string starting at index i and then take the max
        int[] memo = new int[nums.length];
        int LIS = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            getLIS(nums, memo, i);
            LIS = Math.max(LIS, memo[i]);

        }
        return LIS;
    }
    private static void getLIS(int[] nums, int[] memo, int start) {
        //if we have already solved this return the longest substring at the index
        if (memo[start] != 0) return;

        //[10,9,2,5,3,7,101,18]
        //[1 ,1,1,2,2,3, 4 ,4]
        //get the max of any sub sets starting with any number that is smaller than current
        int current = nums[start];
        for (int i = start -1; i >= 0; i--) {
            if (nums[i] < current) {
                getLIS(nums, memo, i);
                memo[start] = Math.max(memo[start], 1 + memo[i]);
            }
        }
        if (memo[start] == 0) memo[start] = 1;
    }
}
