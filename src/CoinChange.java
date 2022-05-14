import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {5,2,1},11));
        System.out.println(coinChange(new int[] {1},0));
        System.out.println(coinChange(new int[] {1,2,5},100));
        System.out.println(coinChange(new int[] {2},3));
    }
    public static int coinChange(int[] coins, int amount) {
        //because this is asking for the fewest number of moves,
        // not the total amount of possibilities --> this sounds like a bfs
        // Lets add all the first coins to a queue
        // then for each of those, lets all the coins that keep us below total
        // If one of those equals total we have a match, and we can return whichever level we were on

        int[] memo = new int[amount+1];
        if (amount == 0) return 0;
        getSums(coins,memo,amount);
        return memo[amount];
    }
    private static void getSums (int[] coins, int[] memo, int amount) {
        if (memo[amount] != 0) return;
        //we have a few options, we can take the same coin, or any of the others
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x: coins) {
            if (amount - x >= 0) {
                getSums(coins, memo, amount - x);
                minHeap.add(memo[amount - x] + 1); //whatever the next amount of coins is plus the current coin
            }
        }
        if (!minHeap.isEmpty())
            memo[amount] = minHeap.poll();
    }
}
