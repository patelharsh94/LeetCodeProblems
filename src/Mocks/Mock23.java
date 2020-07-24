package Mocks;

public class Mock23 {

    public int maxProfit(int[] prices) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max < 0 ? 0 : max;
    }


    public int[] productExceptSelf(int[] nums) {

        int [] result = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }
}
