package lc1340;

import java.util.Arrays;


public class Solution {
    int jump(int[] arr, int[] dp, int i, int d) {
        if (dp[i] != -1) return dp[i];
        int res = 1;
        int right = Math.min(arr.length - 1, i + d);
        int left = Math.max(0, i - d);
        // 向左跳
        for (int j = i - 1; j >= left; j--) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, jump(arr, dp, j, d) + 1);
        }
        // 向右跳
        for (int j = i + 1; j <= right; j++) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, jump(arr, dp, j, d) + 1);
        }
        dp[i] = res;
        return res;
    }

    public int maxJumps(int[] arr, int d) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, jump(arr, dp, i, d));
        }
        return res;
    }
}
