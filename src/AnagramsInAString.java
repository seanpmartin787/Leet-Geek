import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnagramsInAString {
    public static void main(String[] args) {
        String one = "cbaebabacd";
        String two = "abc";
        System.out.println(findAnagrams(one,two));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int startW = 0, matches = 0, sizeW = 0;
        int[] charArray = new int[26];
        int[] pFrequency = new int[26];

        List<Integer> res = new LinkedList<>();

        for ( char c: p.toCharArray()) {
            pFrequency[c - 'a']++;
        }


        for (int i = 0; i < s.length(); i++) {
            int count = pFrequency[s.charAt(i) - 'a'];
            int end = ++charArray[s.charAt(i) - 'a'];
            if (count > 0 && end <= count) matches++;

            //cbaebabacd
            if (i - startW + 1 == p.length()) {
                if (matches == p.length()) res.add(startW);

                int front = charArray[s.charAt(startW) - 'a']--;
                if (count > 0 && front > 0)
                    matches--;

                startW++;
            }
        }

        return res;
    }
}
