package Mocks;

import org.junit.Test;

public class Mock38 {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++)  {
            for (int j = i+1; j < nums.length; j++) {

                if (nums[i]+nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        if (N > 14) N = 1 + (N-1) % 14;
        for (int i = 0; i < N; i++) {
            int [] curr = new int [cells.length];

            for (int j = 1; j < 7; j++) {

                if (cells[j-1] == cells[j+1]) {
                    curr[j] = 1;
                } else {
                    curr[j] = 0;
                }

            }
            curr[0] = 0;
            curr[7] = 0;

            cells = curr;
        }

        return cells;
    }

    @Test
    public void test() {
        int [] ans = prisonAfterNDays(new int [] {0, 1, 0, 1, 1, 0, 0, 1}, 7);

        for (int i : ans) {
            System.out.println(i);
        }
    }
}
