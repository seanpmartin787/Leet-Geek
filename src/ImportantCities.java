import java.util.PriorityQueue;
import java.util.Queue;

public class ImportantCities {
    public static void main(String[] args) {
        //5
        //[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
        System.out.println(maximumImportance(5, new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
        System.out.println(maximumImportance(2, new int[][] {{0,1}}));
    }
    public static long maximumImportance(int n, int[][] roads) {
        //We basically want to put the highest importance on the roads with the most connections
        //so we can use that number more times
        Queue<Integer> cityConnections = new PriorityQueue<>();
        int[] numConnections = new int[n];
        long totalImportance = 0;

        //Find out how many times each city is connected
        for (int i = 0; i < roads.length; i++) {
            numConnections[roads[i][0]]++;
            numConnections[roads[i][1]]++;
        }

        //once we know how many connections each city has let's sort them with a PQ
        //because of underlying heap we can use this to sort n values in O(nlog(n)) time
        for (int num: numConnections) cityConnections.offer(num);

        //n operations
        for (long i = 1; i <= n; i++) totalImportance += i * cityConnections.poll();

        return totalImportance;
        //space complexity = O(2n) = O(n) (we have two (constant) additional data structures of maximum size n)
        //time complexity = O(nlog(n))
    }
}
