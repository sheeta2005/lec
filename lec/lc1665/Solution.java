package lc1665;

import java.util.Arrays;


class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (row1, row2) -> {
            return (row2[1] - row2[0]) - (row1[1] - row1[0]);
        });
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            res += tasks[i][0];
        }
        int temp = res;
        for (int i = 0; i < tasks.length; i++) {
            if (temp >= tasks[i][1]) {
                temp -= tasks[i][0];
            } else {
                res += tasks[i][1] - temp;
                temp = tasks[i][1] - tasks[i][0];
            }
        }
        return res;
    }
}