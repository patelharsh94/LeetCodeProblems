package Mocks;

import org.junit.Test;

import java.util.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Mock17 {


    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    @Test
    public void test() {
        reverseBits(13);
    }

    public int uniquePaths(int m, int n) {

        Queue<int[]> indexQueue = new PriorityQueue<>();

        int totalPaths = 0;

        indexQueue.add(new int[]{0, 0});

        while (!indexQueue.isEmpty()) {

            int[] currIndex = indexQueue.poll();
            int[] rightIndex;
            int[] downIndex;

            if (currIndex[0] == m - 1 && currIndex[1] == n - 1)
                totalPaths++;

            if (currIndex[0] < n) {
                rightIndex = new int[]{currIndex[0] + 1, currIndex[1]};
            } else {
                rightIndex = new int[]{currIndex[0], currIndex[1]};
            }
            if (currIndex[1] < m) {
                downIndex = new int[]{currIndex[0], currIndex[1] + 1};
            } else {
                downIndex = new int[]{currIndex[0], currIndex[1]};
            }

            indexQueue.add(rightIndex);
            indexQueue.add(downIndex);
        }

        return totalPaths;
    }

    @Test
    public void test2() {
        uniquePaths(3, 2);
    }


    public int maxPoints(int[][] points) {

        HashMap<Integer, Integer> slopeCount = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p2[1] - p1[1] != 0 && p2[0] - p1[0] != 0) {

                    int slope = Math.abs(p2[0] - p1[0]) / Math.abs(p2[1] - p1[1]);
                    slopeCount.merge(slope, 1, (a, b) -> a + b);
                }
            }
        }

        int max;

        List<Integer> vals = new ArrayList<>(slopeCount.values());

        max = vals.stream().mapToInt(i -> i).filter(i -> i >= 0).max().orElse(0);


        return max;
    }

    @Test
    public void test3() {
        int [] []  arr = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(arr));
    }

}
