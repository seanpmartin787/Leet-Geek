import java.util.Arrays;

public class validArraySplits {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[] {10,4,-8,7}));
        System.out.println(waysToSplitArray(new int[] {2,3,1,0}));
    }
    public static int waysToSplitArray(int[] nums) {
        //Valid if there is at least one item in the right array,
        //and sum(array 1) > sum(array 2)
        //set up base cases
        int leftSum = 0;
        int rightSum = 0;
        int total = 0;
        for (int x: nums) {
            total += x;
        }

        int validSplits = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum = nums[i] + leftSum; //sum up to this point
            rightSum = total - leftSum;
            if (leftSum >= rightSum) validSplits++;
        }

        return validSplits;
    }

}
