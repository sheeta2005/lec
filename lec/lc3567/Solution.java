package com.sheeta1998.lec.lc3567;

import java.util.Arrays;

public class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m + 1 - k][n + 1 - k];
        for (int i = 0; i < m + 1 - k; i++) {
            for (int j = 0; j < n + 1 - k; j++) {
                int res = Integer.MAX_VALUE;
                int[] ints = new int[k * k];
                int count = 0;
                for (int l = i; l < k + i; l++) {
                    for (int o = j; o < k + j; o++) {
                        ints[count++] = grid[l][o];
                    }
                }
                int[] sortedInts = Arrays.stream(ints).sorted().toArray();
                if (k == 1) {
                    res = 0;
                } else {
                    for (int l = 1; l < k * k; l++) {
                        if (sortedInts[l - 1] != sortedInts[l]) {
                            res = Math.min(res, Math.abs(sortedInts[l] - sortedInts[l-1]));
                        }
                    }
                }
                if (res == Integer.MAX_VALUE) {
                    res = 0;
                }
                ans[i][j] = res;
            }
        }
        return ans;
    }

}
