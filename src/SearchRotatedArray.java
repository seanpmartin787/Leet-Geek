public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        if (nums.length == 1 && nums[0] != target) return -1;

        int l = 0, h = nums.length -1;

        while (l <= h) {
            int mid = l + (h-l)/2;

            if (nums[mid] == target) return mid;
            else if (nums[l] <= nums[mid]) {
                //pivot is to the right of mid continue like normal (easy)
                if (nums[l] <= target && target < nums[mid] ) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }
}
