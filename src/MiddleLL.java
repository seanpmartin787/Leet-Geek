public class MiddleLL {
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
        public ListNode middleNode(ListNode head) {
            if (head.next == null) {
                return head;
            } else {
                ListNode slow = head;
                ListNode fast = head;

                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }//end while searching for middle
                if (fast != null) {
                    return slow.next;
                } else {
                    return slow;
                }//else it is even
            }//END else more than 1
        }
}
