package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock22 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            result.add(new ArrayList<>());
            levelOrderHelper(root, 0, result);
        }

        return result;
    }

    public void levelOrderHelper(TreeNode root, int level, List<List<Integer>> result) {

        if (root != null) {
            if (result.size() <= level)
                result.add(new ArrayList<>());

            if (result.size() >= level) {
                result.get(level).add(root.val);
            }



            levelOrderHelper(root.left, level+1, result);
            levelOrderHelper(root.right, level+1, result);
        }

    }


    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = null;
        one.right = two;
//        two.left = four;
//        two.right = null;
//        three.left = null;
//        three.right = five;

        levelOrder(one);
    }
}
