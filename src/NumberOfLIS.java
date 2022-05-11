import java.util.HashMap;

public class NumberOfLIS {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        //recursion requires top down, iteration can be bottom up
        //both are similar speeds, although iteration tends to be quicker
        //and use less memory because there is no need to keep track of a recusive stack
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 == len[i]) cnt[i] += cnt[j];
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
