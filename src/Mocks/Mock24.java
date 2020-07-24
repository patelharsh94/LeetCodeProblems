package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock24 {

    public boolean hasCycle(ListNode head) {

        List<ListNode> nodeList = new ArrayList<>();

        while (head != null) {

            if (nodeList.contains(head))
                return true;
            else
                nodeList.add(head);

            head = head.next;
        }

        return false;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode nodeToDelete = findNodeToDelete(root, key);

        if (nodeToDelete != null) {
            nodeToDelete.val = nodeToDelete.right.val;
            deleteFoundNode(nodeToDelete);
        }

        return null;
    }

    public void deleteFoundNode(TreeNode root) {

        if (root.left == null && root.right == null) {
            root = null;
        } else {

            if (root.left != null)
                deleteFoundNode(root.left);

            if (root.right != null)
                deleteFoundNode(root.right);
        }
    }

    public TreeNode findNodeToDelete (TreeNode root, int key) {

        if (root != null && root.val == key)
            return root;

        if (root != null) {
            if (root.left != null)
                findNodeToDelete(root.left, key);
            if (root.right != null)
                findNodeToDelete(root.right, key);
        }

        return null;
    }

    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }


    @Test
    public void test() {
        String s = "3+2*4-1";
        calculate(s);
    }
}
