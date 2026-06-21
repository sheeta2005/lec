package lec.lc1848;

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = 999999999;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(start - i));
            }
        }
        for (int i = start; i >= 0; i--) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(start - i));
            }
        }
        return ans;
    }
}