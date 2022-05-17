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
    public int longestSubstringRecursion(String s, int k) {
        int[] freq = new int[26];
        int res = 0, start = 0;

        for(int i = 0; i < s.length(); ++i) ++freq[s.charAt(i) - 'a'];

        boolean valid = true;

        for(int end = 0; end < s.length(); ++end){
            if(freq[s.charAt(end) - 'a'] < k){
                res = Math.max(res, longestSubstring(s.substring(start, end), k));
                valid = false;
                start = end + 1;
            }
        }

        return valid? s.length() : Math.max(res, longestSubstring(s.substring(start), k));
    }
}