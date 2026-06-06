package lc2574;
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int [] prefixL  = new int[n];
        prefixL[0]=nums[0];
        for (int i = 1; i < n; i++) {
            prefixL[i]=nums[i]+prefixL[i-1];
        }

        int [] prefixR  = new int[n];
        prefixR[n-1]=nums[n-1];
        for (int i = n-1; i >=0; i--) {
            prefixR[i]=nums[i]+prefixR[i+1];
        }

        for (int i = 0; i < n; i++) {
            nums[i]=Math.abs(prefixR[i]-prefixL[i]);
        }
        return nums;
    }
}