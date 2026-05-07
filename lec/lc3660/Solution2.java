package lc3660;

import java.util.Arrays;

public class Solution2 {

    public int jump(int[] nums, int i, int[] mark, int res, int[] maxx) {
        if (maxx[i] != 0) {
            return maxx[i];
        }
        mark[i] = 1;
        for (int j = 0; j < nums.length; j++) {
            if (mark[j] == 0 && i < j && nums[i] > nums[j]) {
                mark[j] = 1;
                int nextMax = jump(nums, j, mark, res, maxx);
                res = Math.max(res, nextMax);
            }
            if (mark[j] == 0 && i > j && nums[i] < nums[j]) {
                res = Math.max(res, nums[j]);
                mark[j] = 1;
                int nextMax = jump(nums, j, mark, res, maxx);
                res = Math.max(res, nextMax);
            }
        }
        return res;
    }

    public void erFen(int[] nums, int right, int[] res) {
        if (right <= 0) {
            return;
        }
        int max = -1;
        int maxLoc = 0;
        for (int i = 0; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxLoc = i;
            }
        }
        if (right - maxLoc == 1) {
            return;
        }
        for (int i = maxLoc; i < right; i++) {
            res[i] = max;
        }
        erFen(nums, maxLoc, res);
    }

    public int[] maxValue(int[] nums) {
        int[] res = new int[nums.length];
        erFen(nums, nums.length, res);
        for (int num:res){
            System.out.println(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int[] mark = new int[nums.length];
            Arrays.fill(mark, 0);
            res[i] = jump(nums, i, mark, nums[i], res);
        }

        return res;
    }
}
