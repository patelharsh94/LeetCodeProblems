package Mocks;
import org.junit.Test;

import java.util.*;

public class Mock33 {

    public boolean isTargetAvailable = false;

    public boolean findTarget(TreeNode root, int k) {
        isTargetAvailable(root, k, new ArrayList<>());
        return isTargetAvailable;
    }

    public void isTargetAvailable(TreeNode root, int k, List<Integer> prevNums) {

        if (root != null) {

            if (prevNums.contains(k - root.val)) {
                isTargetAvailable = true;
            } else {
                prevNums.add(root.val);
            }

            isTargetAvailable(root.left, k, prevNums);
            isTargetAvailable(root.right, k, prevNums);
        }
    }

    @Test
    public void test1() {
//        TreeNode t1 = new TreeNode(5);
//        TreeNode t2 = new TreeNode(3);
//        TreeNode t3 = new TreeNode(6);
//        TreeNode t4 = new TreeNode(2);
//        TreeNode t5 = new TreeNode(4);
//        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        findTarget(t1, 1);
    }

    public String gcdOfStrings(String str1, String str2) {
        int n = str2.length();
        while (n >= 1) {
            if (str1.length() % n == 0 && str2.length() % n == 0) {
                String sub = str2.substring(0, n);
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < str1.length() / n; i++) {
                    sb1.append(sub);
                }
                for (int i = 0; i < str2.length() / n; i++) {
                    sb2.append(sub);
                }
                if (sb1.toString().equals(str1) && sb2.toString().equals(str2)) {
                    return sub;
                }
            }
            n--;

        }
        return "";
    }

    @Test
    public void test2() {
        gcdOfStrings("ABCACBABCAC",
                "ABC");
    }
}
