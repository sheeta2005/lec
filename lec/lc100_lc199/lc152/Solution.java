package lc100_lc199.lc152;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int Max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0) {
                dp[i][0] = Math.max(cur, dp[i - 1][1] * cur);
                dp[i][1] = Math.min(cur, dp[i - 1][0] * cur);
                Max = Math.max(dp[i][0], Max);
            } else {
                dp[i][0] = Math.max(cur, dp[i - 1][0] * cur);
                dp[i][1] = Math.min(cur, dp[i - 1][1] * cur);
                Max = Math.max(dp[i][0], Max);
            }
        }
        return Max;
    }
}