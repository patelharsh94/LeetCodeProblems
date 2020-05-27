public class BestTimeToBuyStock {
    // 121. Best Time to Buy and Sell Stock

    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > max)
                max = prices[i] - minPrice;
        }

        return max;
    }
}
