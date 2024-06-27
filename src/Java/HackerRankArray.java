import org.junit.Test;

import java.util.regex.Matcher;

public class HackerRankArray {

    static int hourglassSum(int[][] arr) {

        int maxCost = Integer.MIN_VALUE;
        for (int i = 0; i + 2 < arr.length; i++) {
            for (int j = 0; j + 2 < arr[0].length; j++) {
                int totalCost = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
                        + arr[i+2][j+2];
                System.out.println(arr[i][j] + " " + arr[i][j+1] + " " + arr[i][j+2] + "\n"
                        + " " + arr[i+1][j+1] + "\n"
                        + arr[i+2][j] + " " + arr[i+2][j+1] + " " +arr[i+2][j+2]);
                System.out.println();
                if (totalCost > maxCost) {
                    maxCost = totalCost;
                }
            }
        }

        return maxCost;
    }

    @Test
    public void testHourGlass() {
        int [] [] arr =
                        {{0, -4, -6, 0, -7, -6},
                        {-1, -2, -6, -8, -3, -1},
                        {-8, -4, -2, -8, -8, -6},
                        {-3, -1, -2, -5, -7, -4},
                        {-3, -5, -3, -6, -6, -6},
                        {-3, -6, 0, -8, -6, -7}};
        System.out.println(hourglassSum(arr));
    }

    static void minimumBribes(int[] q) {
        int totalBribes = 0;
        int start = q[0];

        for (int i = 0; i < q.length-1; i++) {

            if (start + i != q[i]) {
                totalBribes++;
            }

        }
        if (totalBribes > 2) {
            System.out.println(totalBribes);
            System.out.println("Too chaotic");
        } else {
            System.out.println(totalBribes);
        }
    }

    @Test
    public void minimumBribesTest() {
        int [] q = {2, 1, 5, 3, 4};
        minimumBribes(q);
    }

    static long arrayManipulation(int n, int[][] queries) {

        long [] arr = new long[n];
        long maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < queries.length; i++) {

            int a = queries[i][0]-1;
            int b = queries[i][1];
            int k = queries[i][2];

            arr[a] += k;
            arr[b] -= k;

        }

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxNum = Math.max(sum, maxNum);
        }

        return maxNum;
    }


        @Test
    public void testArrayManipulation() {

        int [] [] arr = { {2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}};
        arrayManipulation(10, arr);

    }
}
