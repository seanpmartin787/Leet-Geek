import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleDP {
    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(new ArrayList<>(List.of(2)));
        tri.add(new ArrayList<>(List.of(3,4)));
        tri.add(new ArrayList<>(List.of(6,5,7)));
        tri.add(new ArrayList<>(List.of(4,1,8,3)));
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        System.out.println(minimumTotal(tri));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = 0;
        int[][] memo = new int[triangle.size()][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
        }
        for (int a = 0; a < triangle.size(); a++) {
            //initialize base cases
            memo[triangle.size()-1][a] = triangle.get(triangle.size()-1).get(a);
        }

        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = triangle.get(i).get(j);
                memo[i][j] += Math.min(memo[i+1][j], memo[i+1][j+1]);
            }
        }

        return memo[0][0];
    }
}
