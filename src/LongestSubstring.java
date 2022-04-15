import java.util.HashMap;

public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println("Answer: " + lengthOfLongestSubstring("abcdafdhfdhfdaqwert"));
    }
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> dict = new HashMap<>();
        int longestSub = 0;

        for (int i = 0; i < s.length(); i++) {
            dict.clear();
            int j = i;
            while (j < s.length() && !(dict.containsKey(s.charAt(j)))) {
                dict.put(s.charAt(j),1);
                j++;
            }

            longestSub = Math.max(longestSub, dict.size());
        }

        return longestSub;
    }
}
