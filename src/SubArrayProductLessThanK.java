public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //First instinct: iterate through in one loop and keep expanding window until condition is violated
        //Then move to second index with window size of 1 and keep going
        int countRes = 0, product = 1;

        for (int i = 0, j = 0; i < nums.length; i++) {
            product *= nums[i];

            while (j <= i && product >= k ) {
                product /= nums[j];
                j++;
            }
            countRes += i - j + 1;
        }


        return countRes;
    }
}
