import java.util.Arrays;
import java.util.HashSet;

public class ConsecutiveFloors {
    public static void main(String[] args) {
        System.out.println(maxConsecutive(2,9,new int[] {4,6}));
    }
    public static int maxConsecutive(int bottom, int top, int[] special) {
        //first we need to sort special (logn)
        Arrays.sort(special);
        int currentBottom = bottom, currentTop = special[0];
        //edge cases
        int max = Math.max(currentTop - currentBottom, top - special[special.length-1]);

        for (int x=0; x < special.length-1; x++) {
            currentBottom = special[x];
            currentTop = special[x+1];
            max = Math.max(max, (currentTop - currentBottom) - 1);
        }

        return max;
    }
}
