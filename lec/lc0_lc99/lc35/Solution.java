package lc0_lc99.lc35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int[] res = {-1};
        method1(res, nums, target, 0, nums.length - 1);
        return res[0];
    }


    private void method1(int[] res, int[] nums, int target, int left, int right) {
        if (left > right) {
            res[0] = left;
            return;
        }
        int mid = left + ((right - left) >> 1);
        int cur = nums[mid];
        if (cur == target) {
            res[0] = mid;
            return;
        }
        if (cur > target) {
            method1(res, nums, target, left, mid - 1);
        } else {
            method1(res, nums, target, mid + 1, right);
        }

    }


}