public class LongestCommonSubsequence {
    public static void main(String[] args) {
        longestCommonSubsequence(null,null);
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
        int longestCommonSubsequence = 0;
        char char1, char2;
        //Length of the longest common substring end at index i of text1, and index j of text2
        //for example length[2][3] = 1 means there was only a sequence of 1 character matching
        // from 0 -> 2 of text 1 and
        // from 0 -> 3 of text 2

        if (text1.length() > text2.length()) {
            //flip text1 to be the shorter one
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[][] length = new int[text1.length()][text2.length()];

        char1 = text1.charAt(0);
        char2 = text2.charAt(0);
        length[0][0] = char1 == char2 ? 1 : 0;
        //initialize base case's for bottom up approach
        for (int i = 1; i < text1.length(); i++) {
            char1 = text1.charAt(i);
            length[i][0] = Math.max(length[i-1][0], char1 == char2 ? 1 : 0);
        }
        char1 = text1.charAt(0);
        for (int j = 1; j < text2.length(); j++) {
            char2 = text2.charAt(j);
            length[0][j] = Math.max(length[0][j - 1], char1 == char2 ? 1 : 0);
        }
        //[0,0,0]
        //[0,0,0]
        //length
        //  [1,1,1,1,1]
        //  [1,1,2,2,2]
        //  [1,1,2,2,3]
        //text1 = "ace", text2 = "abcde"
        //iterate through the shorter one
        for (int i = 1; i < text1.length(); i++) {
            char1 = text1.charAt(i);
            //search through the longer one
            for (int j = 1; j < text2.length(); j++) {
                char2 = text2.charAt(j);
                if (char1 == char2) {
                    length[i][j] = length[i-1][j-1] + 1;
                } else {
                    length[i][j] = Math.max(length[i-1][j], length[i][j-1]);
                }
            }

        }

        return length[text1.length()-1][text2.length()-1];
    }
}
