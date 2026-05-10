package lc2770;

import java.util.Arrays;

class Solution {


    public void dp(int[] nums, int[] dp, int index, int target) {
        if (index == 0) {
            return;
        }
        if (dp[index] != Integer.MIN_VALUE) {
            for (int i = 0; i < index; i++) {
                int a = nums[index] - nums[i];
                if (a <= target && a >= -target) {
                    dp[i] = dp[index] + 1 > dp[i] ? dp[index ]+1 : dp[i];
                }
            }
        }
        dp(nums, dp, index - 1, target);
    }

    public int maximumJumps(int[] nums, int target) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[nums.length - 1] = 0;
        dp(nums, dp, nums.length - 1, target);
        res = dp[0];
        if (res == Integer.MIN_VALUE) return -1;
        else
            return res;
    }
}