package lc100_lc199.lc153;

public class Try {
    public int findMin(int[] nums) {

        int[] res = {Integer.MAX_VALUE};
        method(nums, res, 0, nums.length - 1);
        return res[0];
    }

    private void method(int[] nums, int[] res, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        int cur = nums[mid];
        if (cur < res[0]) {
            res[0] = cur;
        }
        if (cur > nums[right]) {
            //最小值在右边
            method(nums, res, mid + 1, right);
        } else {
            //最小值在左边，包含mid
            method(nums, res, left, mid - 1);
        }
    }
}
