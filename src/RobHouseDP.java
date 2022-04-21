import java.util.Arrays;

public class RobHouseDP {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    public static int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 = nums[0];
        int current = nums[1];

        for (int i = 1; i < nums.length; i++) {
            current = nums[i];
            current = Math.max(prev2 + current, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
