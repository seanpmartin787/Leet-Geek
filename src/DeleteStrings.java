public class DeleteStrings {
    public int minDistance(String word1, String word2) {
        //edge cases
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return 0;

        //every time they have a new matching character we increment overlap
        //numOfDeletes would be (word1 - overlap) + (word2 - overlap)
        int totalOverlap = 0, length1 = word1.length(), length2 = word2.length();
        int[][] overlap = new int[word1.length()+1][word2.length()+1];

        for (int i=1; i <= length1; i++) {
            for (int j=1; j <= length2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    overlap[i][j] = overlap[i-1][j-1] + 1;
                    totalOverlap = Math.max(totalOverlap,overlap[i][j]);

                    //early exit if one completely overlaps
                    if (totalOverlap == length1 || totalOverlap == length2) break;
                }
            }
        }

        return (length1 - totalOverlap) + (length2 - totalOverlap);

    }
}
