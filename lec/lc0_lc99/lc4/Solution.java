//package lc0_lc99.lc4;
//
//class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        double res = -1;
//        int left = 0;
//        int right = nums1.length - 1;
//        int len = (nums1.length + nums2.length + 1) / 2;
//        while (true) {
//            int mid = left + ((right - left) >> 1);
//            int len2 = len - mid;
//           // int left1Min = nums1[left];
//            int left1Max = nums1[mid];
//            //int left2Min = nums1[mid];
//            int left2Max = nums2[len2-1];
//            int right1Min = nums1[mid + 1];
//           // int right1Max = nums1[right];
//            int right2Min = nums1[right];
//            //int right2Max = nums1[right];
//
//            if (left1Max<right2Min&&left2Max<right1Min){
//                if (len%2==0){
//                    res=
//
//                }
//                else {
//
//                }
//            }
//
//            //不满足
//            if(){
//
//            }
//            else {
//
//            }
//
//        }
//
//
//        return res;
//    }
//}