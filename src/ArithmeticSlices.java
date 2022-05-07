import java.util.ArrayList;
import java.util.List;

public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    //An Arithmetic slice
    //consists of at least three elements
    // and the difference between any two consecutive elements is the same
    //For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
    public static int numberOfArithmeticSlices(int[] nums) {
        var slices = 0;
        for (int i = 2, prev = 0; i < nums.length; i++)
            slices += (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) ?
                    ++prev :
                    (prev = 0);
        return slices;
    }
}
