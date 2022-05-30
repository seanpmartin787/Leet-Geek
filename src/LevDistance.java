public class LevDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));

    }
    public static int minDistance(String word1, String word2) {

        //edge cases
        //if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return 0;
        //levenstein distance
        int[][] memo = new int[word1.length() +1][word2.length() +1];
        int len1 = word1.length(), len2 = word2.length();

        initializeArray(memo);

        for (int i=1; i<=len1;i++) {
            for(int j=1; j<=len2; j++){
                //loop through all combinations
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.min(Math.min(memo[i-1][j], memo[i][j-1]),memo[i-1][j-1]) + 1;
                }
            }
        }
        return memo[len1][len2];
    }

    public static void initializeArray(int[][] memo) {
        for (int i=0; i<memo.length;i++) {
            memo[i][0] = i;
        }
        for(int j=1; j<memo[0].length; j++){
            memo[0][j] = j;
        }
    }
}
