public class RemoveNthNodeLL {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode removeNthFromEnd(ListNode head, int n) {


            ListNode slow = head, fast = head;

            //Fast is n nodes ahead
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }//Progress head

            //progress until fast almost falls off
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            //Slow will be right behind the node to remove
            //so we remove its next from the list
            if (slow == head && fast == null) {
                //first edge case: if slow did not move and fast fell off node to remove is the first one
                return head.next;
            } else if (slow == null || slow.next == null) {
                //second edge case: if slow fell off or if slow is the only node
                return null;
            } else {
                //otherwise we can detatch like normal
                slow.next = slow.next.next;
            }

            return head;
        }
}
