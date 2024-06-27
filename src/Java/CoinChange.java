import org.junit.Test;

import java.util.Arrays;

// 322. Coin Change
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int [] dp = new int [amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                } else {
                    break;
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }

    @Test
    public void test() {
        int [] coins = new int [] {186,419,83,408};
        System.out.println(coinChange(coins, 6249));
    }

    // inspired from: https://www.youtube.com/watch?v=1R0_7HqNaW0
}
