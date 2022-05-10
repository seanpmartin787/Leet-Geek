public class LengthOfLIS {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(lengthOfLIS(new int [] {10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int [] {0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int [] {7,7,7,7,7,7,7}));
        long endTime = System.nanoTime();
        System.out.println("Time elapsed: " + (endTime - startTime));
        System.out.println("-".repeat(50));
        startTime = System.nanoTime();
        System.out.println(lengthOfLISBinarySearch(new int [] {10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLISBinarySearch(new int [] {0,1,0,3,2,3}));
        System.out.println(lengthOfLISBinarySearch(new int [] {7,7,7,7,7,7,7}));
        endTime = System.nanoTime();
        System.out.println("Time elapsed: " + (endTime - startTime));
    }
    public static int lengthOfLIS(int[] nums) {
        //okay we watched a video on this
        //[3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]
        //for each point we want to
        //[10,9,2,5,3,7,101,18]
        //LIS: [2,3,7,101]
        //lets find the longest increasing sub string starting at index i and then take the max

        int[] memo = new int[nums.length];
        int LIS = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            getLIS(nums, memo, i);
            LIS = Math.max(LIS, memo[i]);

        }
        return LIS;
    }
    private static void getLIS(int[] nums, int[] memo, int start) {
        //if we have already solved this return the longest substring at the index
        if (memo[start] != 0) return;

        //[10,9,2,5,3,7,101,18]
        //[1 ,1,1,2,2,3, 4 ,4]
        //get the max of any sub sets starting with any number that is smaller than current
        int current = nums[start];
        for (int i = start -1; i >= 0; i--) {
            if (nums[i] < current) {
                getLIS(nums, memo, i);
                memo[start] = Math.max(memo[start], 1 + memo[i]);
            }
        }
        if (memo[start] == 0) memo[start] = 1;
    }

    public static int lengthOfLISBinarySearch(int[] nums) {
        int size = 0;
        //Tails will have the smallest head of increasing sub arrays of the size of that index + 1
        int[] tails = new int[nums.length];

        for (int x : nums) {
            int l = 0, h = size;
            while (l != h) {
                int m = l + (h - l) / 2; //this prevents overflow
                if (tails[m] < x) {
                    l = m + 1;
                } else {
                    h = m; //not m - 1 because we haven't checked m, so we want to include it in the search
                }
            }
            tails[l] = x;
            if (size == l) size++;
        }

        return size;
    }
}
