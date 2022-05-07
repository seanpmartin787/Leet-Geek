import java.util.ArrayList;
import java.util.List;

public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1,2,3,4}));
    }
    //An Arithmetic slice
    //consists of at least three elements
    // and the difference between any two consecutive elements is the same
    //For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    public static int numberOfArithmeticSlices(int[] nums) {
        //basically this is the number of contiguous subsets of size >= 3
        if (nums.length < 3) return 0; //need 3 elements for an arithmetic slice
        return solveSlices(nums, 0, new ArrayList<>());
    }
    public static int solveSlices (int[] nums, int start, List<Integer> slice) {
        int numSlices = 0;
        if (slice.size() >= 3) {
            numSlices++;
        }

        for (int i = start; i < nums.length; i++) {
            slice.add(nums[i]);
            numSlices += solveSlices(nums, start + 1, slice);
            slice.remove(slice.size()-1);
        }
        return numSlices;
    }
}
