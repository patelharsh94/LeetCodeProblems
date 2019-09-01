// #112 : find if the tree has nodes whose value adds up to the number given.

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x;}
}

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        if (root.right == null && root.left == null && root.val == sum) return true;

        if (root.right != null)
            root.right.val += root.val;
        if(root.left != null)
            root.left.val += root.val;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
