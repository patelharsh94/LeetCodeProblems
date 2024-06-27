import java.util.*;

public class SortedListToBST {

    List<Integer> values = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        return maptoTree(0, values.size()-1);
    }

    public TreeNode maptoTree(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = maptoTree(left, mid - 1);
        node.right = maptoTree(mid + 1, right);
        return node;

    }

}

