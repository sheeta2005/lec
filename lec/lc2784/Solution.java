package lc2784;

import java.util.Arrays;


class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] arr = new int[n];

        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = nums[i] - nums[i - 1];
        }
        if (arr[n - 1] != 0) {
            return false;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 1) {
                return false;
            }
        }
        return true;
    }
}