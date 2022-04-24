public class RemoveDuplicatesLL {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = new ListNode(Integer.MIN_VALUE, head);
        ListNode fast = head;

        while (slow.next != null && slow.next.next != null) {
            fast = slow.next;

            if (slow.next.val != fast.next.val) {
                //nothing to do continue traversing
                slow = slow.next;
            } else {
                //find the matches
                while (fast != null && slow.next.val == fast.val) {
                    fast = fast.next;
                }
                if (slow.next == head) {
                    head = fast;
                }
                slow.next = fast;
            }
        }
        return head;
    }
}