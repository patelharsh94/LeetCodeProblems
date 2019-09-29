// Final Working Solution

public class AddTwoNumbers {
    public ListNode output = null;
    public ListNode lastNode = null;

    public void insertIntoList(int val) {

        if(output == null) {
            output = new ListNode(val);
        } else {
            lastNode = output;

            while(lastNode.next != null)
                lastNode = lastNode.next;

            lastNode.next = new ListNode(val);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val = 0;
        int carry = 0;


        while(l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;

            if(val > 9) {
                insertIntoList(val-10);
                carry = 1;
            }
            else {
                insertIntoList(val);
                carry = 0;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 ==  null && l2 != null) {
            while(l2 != null) {
                val = l2.val + carry;
                if (val > 9) {
                    insertIntoList(val-10);
                    carry = 1;
                } else {
                    insertIntoList(val);
                    carry = 0;
                }

                l2 = l2.next;
            }
        } else if (l1 !=  null) {
            while(l1 != null) {
                val = l1.val + carry;
                if (val > 9) {
                    insertIntoList(val-10);
                    carry = 1;
                } else {
                    insertIntoList(val);
                    carry = 0;
                }

                l1 = l1.next;
            }
        }

        if(carry == 1) {
            insertIntoList(carry);
        }

        return output;
    }
}
