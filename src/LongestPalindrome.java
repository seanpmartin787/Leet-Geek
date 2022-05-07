import java.util.Queue;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("caa"));
        System.out.println(longestPalindrome("abaccc"));
        System.out.println(longestPalindrome("abbaa"));
        System.out.println(longestPalindrome("zabcba"));

    }
    public static String longestPalindrome(String s) {
        //looks like we basically did two DFSs at each index of the string

        int palindromeStart = 0, palindromeEnd = 0, maxPalindrome = 0;
        String longestPalindrome = "", substring = "";

        for (int i = 0, j; i < s.length(); i++) {
            int start = j = i;
            //look for odd palindromes
            substring = getLongestPalindrome(s, i, j);
            longestPalindrome = substring.length() > maxPalindrome ? substring : longestPalindrome;
            maxPalindrome = longestPalindrome.length();
            if (maxPalindrome == s.length()) break;

            //look for even palindromes
            substring = getLongestPalindrome(s, i, j+1);
            longestPalindrome = substring.length() > maxPalindrome ? substring : longestPalindrome;
            maxPalindrome = longestPalindrome.length();
            if (maxPalindrome == s.length()) break;


        }
        return longestPalindrome;
    }

    private static String getLongestPalindrome (String s, int i, int j) {
        int palindromeStart = 0, palindromeEnd = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            palindromeStart = i;
            palindromeEnd = j;
            i--;
            j++;
        }
        return s.substring(palindromeStart, palindromeEnd+1);
    }
}
