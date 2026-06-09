package lc3600_lc3699.lc3689;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long res = 0L;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        long i = (max - min);
        res = i *k;
        return res;
    }
}