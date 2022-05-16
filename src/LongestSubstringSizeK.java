import java.util.HashMap;

public class LongestSubstringSizeK {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
    public static int longestSubstring(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        //add base case for analysis
        freq.put(s.charAt(0), 1);
        int max = 0;

        //this is just a trick sliding window question
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char prevC = s.charAt(i-1);
            //we are creating growing the substring
            if (prevC == c) {
                int count = 1 + freq.get(c);
                freq.replace(c, count);
                //if we have a valid substring
                if (count >= k && count > max) max = count;
            } else if (freq.get(prevC) >= k) {
                //if we are growing a new substring
                freq.put(c, 1);
            } else {
                //else new substring
                freq.clear();
                freq.put(c,1);
            }
        }
    return max;
    }
}
