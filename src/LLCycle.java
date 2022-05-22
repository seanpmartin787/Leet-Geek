public class LLCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            while (head != null && head.val != Integer.MIN_VALUE) {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
            return head != null;
        }
    }
}
