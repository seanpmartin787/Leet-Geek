import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
//        List<List<Integer>> tri = new ArrayList<>();
//        tri.add(new ArrayList<>(List.of(2)));
//        tri.add(new ArrayList<>(List.of(3,4)));
//        tri.add(new ArrayList<>(List.of(6,5,7)));
//        tri.add(new ArrayList<>(List.of(4,1,8,3)));
//        //[[2],[3,4],[6,5,7],[4,1,8,3]]
//        System.out.println(minimumTotal(tri));
        int[][] memo = new int[3][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], -1);
            for (int me : memo[i]) {
                System.out.println(me);
            }
        }
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int min = 0;
        int[][] memo = new int[triangle.size()][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], -1);
        }

        min = getMin(memo, triangle, new int[]{0,0});

        return min;
    }
    private static int getMin (int[][] memo, List<List<Integer>> triangle, int[] coord) {
        if (coord[0] == triangle.size()) return 0;
        if (memo[coord[0]][coord[1]] != -1) return memo[coord[0]][coord[1]];

        int min = triangle.get(coord[0]).get(coord[1]);
        min += Math.min(getMin(memo, triangle, new int[] {coord[0] + 1, coord[1]}),
                getMin(memo, triangle, new int[] {coord[0] + 1, coord[1] + 1}));
        memo[coord[0]][coord[1]] = min;
        return min;
    }
}
