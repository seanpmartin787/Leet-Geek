public class DeleteDistance {

        static int deletionDistance(String str1, String str2) {
            // your code goes here
            if (str1 == null || str2 == null) return -1;
            if (str1.isEmpty()) return str2.length();
            if (str2.isEmpty()) return str1.length();

            int length1 = str1.length(),length2 = str2.length();
            int[][] memo = new int[length1+1][length2+1];
            initializeArray(memo);

            char char1, char2;

            for (int i = 1; i < memo.length; i++) {
                char1 = str1.charAt(i-1);
                for (int j = 1; j < memo[0].length; j++) {
                    char2 = str2.charAt(j-1);
                    if (char1 == char2) memo[i][j] = memo[i-1][j-1];
                    else {
                        int best = Math.min(memo[i-1][j],memo[i][j-1]);

                        memo[i][j] = best + 1;
                    }
                }
            }
            return memo[length1][length2];
        }

        public static void main(String[] args) {

        }

        private static void initializeArray(int[][] memo) {
            for (int i = 0; i < memo[0].length; i++) {
                memo[0][i] = i;
            }

            for (int j = 0; j < memo.length; j++) {
                memo[j][0] = j;
            }
        }
}
