import org.junit.Test;

// inspired by: https://leetcode.com/problems/maximum-product-subarray/discuss/48302/2-Passes-scan-beats-99
// 152. Maximum Product Subarray
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, product *= nums[i]);
            if (nums[i] == 0) product = 1;
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(max, product *= nums[i]);
            if (nums[i] == 0) product = 1;
        }
        return max;
    }

    @Test
    public void test() {

        int[] arr = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(arr));

        int[] arr2 = new int[]{-2, 0, -1};
        System.out.println(maxProduct(arr2));

        int[] arr3 = new int[]{-4, -3};
        System.out.println(maxProduct(arr3));

        int[] arr4 = new int[]{-2, 3, -4};
        System.out.println(maxProduct(arr4));

        int[] arr5 = new int[]{0, 2};
        System.out.println(maxProduct(arr5));

        int[] arr6 = {-3, 0, 1, -2};
        System.out.println(maxProduct(arr6));
    }
}
