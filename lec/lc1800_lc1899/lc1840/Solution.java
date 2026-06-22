package lc1800_lc1899.lc1840;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions == null || restrictions.length == 0) {
            return n - 1;
        }
        Arrays.sort(restrictions, Comparator.comparingInt(a -> a[0]));
        int m = restrictions.length;
        int prevIdx = 1;
        int prevH = 0;
        for (int i = 0; i < m; i++) {
            int idx = restrictions[i][0];
            int limit = restrictions[i][1];

            int maxCan = prevH + (idx - prevIdx);

            restrictions[i][1] = Math.min(limit, maxCan);
            prevIdx = idx;
            prevH = restrictions[i][1];
        }
        prevIdx = n;
        prevH = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            int idx = restrictions[i][0];
            int limit = restrictions[i][1];
            int maxCan = prevH + (prevIdx - idx);
            restrictions[i][1] = Math.min(limit, maxCan);
            prevIdx = idx;
            prevH = restrictions[i][1];
        }
        int res = 0;
        prevIdx = 1;
        prevH = 0;
        for (int i = 0; i < m; i++) {
            int curIdx = restrictions[i][0];
            int curH = restrictions[i][1];
            int dist = curIdx - prevIdx;
            int midMax = (dist + prevH + curH) / 2;
            res = Math.max(res, midMax);
            prevIdx = curIdx;
            prevH = curH;
        }
        res = Math.max(res, prevH + (n - prevIdx));
        return res;
    }
}