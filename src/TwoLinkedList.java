public class TwoLinkedList {

//    160. Intersection of Two Linked Lists

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode aPtr = headA;
        ListNode bPtr = headB;

        if (headA == null || headB == null) return null;


        while (aPtr != bPtr) {

            if (aPtr == null) {
                aPtr = headB;
            } else {
                aPtr = aPtr.next;
            }

            if (bPtr == null) {
                bPtr = headA;
            } else {
                bPtr = bPtr.next;
            }
        }

        return aPtr;
    }
}
