import java.util.List;
import java.util.PriorityQueue;

public class FillBagsRocks {
    public static void main(String[] args) {
        System.out.println(maximumBags(new int[] {2,3,4,5}, new int[] {1,2,4,4}, 2));
    }
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //Lets add all the differences into PQ (n log(n))
        //and then peek/pop until no more additional rocks

        PriorityQueue<Integer> spaceLeft = new PriorityQueue<>();
        int space = 0, spotsFilled = 0;

        for (int i=0; i < rocks.length; i++) {
            space = capacity[i] - rocks[i];
            if (space == 0) spotsFilled++;
            else spaceLeft.add(space);
        }
        while (!spaceLeft.isEmpty() && additionalRocks > 0) {
            if (spaceLeft.peek() <= additionalRocks) spotsFilled++;

            additionalRocks = additionalRocks - spaceLeft.poll();
        }
        return spotsFilled;
    }
}
