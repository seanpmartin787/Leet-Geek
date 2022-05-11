public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ace","abcde"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        //I want string 1 to always be the short one
        //what are our edge cases?
        //text1 or text 2 is null return 0
        //text1 empty || text2 empty return 0
        //text 2 (shorter one) has one character, no match
        //text 2 has no matching characters
        //or there exists some disjointed subsequence that matches
        //Finally, could be that text 1 == text2
        //Let's explore a bottom up DP approach
        //we should keep track of:
        //length of the longest increasing subsequence
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) return 0;
        char char1, char2;
        //Length of the longest common substring end at index i of text1, and index j of text2
        //for example length[2][3] = 1 means there was only a sequence of 1 character matching
        // from 0 -> 2 of text 1 and
        // from 0 -> 3 of text 2

        int[][] length = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            char1 = text1.charAt(i-1);
            //search through the longer one
            for (int j = 1; j <= text2.length(); j++) {
                char2 = text2.charAt(j-1);
                if (char1 == char2) {
                    length[i][j] = length[i-1][j-1] + 1;
                } else {
                    length[i][j] = Math.max(length[i-1][j], length[i][j-1]);
                }
            }
        }
        return length[text1.length()][text2.length()];
    }
}
