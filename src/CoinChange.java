import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1,2,5},11));
        System.out.println(coinChange(new int[] {1},0));
    }
    public static int coinChange(int[] coins, int amount) {
        //because this is asking for the fewest number of moves,
        // not the total amount of possibilities --> this sounds like a bfs
        // Lets add all the first coins to a queue
        // then for each of those, lets all the coins that keep us below total
        // If one of those equals total we have a match, and we can return whichever level we were on

        if (amount == 0) return 0;

        Queue<Integer> BFS = new LinkedList<>();
        int level = 1, size = 0;

        for (int x : coins) {
            if (x == amount) return level; //quick win
            else if (x < amount ) BFS.offer(x);
        }

        while (!BFS.isEmpty()) {
            level++;
            size = BFS.size();
            //This is clearly 2^N  growth, I bet we can do better
            for (int i = 0; i < size; i++) {
                int num = BFS.poll();
                for (int x : coins) {
                    if (x + num == amount) return level;
                    else if (x + num < amount ) BFS.offer(x+num);
                }
            }
        }
        return -1;
    }
}
