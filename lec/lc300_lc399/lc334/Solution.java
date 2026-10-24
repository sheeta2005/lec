package lc300_lc399.lc334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min2) {
                return true;
            } else if (nums[i] <= min1) {
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }

        }
        return false;
    }
}