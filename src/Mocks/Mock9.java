package Mocks;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Mock9 {

    public boolean wordPattern(String pattern, String str) {

        String[] brokenStr = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();

        if (brokenStr.length == pattern.length()) {

            for (int i = 0; i < pattern.length(); i++) {
                if (map.containsKey(pattern.charAt(i))) {

                    if (!brokenStr[i].equals(map.get(pattern.charAt(i)))) {
                        return false;
                    }
                } else {
                    if (!map.values().contains(brokenStr[i]))
                        map.put(pattern.charAt(i), brokenStr[i]);
                    else
                        return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(wordPattern("abba", "dog cat cat dog"));
        assertFalse(wordPattern("abba", "dog dog dog dog"));
        assertFalse(wordPattern("abba", "dog dog dog dog"));
    }


    public int[][] updateMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int top = 0;
                int down = 0;
                int right = 0;
                int left = 0;
                int min = Integer.MAX_VALUE;

                if (matrix[i][j] != 0) {
                    if (i > 0) {
                        top = matrix[i - 1][j];
                        min = Math.min(min, top);
                    }
                    if (i < matrix.length - 1) {
                        down = matrix[i+1][j];
                        min = Math.min(min, down);
                    }
                    if (j > 0) {
                        left = matrix[i][j - 1];
                        min = Math.min(min, left);
                    }
                    if (j < matrix[i].length - 1) {
                        right = matrix[i][j + 1];
                        min = Math.min(min, right);
                    }


                    if (min < Integer.MAX_VALUE)
                        matrix[i][j] += min;
                }

            }
        }

        return matrix;
    }

    @Test
    public void test2() {
        int [][] input = {{0},{1}};
        updateMatrix(input);
    }
}
