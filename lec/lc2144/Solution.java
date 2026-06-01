package lc2144;

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        int res = 0;
        Arrays.sort(cost);
        int n = cost.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (count != 2) {
                res += cost[i];
                count++;
            } else {
                count = 0;
            }
        }
        return res;
    }
}