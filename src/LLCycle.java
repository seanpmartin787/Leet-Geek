import java.util.HashSet;
import java.util.List;

public class LLCycle {
        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }
        public boolean hasCycle(ListNode head) {
            while (head != null && head.val != Integer.MIN_VALUE) {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
            return head != null;
        }

        public boolean hasCycleSet(ListNode head) {
            HashSet<ListNode> seen = new HashSet<>();
            while (head != null && !seen.contains(head)) {
                seen.add(head);
                head = head.next;
            }
            return head != null;
        }
        public boolean hasCycleTwoPointer(ListNode head) {
            if(head==null) return false;
            ListNode walker = head;
            ListNode runner = head;
            while(runner.next!=null && runner.next.next!=null) {
                walker = walker.next;
                runner = runner.next.next;
                if(walker==runner) return true;
            }
            return false;
        }
}
