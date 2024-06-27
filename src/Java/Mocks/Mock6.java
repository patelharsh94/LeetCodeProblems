package Mocks;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Mock6 {

    public String reverseVowels(String s) {

        StringBuilder vowels = new StringBuilder();
        StringBuilder finalString = new StringBuilder(s);
        ArrayList<Integer> index = new ArrayList<>();

        int i = 0;
        for (char x : s.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'
                    || x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') {
                vowels.append(x);
                index.add(i);
            }
            i++;
        }

        vowels = vowels.reverse();
        i = 0;
        for (int a : index) {
            finalString.replace(a, a + 1, vowels.charAt(i) + "");
            i++;
        }

        return finalString.toString();
    }

    @Test
    public void testReverse() {
        assertEquals(reverseVowels("hello"), "holle");
    }

    ArrayList<Integer> levels = new ArrayList<>();

    public void dfs(TreeNode node, int level) {

        if (node.val > levels.get(level)) {
            levels.set(level, node.val);
        }
        dfs(node.right, level+1);
        dfs(node.left, level+1);
    }

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);

        return levels;
    }

//    public List<Integer> largestValues(TreeNode root) {
//
//        ArrayList<Integer> largestValues = new ArrayList<>();
//        ArrayList<TreeNode> queue = new ArrayList<>();
//
//        queue.add(root);
//        queue.add(new TreeNode(Integer.MIN_VALUE));
//        int max = Integer.MIN_VALUE;
//
//        while (!queue.isEmpty()) {
//            TreeNode currNode = queue.get(0);
//            queue.remove(0);
//
//            if (currNode.val > max) {
//                max = currNode.val;
//            }
//
//            if (!queue.isEmpty() && queue.get(0).val == Integer.MIN_VALUE) {
//                largestValues.add(max);
//                max = Integer.MIN_VALUE;
//                queue.remove(0);
//                queue.add(new TreeNode(Integer.MIN_VALUE));
//            }
//
//            if (currNode.left != null) {
//                queue.add(currNode.left);
//            }
//
//            if (currNode.right != null) {
//                queue.add(currNode.right);
//            }
//
//        }
//        return largestValues;
//    }

    @Test
    public void testingLargestValue() {
        largestValues(new TreeNode(1234));
    }
}
