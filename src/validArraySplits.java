import java.util.Arrays;

public class validArraySplits {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[] {10,4,-8,7}));
        System.out.println(waysToSplitArray(new int[] {2,3,1,0}));
        System.out.println(waysToSplitArray(new int[] {2,3}));
        System.out.println(waysToSplitArray(new int[] {3,2}));
        System.out.println(waysToSplitArray(new int[] {3}));


    }
    public static int waysToSplitArray(int[] nums) {
        //Valid if there is at least one item in the right array,
        //and sum(array 1) > sum(array 2)
        //set up base cases
        long leftSum = 0;
        long total = 0;
        for (int x: nums) {
            total += x;
        }

        int validSplits = 0;

        for (int i = 0; i < nums.length-1; i++) {
            leftSum = nums[i] + leftSum; //sum up to this point
            if (leftSum >= (total - leftSum)) validSplits++;
        }

        return validSplits;
    }

}
