import java.util.Queue;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("caa"));
        System.out.println(longestPalindrome("abaccc"));
        System.out.println(longestPalindrome("abbaa"));
        System.out.println(longestPalindrome("zabcba"));

    }
    public static String longestPalindrome(String s) {
        //this feels like sliding window
        //I should be always asking, can I do better than this?
        //A palindrome requires the letter mirrored across the middle to be the same
        // even number of items (Ex. (a,a), (a,b,b,a) etc.
        // and odd number of items (Ex. (a,b,a), (a,b,c,b,a) etc.
        // edge cases:
        // -empty string
        // - no palindrome (or longest palindrome == 1 ex. (a,b,c,d,e))
        // - s.length == palindrome (ex. (a,a,a,a,a,a,a))

        //let's do a bfs of any palindrome we find by seeing if start - 1 == end + 1

        int palindromeStart = 0, palindromeEnd = 0, maxPalindrome = 0;

        for (int i = 0, j; i < s.length(); i++) {
            int start = j = i;
            //this works for odd palindromes
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if(maxPalindrome < j- i + 1) {
                    maxPalindrome = j-i+1;
                    palindromeStart = i;
                    palindromeEnd = j;
                    if (maxPalindrome == s.length()) break;
                }
                i--;
                j++;
            }
            i = start;
            j = start+1;
            //this works for even palindromes
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if(maxPalindrome < j- i + 1) {
                    maxPalindrome = j-i+1;
                    palindromeStart = i;
                    palindromeEnd = j;
                    if (maxPalindrome == s.length()) break;
                }
                i--;
                j++;
            }
            i = start;
        }

        return s.substring(palindromeStart,palindromeEnd + 1);
    }
}
