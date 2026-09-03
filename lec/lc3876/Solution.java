package lc3876;

class Solution {
    public boolean uniformArray(int[] nums1) {
        //奇-奇=偶；偶-偶=偶；偶-奇=奇；奇-偶=奇；
        boolean res = false;
        boolean a = false;
        boolean b = false;
        int qiCount = 0;
        int ouCount = 0;

        int qiMin = Integer.MAX_VALUE;
        int ouMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0 && nums1[i] < ouMin) {
                ouMin = nums1[i];
            }
            if (nums1[i] % 2 != 0&& nums1[i] < qiMin) {
                qiMin = nums1[i];
            }
        }


        for (int i = 0; i < nums1.length; i++) {
            if (a&&b){
                return res;
            }
            if (nums1[i] % 2 == 0) {
                ouCount++;
                if (nums1[i]-qiMin>=1){
                    qiCount ++;
                }
                else {a=true;}
            }
            if (nums1[i] % 2 != 0) {
                qiCount++;
                if (nums1[i]-qiMin>=1){
                    ouCount ++;
                }
                else {b=true;}
            }
        }
        if (qiCount == nums1.length || ouCount == nums1.length) {
            res = true;
        }

        return res;
    }
}