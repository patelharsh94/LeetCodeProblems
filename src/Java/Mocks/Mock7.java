package Mocks;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Mock7 {

    public int[][] flipAndInvertImage(int[][] A) {

        // flip
        for (int i = 0; i < A.length; i++) {
            int a = 0;
            int b = A[i].length-1;
            int temp;
            while (a < b) {
                temp = A[i][a];
                A[i][a] = A[i][b];
                A[i][b] = temp;
                a++;
                b--;
            }
        }

        // invert

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {

                if (A[i][j] == 0)
                    A[i][j] = 1;
                else if (A[i][j] == 1) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }

    ArrayList<Integer> root1Leaves = new ArrayList<>();
    ArrayList<Integer> root2Leaves = new ArrayList<>();

    public void dfs(TreeNode node, boolean isRoot1) {

        if (node == null)
            return;

        if (node.left == null && node.right == null) {

            if (isRoot1) {
                root1Leaves.add(node.val);
            } else {
                root2Leaves.add(node.val);
            }
        }

        dfs(node.left, isRoot1);
        dfs(node.right, isRoot1);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1, true);
        dfs(root2, false);

        return root1Leaves.equals(root2Leaves);
    }


    public String customSortString(String S, String T) {

        StringBuilder finalStr = new StringBuilder();
        StringBuilder t = new StringBuilder(T);

        for (int i = 0; i < S.length(); i++) {
            int a = numOccurance(T, S.charAt(i));
            while (a > 0) {
                finalStr.append(S.charAt(i));
                a--;
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (!S.contains(T.charAt(i) + "")) {
                finalStr.append(T.charAt(i));
            }
        }

        return finalStr.toString();
    }

    public int numOccurance(String T, char c) {
        int numOcc = 0;

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == c)
                numOcc++;
        }

        return numOcc;
    }

    @Test
    public void testCustomSortString() {
        assertEquals(customSortString("kqep", "pekeq"), "kqeep");
    }
}
