public class MergeLL {

//    Definition for singly-linked list.
public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode temp = null;

        return head;

        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {

                temp = list2.next;
                list2.next = list1.next.next;
                list1.next = list2;
            }


        }
    }
}
