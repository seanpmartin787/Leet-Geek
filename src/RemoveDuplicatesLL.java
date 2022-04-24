public class RemoveDuplicatesLL {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = slow.next;

            if (slow.next.val != fast.next.val) {
                //nothing to do continue traversing
                slow = slow.next;
            } else {
                //find the matches
                while (fast != null && slow.next.val == fast.val) {
                    fast = fast.next;
                }
                if ((slow == head || slow.next == head ) && fast != null) {
                    head = fast; //if slow is the first node
                    slow.next = head;
                } else if (fast == null && slow.next == head) {
                    return null;
                } else {
                    slow.next = fast; //remove them from the list
                }
            }
        }
        return head;
    }
}
