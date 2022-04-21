import java.util.ArrayList;
import java.util.List;

public class Triangle {
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

        min = getMin(triangle, new int[]{0,0});

        return min;
    }
    private static int getMin (List<List<Integer>> triangle, int[] coord) {
        if (coord[0] == triangle.size()) return 0;

        int min = triangle.get(coord[0]).get(coord[1]);
        min += Math.min(getMin(triangle, new int[] {coord[0] + 1, coord[1]}),getMin(triangle, new int[] {coord[0] + 1, coord[1] + 1}));
        return min;

    }
}
