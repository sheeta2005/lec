package lc0_lc99.lc33;

class Try {
    public int search(int[] nums, int target) {
        int[] res = {-1};

        method1(nums, target, 0, nums.length - 1, res);
        return res[0];
    }

    private void method1(int[] nums, int target, int left, int right, int[] res) {
        int mid = left + ((right - left) >> 1);
        int curNum = nums[mid];
        if (target == curNum) {
            res[0] = mid;
            return;
        }
        if (mid>0){
            int prev = nums[mid-1];
            //右半部有序
            if (curNum<prev){

            }
        }
        if (mid<nums.length-1){
            int next = nums[mid+1];
            //左半部有序
            if (curNum>next){

            }
        }
//
//        if (target > curNum) {
//            method1(nums, target, mid + 1, right, res);
//        } else {
//            method1(nums, target, left, mid - 1, res);
//        }
    }
}