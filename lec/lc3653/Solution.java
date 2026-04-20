package com.sheeta1998.lec.lc3653;
class Solution {
    final int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int len1 = queries.length;
        for (int i = 0; i < len1; i++) {
            int indexBegin = queries[i][0];
            int indexEnd = queries[i][1];
            int step = queries[i][2];
            int multi = queries[i][3];
            while (indexBegin <= indexEnd) {
                nums[indexBegin] = (int) ((long) multi * nums[indexBegin] % MOD);
                indexBegin += step;
            }
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}