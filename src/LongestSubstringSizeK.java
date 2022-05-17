import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringSizeK {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
    public static int longestSubstring(String s, int k) {
            char[] str = s.toCharArray();
            int[] counts = new int[26];
            int h, i, j, idx, max = 0, unique, noLessThanK;

            for (h = 1; h <= Math.min(str.length,26); h++) {
                Arrays.fill(counts, 0);
                i = 0;
                j = 0;
                unique = 0;
                noLessThanK = 0;
                while (j < str.length) {
                    if (unique <= h) {
                        idx = str[j] - 'a';
                        if (counts[idx] == 0)
                            unique++;
                        counts[idx]++;
                        if (counts[idx] == k)
                            noLessThanK++;
                        j++;
                    }
                    else {
                        idx = str[i] - 'a';
                        if (counts[idx] == k)
                            noLessThanK--;
                        counts[idx]--;
                        if (counts[idx] == 0)
                            unique--;
                        i++;
                    }
                    if (unique == h && unique == noLessThanK)
                        max = Math.max(j - i, max);
                }
            }

            return max;
        }
    }