import org.junit.Test;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int depthR = 0;
        int depthL = 0;

        if (root != null) {
            depthR = findDepth(root.left, 0);
            depthL = findDepth(root.right, 0);
            return depthL + depthR + 1;
        }

        return 0;
    }

    private int findDepth(TreeNode root, int depth) {

        if (root == null || (root.left == null && root.right == null))
            return depth;

        if (root.left != null) {
            depth += 1;
            findDepth(root.left, depth);
        }
        if (root.right != null) {
            depth += 1;
            findDepth(root.right, depth);
        }

        return depth;
    }

    @Test
    public void test1() {

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

        System.out.println(diameterOfBinaryTree(three));
    }
}
