// 1019. Next Greater Node In Linked List
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {

        int length = 0;
        ListNode ptr = head;

        if (head.next == null)
            return new int [] {0};

        while(ptr != null) {
            length++;
            ptr = ptr.next;
        }

        ptr = head;
        int []  arr = new int [ length ];
        for (int i = 0; i < length; i++) {
            arr[i] = ptr.val;
            ptr = ptr.next;
        }
        int [] resultArr = new  int [length];

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i])
                    resultArr[j] = arr[i];
            }
        }

        return resultArr;
    }
}
