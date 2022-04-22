import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SIngleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> list = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.toArray(new Integer[1])[0];
    }
}
