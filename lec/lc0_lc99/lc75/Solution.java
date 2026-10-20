package lc0_lc99.lc75;

class Solution {
    public void sortColors(int[] nums) {
        int countLeft = 0;
        int countRight = nums.length - 1;
        for (int i = 0; i <= countRight; i++) {
            if (nums[i]==0){
                swap(i,countLeft,nums);
                countLeft++;
            }
            else if (nums[i]==2){
                swap(i,countRight, nums);
                countRight--;
                i--;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}