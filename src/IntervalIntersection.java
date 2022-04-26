import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> arrList = new ArrayList<>();

        for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) arrList.add(new int[]{start,end});

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return arrList.toArray(new int[0][]);
    }
}
