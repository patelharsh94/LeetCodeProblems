
import java.util.ArrayList;
import java.util.List;

// 102. Binary Tree Level Order Traversal
public class LevelOrderTraversalOfBinaryTree {

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


            levelOrderHelper(root.left, level + 1, result);
            levelOrderHelper(root.right, level + 1, result);
        }
    }

}
