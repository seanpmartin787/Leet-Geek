public class MaximumWhiteTiles {
    public static void main(String[] args) {
        System.out.println(maximumWhiteTiles(new int[][] {{1,5},{10,11},{12,18},{20,25},{30,32}}, 10));
        System.out.println(maximumWhiteTiles(new int[][] {{10,11},{1,1}}, 2));
    }
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        //we could brute force this by stretching the carpet over every entry of every array
        //but, really I think we just want to find the largest (non-contiguous) subset of length, carpetLen that touches the most white tiles
        //int[][] memo = new int[tiles.length][tiles[0].length];
        int maxTiles = 0, currentTiles= 0, nextEnd = 0;

        for (int i=0,j=0; i < tiles.length; i++,j=i) {
            nextEnd = tiles[j][0] + carpetLen;
            currentTiles = 0;
            while (j < tiles.length && tiles[j][1] < nextEnd) {
                currentTiles += tiles[j][1] - tiles[j][0] + 1; //add the tiles in this group
                j++; //find the next end point
            }
            if (j < tiles.length && j > i) {
                currentTiles += Math.max(nextEnd - tiles[j][0], 0); //tiles in this group up until the end one
            }
            maxTiles = Math.max(currentTiles,maxTiles);
        }
        return maxTiles;
    }
}
