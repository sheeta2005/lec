package lc3660;

class Solution {
    public void erFen(int[] nums, int right, int[] res, int[][] prevmax, int min, int max) {
        if (right <= 0) {
            return;
        }
        int nowMax = prevmax[right - 1][0];
        int nowMaxLoc = prevmax[right - 1][1];
        if (nowMax > min) {
            nowMax = max;
        }
        for (int i = nowMaxLoc; i < right; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            res[i] = nowMax;
        }
        right = nowMaxLoc;
        erFen(nums, right, res, prevmax, min, max);
    }

    public int[] maxValue(int[] nums) {
        int[] res = new int[nums.length];
        int[][] prevMax = new int[nums.length][2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                prevMax[i][0] = max;
                prevMax[i][1] = i;
            } else {
                prevMax[i][0] = prevMax[i - 1][0];
                prevMax[i][1] = prevMax[i - 1][1];
            }
        }
        erFen(nums, nums.length, res, prevMax, Integer.MAX_VALUE, prevMax[nums.length - 1][0]);
        return res;
    }
}