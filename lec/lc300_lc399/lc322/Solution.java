package lc300_lc399.lc322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int value = coins[i];
            if (value <= amount) {
                dp[value] = 1;
            }
            for (int j = value; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - value] + 1);
            }
        }
        if (dp[amount] != Integer.MAX_VALUE - 1) {
            return dp[amount];
        }
        return -1;
    }
}