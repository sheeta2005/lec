package com.sheeta1998.lec.lc1594;

public class Solution {
    public static int maxProductPath(int[][] grid) {
        final int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;


        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];


        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];


        for (int j = 1; j < n; j++) {
            maxDp[0][j] = maxDp[0][j - 1] * grid[0][j];
            minDp[0][j] = minDp[0][j - 1] * grid[0][j];
        }


        for (int i = 1; i < m; i++) {
            maxDp[i][0] = maxDp[i - 1][0] * grid[i][0];
            minDp[i][0] = minDp[i - 1][0] * grid[i][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                long upMax = maxDp[i - 1][j] * grid[i][j];
                long upMin = minDp[i - 1][j] * grid[i][j];
                long leftMax = maxDp[i][j - 1] * grid[i][j];
                long leftMin = minDp[i][j - 1] * grid[i][j];


                maxDp[i][j] = Math.max(Math.max(upMax, upMin), Math.max(leftMax, leftMin));
                minDp[i][j] = Math.min(Math.min(upMax, upMin), Math.min(leftMax, leftMin));
            }
        }


        long finalMax = maxDp[m - 1][n - 1];
        if (finalMax < 0) {
            return -1;
        } else {
            return (int) (finalMax % MOD);
        }
    }
}



