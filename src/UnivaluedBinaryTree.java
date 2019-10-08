class BinaryTreeNode {
      int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int x) { val = x; }
}

// 965. Univalued Binary Tree
public class UnivaluedBinaryTree {

    public boolean traverse(BinaryTreeNode root, int previousNodeValue) {
        if (root == null)
            return true;
        if (root.val != previousNodeValue)
            return false;

        return traverse(root.left, root.val) &&  traverse(root.right, root.val);
    }

    public boolean isUnivalTree(BinaryTreeNode root) {
        return traverse(root, root.val);
    }
}
