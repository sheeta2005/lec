package lc0_lc99.lc34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target, 0, nums.length-1);
        int right = findRight(nums, target, 0, nums.length-1);
        if(left > right){
            return new int[]{-1,-1};
        }
        return new int[]{left, right};
    }
    // 找左边界
    private int findLeft(int[] nums, int target, int l, int r){
        if(l > r) return l;
        int mid = l + ((r - l) >> 1);
        if(nums[mid] >= target){
            return findLeft(nums, target, l, mid -1);
        }else{
            return findLeft(nums, target, mid + 1, r);
        }
    }
    // 找右边界
    private int findRight(int[] nums, int target, int l, int r){
        if(l > r) return r;
        int mid = l + ((r - l) >> 1);
        if(nums[mid] <= target){
            return findRight(nums, target, mid +1, r);
        }else{
            return findRight(nums, target, l, mid -1);
        }
    }
}
