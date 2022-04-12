import java.util.HashMap;

public class TwoSumSortedArr {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {1,2};
        } else {
            int low = 0, high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) break;
                else if (sum < target) low++;
                else high--;
            }
            return new int[] {low+1,high+1};
        }//else it is not so easy
    }
}
