package com.sheeta1998.lec.lc2463;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int n = robot.size();
        int m = factory.length;
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], (long) 1e18);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            int factoryPos = factory[i - 1][0];
            int factoryLimit = factory[i - 1][1];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                long cost = 0;
                for (int k = 1; k <= Math.min(factoryLimit, j); k++) {
                    cost += Math.abs(robot.get(j - k) - factoryPos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + cost);
                }
            }
        }
        return dp[m][n];
    }
}