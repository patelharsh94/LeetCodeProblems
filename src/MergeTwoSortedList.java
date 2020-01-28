// 21. Merge Two Sorted Lists
public class MergeTwoSortedList {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode low;
        ListNode high;
        ListNode temp;

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            low = l1;
            high = l2;
        } else {
            low = l2;
            high = l1;
        }

        ListNode finalList = low;

        while (low.next != null) {

            while (low.next != null && low.next.val <= high.val) {
                low = low.next;
            }

            if (low.next != null) {
                temp = low.next;
                low.next = high;
                high = temp;
            }

        }

        low.next = high;

        return finalList;
    }
}
