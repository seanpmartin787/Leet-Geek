public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        // base case
        if(head == null || head.next == null) return head;

        //DFS return last non null node (tail) through function calls
        ListNode tail = reverseList(head.next);

        //once we are coming back out of the recursion we can flip the next node to point at the current
        head.next.next = head;
        //We then set the current nodes next to null, which will either set the new tail to null
        //or it will get cleaned up by the next level of recursion
        head.next = null;

        return tail;
    }
}
