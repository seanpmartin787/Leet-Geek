public class MinDistanceTwoWords {
    public static void main(String[] args) {
        //"horse"
        //"ros"
        System.out.println(minDistance("horse","ros"));
        //"intention"
        //"execution"
        System.out.println(minDistance("intention","execution"));
        //"intention"
        //"intentionssss"
        System.out.println(minDistance("intention","intentionssss"));
        //"intentionssss"
        //"intention"
        System.out.println(minDistance("intentionssss","intention"));
    }
    public static int minDistance(String word1, String word2) {

        //edge cases
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return 0;


        int length1 = word1.length(), length2 = word2.length();
        //Base case is just replace/delete each character which is why costs on the border are == length of substring
        int[][] cost = new int[word1.length()+1][word2.length()+1];

        for (int i=0;i<=length1;i++){
            cost[i][0] =i;
        }

        for (int j=0;j<=length2;j++){
            cost[0][j] = j;
        }

        for (int i=0; i < length1; i++) {
            for (int j=0; j < length2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i+1][j+1] = cost[i][j];
                } else {
                    int add = cost[i][j+1];
                    int delete = cost[i+1][j];
                    int rep = cost[i][j];
                    cost[i+1][j+1] = Math.min(Math.min(add,delete),rep)+1;
                }
            }
        }
        return cost[length1][length2];
    }
}
