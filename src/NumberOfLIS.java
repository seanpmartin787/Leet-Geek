import java.util.HashMap;

public class NumberOfLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int [] {1,3,5,4,7}));
        System.out.println(findNumberOfLIS(new int [] {2,2,2,2,2}));
        //System.out.println(findNumberOfLIS(new int [] {7,7,7,7,7,7,7}));
    }
    public static int findNumberOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int LIS = 0;
        HashMap<Integer, Integer> freq = new HashMap();


        for (int i = nums.length - 1; i >= 0; i--) {
            getLIS(nums, memo, i, freq);
            LIS = Math.max(LIS, memo[i]);
        }
        return freq.get(LIS);
    }
    private static void getLIS(int[] nums, int[] memo, int start, HashMap<Integer, Integer> freq) {
        //if we have already solved this return the longest substring at the index
        if (memo[start] != 0) return;
        //[10,9,2,5,3,7,101,18]
        //[1 ,1,1,2,2,3, 4 ,4]
        //get the max of any sub sets starting with any number that is smaller than current
        for (int i = start -1; i >= 0; i--) {
            if (nums[i] < nums[start]) {
                getLIS(nums, memo, i, freq);
                int currentLongest = memo[i] + 1;
                memo[start] = Math.max(memo[start], currentLongest);
                if (freq.containsKey(currentLongest)) {
                    freq.replace(currentLongest,freq.get(currentLongest) + 1);
                } else freq.put(currentLongest,1);
            }
        }
        if (memo[start] == 0) {
            memo[start] = 1;
            if (freq.containsKey(1)) {
                freq.replace(1,freq.get(1) + 1);
            } else freq.put(1,1);
        }
    }
}
