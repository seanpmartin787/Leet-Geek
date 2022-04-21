import java.util.ArrayList;
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
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j,(triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))));
            }
        }
        return triangle.get(0).get(0);
    }
}
