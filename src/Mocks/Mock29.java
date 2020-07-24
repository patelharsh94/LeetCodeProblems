package Mocks;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class Mock29 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersection = new HashSet<>();
        HashSet<Integer> nums1Set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i]))
                intersection.add(nums2[i]);
        }

        int[] inter = new int[intersection.size()];
        int b = 0;

        Iterator<Integer> intersectionIterator = intersection.iterator();

        while (intersectionIterator.hasNext()) {
            inter[b] = intersectionIterator.next();
            b++;
        }
        return inter;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        intersection(nums1, nums2);
    }

    TreeNode deepestNode = null;
    int maxLevel = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deepestNode = root;
        findDeepestNode(root, 0);
        return deepestNode;
    }

//    private TreeNode findDeepestRootNode(TreeNode root) {
//
//        if (root != null) {
//            if (root.left != null && root.left.val == deepestNode.val && root.right != null) {
//                return root;
//            }
//
//            if (root.right != null && root.right.val == deepestNode.val && root.left != null) {
//                return root;
//            }
//
//            if (root == deepestNode){
//                return root;
//            }
//
//            if (root.left != null) {
//                findDeepestRootNode(root.left);
//            }
//
//            if (root.right != null) {
//                findDeepestRootNode(root.right);
//            }
//        }
//
//    }
    private void findDeepestNode(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (level >= maxLevel) {
            maxLevel = level;

            if (root.left != null && root.right != null) {
                deepestNode = root;
            }

            if (root.left == null && root.right != null)
                deepestNode = root.right;

            if (root.right == null && root.left != null)
                deepestNode = root.left;
        }

        if (root.left != null) {
            findDeepestNode(root.left, level+1);
        }
        if (root.right != null) {
            findDeepestNode(root.right, level+1);
        }
        return;
    }

    @Test
    public void test2() {

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        three.left = five;
        three.right = one;

        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);

        five.left = six;
        five.right = two;
        one.left = zero;
        one.right = eight;

        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        two.left = seven;
        two.right = four;

        System.out.println(subtreeWithAllDeepest(three).val);
    }
}
