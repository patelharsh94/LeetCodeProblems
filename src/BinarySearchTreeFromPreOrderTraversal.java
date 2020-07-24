import org.junit.Test;


// 1008. Construct Binary Search Tree from Preorder Traversal
public class BinarySearchTreeFromPreOrderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder != null && preorder.length > 0) {

            TreeNode root = new TreeNode(preorder[0]);

            for (int i = 1; i < preorder.length; i++) {
                insertIntoBST(new TreeNode(preorder[i]), root);
            }

            return root;
        }

        return null;
    }

    public void insertIntoBST(TreeNode currNode, TreeNode root) {

        if (currNode.val > root.val && root.right == null)
            root.right = currNode;

        if (currNode.val < root.val && root.left == null)
            root.left = currNode;

        if (currNode.val > root.val) {
            root = root.right;
            insertIntoBST(currNode, root);
        }

        if (currNode.val < root.val) {
            root = root.left;
            insertIntoBST(currNode, root);
        }
    }

    @Test
    public void test() {

        int [] preOrderVals = {8,5,1,7,10,12};
        bstFromPreorder(preOrderVals);

    }

}
