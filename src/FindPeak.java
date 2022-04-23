public class FindPeak {
    public int findPeakElement(int[] nums) {
        //edge cases
        if (nums.length <= 1 || nums[0] > nums[1]) return 0;
        if (nums[nums.length-1] > nums[nums.length -2]) return nums.length -1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >  nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
    public int findPeakElementBS(int[] num) {
        //edge cases
        int low = 0;
        int high = num.length-1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
