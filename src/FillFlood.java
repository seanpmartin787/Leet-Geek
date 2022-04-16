public class FillFlood {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        System.out.println(matrix.length);
        System.out.println(matrix[1].length);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;

        changeColor(image, sr+1, sc, oldColor, newColor );
        changeColor(image, sr-1, sc, oldColor, newColor );
        changeColor(image, sr, sc+1, oldColor, newColor );
        changeColor(image, sr, sc-1, oldColor, newColor );

        return image;

    }

    public static void changeColor (int[][] image, int sr, int sc, int oldColor, int newColor) {

        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[sr].length && image[sc][sr] == oldColor) {
            image[sc][sr] = newColor;
            changeColor(image, sr + 1, sc, oldColor, newColor);
            changeColor(image, sr - 1, sc, oldColor, newColor);
            changeColor(image, sr, sc + 1, oldColor, newColor);
            changeColor(image, sr, sc - 1, oldColor, newColor);
        }//recurse and call on 4 match
    }
}
