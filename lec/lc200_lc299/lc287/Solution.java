package lc200_lc299.lc287;

class Solution {
    public int findDuplicate(int[] nums) {
        int pos1 = nums[0];
        int pos2 = nums[nums[0]];
        while (pos1 != pos2) {
            pos1 = nums[pos1];
            pos2 = nums[nums[pos2]];
        }
        pos1 = 0;
        while (pos1 != pos2) {
            pos1 = nums[pos1];
            pos2 = nums[pos2];
        }
        return pos1;
    }
}