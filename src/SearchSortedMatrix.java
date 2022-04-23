public class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        searchMatrix(matrix, 20);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int low = 0, high = matrix.length - 1, midx = 0, midy = 0;

        while (low <= high) {
            midx = low + (high - low) / 2;

            if (matrix[midx][0] == target) return true;
            else if (matrix[midx][0] < target && target <= matrix[midx][matrix[midx].length - 1]) break; //we found the right x index
            else if (matrix[midx][0] > target) high = midx - 1;
            else low = midx + 1;
        }

        low = 0;
        high = matrix[midx].length - 1;

        while (low <= high) {
            midy = low + (high - low) / 2;

            if (matrix[midx][midy] == target ) return true;
            else if (matrix[midx][midy] > target ) high = midy - 1;
            else low = midy + 1;
        }
        return false;
    }
}
