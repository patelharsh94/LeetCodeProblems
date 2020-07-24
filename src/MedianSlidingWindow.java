import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double [] results = new double[nums.length - k + 1];
        long [] medianArr = new long [k];
        int mid = k / 2;

        int a;
        int b = 0;

        for (int i = 0; i <= nums.length - k; i++) {
            a = 0;
            for (int j = i; j < i + k; j++) {
               medianArr[a] = nums[j];
               a++;
            }
            Arrays.sort(medianArr);
            results[b] = k % 2 != 0 ? medianArr[mid] : (double) (medianArr[mid-1] + medianArr[mid])/2 ;
            b++;
        }

        return results;
    }


    @Test
    public void evenNumsSizeOddK () {
        int [] nums = new int [] {1,3,-1,-3,5,3,6,7};

        double [] answer = new double [] {1,-1,-1,3,5,6};

        int k = 3;
        assertArrayEquals(medianSlidingWindow(nums, k), answer, .00001);
    }

    @Test
    public void evenNumsSizeEvenK () {
        int [] nums = new int [] {1,3,-1,-3,5,3,6,7};

        double [] answer = new double [] {2, 1, -2, 1, 4, 4.5, 6.5};

        int k = 2;
        assertArrayEquals(medianSlidingWindow(nums, k), answer, .00001);
    }

    @Test
    public void veryLargeNumbersEvenK() {
        int [] nums = new int [] {2147483647,2147483647};

        double [] answer = new double [] {2147483647.00000};

        int k = 2;
        assertArrayEquals(medianSlidingWindow(nums, k), answer, .00001);
    }
}
