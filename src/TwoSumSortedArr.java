import java.util.HashMap;

public class TwoSumSortedArr {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {1,2};
        } else {
            HashMap<Integer,Integer> numMap= new HashMap<>();

            for (int i = 0; i < nums.length; i++ ) {
                Integer difference = target - nums[i];
                if (numMap.containsKey(difference)) {
                    return new int[] {numMap.get(difference) + 1, i + 1 };
                }
                numMap.put(nums[i], i);
            }
            //if you have gotten here you are SOL
            return null;
        }//else it is not so easy
    }
}
