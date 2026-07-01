package lc0_lc99.lc56;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        int index = 0;
        boolean flag = true;
        for (int i = 1; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                if (intervals[i][1] > right) {
                    right = intervals[i][1];
                }
            } else {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});


        int[][] res1 = res.toArray(new int[0][]);
        return res1;
    }
}