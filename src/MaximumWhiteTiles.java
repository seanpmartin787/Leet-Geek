import java.util.Arrays;

public class MaximumWhiteTiles {
    public static void main(String[] args) {
        System.out.println(maximumWhiteTiles(new int[][] {{1,5},{10,11},{12,18},{20,25},{30,32}}, 10));
        System.out.println(maximumWhiteTiles(new int[][] {{10,11},{1,1}}, 2));
    }
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        long[] totalTiles = new long[n];
        int ans = 0;

        Arrays.sort( tiles, (t1, t2) -> t1[0] - t2[0] ); //comparator saying we should sort

        // Prefix sum : which stores the count of white tiles from 0th index to ith index.
        for( int i = 0; i < n; i++ )
        {
            totalTiles[i] = ( i > 0 ? totalTiles[i-1] : 0 ) + tiles[i][1] - tiles[i][0] + 1;
        }
        for( int i = 0; i < n; i++ )
        {
            int nextPoint = tiles[i][0] + carpetLen - 1;  // carpet ends at
            int index = binarySearch( tiles, i, n-1, nextPoint );  // valid index in sorted tiles, where 'nextpoint' lies.

            int temp = (int) totalTiles[index] - ( i > 0 ? (int) totalTiles[i-1] : 0 );

            if( nextPoint < tiles[index][1] )
                temp -= ( tiles[index][1] - nextPoint );
            ans = Math.max( ans, temp );
        }

        return ans;
    }
    private static int binarySearch (int[][] tiles, int left, int right, int value) {
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (value >= tiles[mid][0] && value <= tiles[mid][1]) return mid;
            else if (value < tiles[mid][0]) {
                right = mid - 1;
            } else {
                index = mid;
                left = mid + 1;
            }

        }
        return index;
    }
}
