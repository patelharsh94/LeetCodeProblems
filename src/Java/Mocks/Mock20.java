package Mocks;

import com.sun.source.tree.Tree;
import org.junit.Test;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Mock20 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode temp = head;

        while (temp != null && temp.val == val) {
            temp = temp.next;
        }

        head = temp;
        temp = head;


        while (temp != null) {

            System.out.println(temp.val);


            if (temp.next != null && temp.next.val == val) {

                ListNode skipper = temp.next;

                while (skipper != null && skipper.val == val) {
                    skipper = skipper.next;
                }
                temp.next = skipper;
            }

            temp = temp.next;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode();

        head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);

        removeElements(head, 6);
    }



    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void dfs (TreeNode root, TreeNode list) {

        if (root == null)
            return;

        TreeNode curNode = new TreeNode(root.val);
        list.right = curNode;

        dfs(root.left, curNode);
        dfs(root.right, curNode);
    }

    @Test
    public void test2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);


        two.left = three;
        two.right = four;
        five.right = six;
        one.left = two;
        one.right = five;

        flatten(one);
    }
}
