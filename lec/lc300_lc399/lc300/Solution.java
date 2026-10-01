package lc300_lc399.lc300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                tempMax=Math.max(tempMax,dp[j]+1);
                }
            }
            dp[i]=tempMax;
            res=Math.max(res,dp[i]);
        }


        return res;
    }
}