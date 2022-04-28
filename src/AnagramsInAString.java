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
        int startW = 0, matches = 0;
        int[] window = new int[26];
        int[] pFrequency = new int[26];

        List<Integer> res = new LinkedList<>();

        for ( char c: p.toCharArray()) {
            pFrequency[c - 'a']++;
        }


        for (int i = 0; i < s.length(); i++) {
            int freq = pFrequency[s.charAt(i) - 'a'];
            int end = ++window[s.charAt(i) - 'a'];
            if (freq > 0 && end <= freq) matches++;

            //if window is at max size
            if (i - startW + 1 == p.length()) {
                //if we found a matching substring
                if (matches == p.length()) res.add(startW);

                //find out how many of the start char we have and then decrement
                int front = window[s.charAt(startW) - 'a']--;
                freq = pFrequency[s.charAt(startW) - 'a'];
                //if we lose a match
                // aka the number we have becomes less than the number we need of a char
                if (freq > 0 && front <= freq)
                    matches--;

                startW++;
            }
        }
        return res;
    }
}
