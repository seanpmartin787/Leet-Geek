import java.util.PriorityQueue;

public class SquareSortedArray {
    class Solution {


        public int[] sortedSquares(int[] nums) {

            PriorityQueue<Integer> sortedQ = new PriorityQueue<>();

            for (int num : nums) {
                sortedQ.add(num * num);
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sortedQ.poll();
            }

            return nums;
        }
    }
}
