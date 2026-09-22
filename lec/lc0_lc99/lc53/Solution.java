//package lc0_lc99.lc53;
//
//public class Solution {
//    public int maxSubArray(int[] nums) {
////贪心
////        int pre = nums[0];
////        int maxSum = nums[0];
////        for (int i = 1; i < nums.length; i++) {
////            pre = Math.max(pre + nums[i], nums[i]);
////            maxSum = Math.max(maxSum, pre);
////        }
////        return maxSum;
////
//
//        //分治
//        return method1(nums, 0, nums.length - 1);
//    }
//
//    private int method1(int[] nums, int left, int right) {
//        if (left>right){return }
//        int cur = (left + (right - left)) / 2;
//        int sumLeft = method1(nums, left, cur-1);
//        int sumRight = method1(nums, cur + 1,right);
//        if (sumLeft > 0) {
//            cur += left;
//        }
//        if (sumRight > 0) {
//            cur += right;
//        }
//        return Math.max(cur,prev);
//    }
//}
