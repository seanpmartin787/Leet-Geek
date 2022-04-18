import javax.swing.text.ElementIterator;

public class MergeLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head;
        if (list1 == null) {
            return list2;
        } else {
            head = list1;
        }
        ListNode temp;


        while (list1 != null  && list2 != null) {
            if (list1.val > list2.val) {
                temp = list2.next;
                list2.next = list1;
                head = list1 = list2;
                list2 = temp;
            } else if (list1.next == null) {
                list1.next = list2;
                break;

            } else if (list1.val == list2.val) {
                temp = list2.next;
                //insert node into list
                list2.next = list1.next;
                list1.next = list2;
                //set list 2 back to the previous next for List 2
                list2 = temp;
            } else if (list1.val < list2.val && list1.next.val > list2.val) {
                temp = list2.next;
                //insert node into list
                list2.next = list1.next;
                list1.next = list2;
                //set list 2 back to the previous next for List 2
                list2 = temp;
            } else {
                list1 = list1.next;
            }
        }
        return head;
    }
}
