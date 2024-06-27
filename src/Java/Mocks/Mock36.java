package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock36  {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        ListNode ans = null;


        while (l1 != null) {
            one.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            two.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        int intOne = one.size()-1;
        int intTwo = two.size()-1;

        for (int i = Math.max(one.size(), two.size())-1; i >= 0 ; i--) {
            int valOne = 0, valTwo = 0;

            if (intOne >= 0) {
                valOne = one.get(intOne);
                intOne --;
            }

            if (intTwo >= 0) {
                valTwo = two.get(intTwo);
                intTwo--;
            }

            int total = (valOne + valTwo + carry) % 10;

            if (valOne + valTwo + carry >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(total);
            if (ans == null) {
                ans = newNode;
            } else {

                newNode.next = ans;
            }

            ans = newNode;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = ans;
            ans = node;
        }
        return ans;
    }


    @Test
    public void test() {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(7);

        d.next = c;
        c.next = b;
        b.next = a;

        addTwoNumbers(d, e);
    }
}
