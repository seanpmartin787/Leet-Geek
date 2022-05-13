import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {5,2,1},11));
        System.out.println(coinChange(new int[] {1},0));
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
    private static int getSums (int[] coins, int[] memo, int amount) {
        if (amount < 0) return Integer.MAX_VALUE - (memo.length); //return arbitrarily large number so it doesn't get picked
        if (amount == 0) return 0; //we found a match, aka no need for more coins
        if (memo[amount] != 0) return memo[amount];

        //we have a few options, we can take the same coin, or any of the others
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x: coins) {
            minHeap.add(getSums(coins,memo,amount-x) + 1);
        }
        memo[amount] = minHeap.poll();
        return memo[amount];
    }
}
