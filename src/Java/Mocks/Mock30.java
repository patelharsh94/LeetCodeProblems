package Mocks;

import org.junit.Test;

import java.util.*;

public class Mock30 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> finalResult = new ArrayList<>();


        for (int i = 1; i <= numRows; i++) {

            List<Integer> currRow = new ArrayList<>();

            if (i == 1) {

                currRow.add(i);

            } else if (i == 2) {

                currRow.add(1);
                currRow.add(1);

            } else {

                int finalSize = finalResult.get(i - 2).size();
                List<Integer> prevList = finalResult.get(i - 2);
                for (int a = 0; a <= finalSize; a++) {
                    if (a == 0 || a == finalSize) {
                        currRow.add(1);
                    } else {
                        currRow.add(prevList.get(a) + prevList.get(a - 1));
                    }
                }
            }
            finalResult.add(currRow);
        }

        return finalResult;
    }

    @Test
    public void generate() {
        System.out.println(this.generate(5));
    }


    public int widthOfBinaryTree(TreeNode root) {

        List<Integer> levelSize = new ArrayList<>();
        levelSize.add(0,0);
        traverse(0, levelSize, root);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < levelSize.size(); i++) {
            if (levelSize.get(i) > max) {
                max = levelSize.get(i);
            }
        }

        return max;
    }

    public void traverse(int level, List<Integer> levelSize, TreeNode node) {

        levelSize.add(level, levelSize.get(level)+1);

        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            traverse(level+1, levelSize, node.left);
            traverse(level+1, levelSize, node.right);
        } else if (node.left != null){
            traverse(level+1, levelSize, node.left);
        } else if (node.right != null) {
            traverse(level+1, levelSize, node.right);
        }


    }
}

