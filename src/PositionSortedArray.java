public class PositionSortedArray {
    public static void main(String[] args) {
        int[] indexes = searchRange(new int[] {2,2}, 2);

        for (int index: indexes) {
            System.out.println(index);
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        if (nums.length == 1 & nums[0] == target) return new int[]{0,0};
        else if (nums.length == 1 & nums[0] != target) return new int[]{-1,-1};

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = high = mid;
                while ((high < nums.length -1) && nums[high + 1] == target ) high++;
                while ((low > 0) && nums[low - 1] == target ) low--;
                return new int[] {low, high};
            } else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new int[]{-1,-1};
    }
}
