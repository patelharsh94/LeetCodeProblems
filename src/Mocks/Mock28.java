package Mocks;

import org.junit.Test;

import java.util.*;


public class Mock28 {

    public void setZeroes(int[][] matrix) {

        if (matrix.length == 0)
            return;

        if (matrix[0].length == 0)
            return;

        int n = matrix.length;
        int m = matrix[0].length;

        HashMap<Integer, List<Integer>> zeroHash = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    List<Integer> curList = new ArrayList<>();
                    if (zeroHash.containsKey(i)) {
                        curList = zeroHash.get(i);
                        curList.add(j);
                        zeroHash.put(i, curList);
                    } else {
                        curList.add(j);
                        zeroHash.put(i, curList);
                    }
                }
            }
        }

        zeroHash.forEach( (k, v) -> {

            for (int j : v) {
                setRowAndColumnTo0(k, j, matrix);
            }
        });
    }

    private void setRowAndColumnTo0(int i, int j, int [] [] matrix) {

        Arrays.fill(matrix[i], 0);
        for (int a = 0; a < matrix.length; a++) {
            matrix[a][j] = 0;
        }
    }


    @Test
    public void test() {
        int [] [] matrix = {{0, 1, 2, 0}, {3,4,5,2}, {1,3,1,5}};
        printMatrix(matrix);
        setZeroes(matrix);
        printMatrix(matrix);
    }

    private void printMatrix(int [] [] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
// ---------------------------------

    public int myAtoi(String str) {

        if (str != null && str.trim().length() > 0) {
            str = str.trim();
            boolean isNegative = false;
            StringBuilder integerStr = new StringBuilder();
            List<Integer> number = new ArrayList<>();
            int i = 0;

            if (str.charAt(0) == '-') {
                isNegative = true;
                i++;
            }

            if (str.charAt(0) == '+') {
                i++;
            }
            boolean firstDig = false;

            while (i < str.length()) {

                if (str.charAt(i) == '0' && !firstDig) {
                    i++;
                    continue;
                }

                if (Character.isDigit(str.charAt(i))) {
                    number.add(str.charAt(i) - '0');
                    firstDig = true;
                }
                else
                    break;
                i++;
            }

            int finalResult = 0;

            if (number.size() == 0)
                return 0;

            i = 0;

            if (number.size() >= 10 && number.get(0) > 2) {
                finalResult = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                while(i < number.size()) {
                    int futureVal = (number.get(i)) * (int)(Math.pow(10, number.size()-1-i));

                    if (finalResult+futureVal > 0) {
                        finalResult = finalResult+futureVal;
                    } else {
                        if (isNegative)
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                    i++;
                }
            }

            return isNegative ? -1*finalResult : finalResult;
        }

        return 0;
    }

    @Test
    public void testChar() {
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi(" 4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));
        System.out.println(myAtoi("200000000000000000000000000"));
        System.out.println(myAtoi("-6147483648"));
    }
}
