package Mocks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Mock8 {

    public int dfs(TreeNode node, int total, boolean isLeft) {

        if (node == null)
            return total;

        if (node.left == null && node.right == null && isLeft) {
            total += node.val;
        }

        return (dfs(node.left, total, true) + dfs(node.right, total, false));
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, 0,false)/2;
    }

    @Test
    public void testingSumOfLeaves() {
        TreeNode root = new TreeNode(3);
        TreeNode L1L = new TreeNode(9, null, null);
        TreeNode L1R = new TreeNode(20);
        TreeNode L2L = new TreeNode(15, null, null);
        TreeNode L2R = new TreeNode(7, null, null);

        L1R.right = L2R;
        L1R.left = L2L;
        root.left = L1L;
        root.right = L1R;

        assertEquals(sumOfLeftLeaves(root), 24);
    }

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    @Test
    public void testingMinCostClimbingStairs() {
        assertEquals(minCostClimbingStairs(new int [] {10, 15, 20}), 15);
        assertEquals(minCostClimbingStairs(new int [] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}), 6);
    }
}
