public class FindMinRotatedArray {
        public int findMin(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            if (nums[0] <= nums[nums.length-1]) return nums[0]; //if rotated n times

            int l = 0, h = nums.length -1;

            while (l <= h) {
                int mid = l + (h-l)/2;

                if (l == h) return nums[mid];
                else if (nums[l] <= nums[mid]) {
                    //pivot is to the right of mid continue like normal (easy)
                    if (nums[l] <= nums[h]) {
                        h = mid;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < nums[mid-1]) {
                        return nums[mid]; //we found it
                    } else {
                        h = mid;
                    }
                }
            }
            return -1;
        }
}
//        0,1,2,4,5,6,7
//        7,0,1,2,4,5,6
//        6,7,0,1,2,4,5
//        5,6,7,0,1,2,4
//        4,5,6,7,0,1,2
//        2,4,5,6,7,0,1
//        1,2,4,5,6,7,0






