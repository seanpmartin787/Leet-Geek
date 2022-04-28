public class MinSubGreaterThanK {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[] {1,1,3,5,10,5,4,9,2,50}));

    }
    public static int minSubArrayLen(int target, int[] nums) {
        //Dynamically sized sliding door problem
        int sum = 0, minSize = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                minSize = Math.min(j - i + 1, minSize);
                //Can I do better?
                sum -= nums[i++];
                //early exit condition
                if (minSize == 1) return 1;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
