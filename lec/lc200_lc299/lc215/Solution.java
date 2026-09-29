package lc200_lc299.lc215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return method1(nums, k);
    }

    private int method1(int[] nums, int k) {
        int len = nums.length;
        int index = (nums.length - 1) >> 1;
        int cur = nums[index];

        int[] left = new int[len];
        int leftLen = 0;
        int[] right = new int[len];
        int rightLen = 0;

        for (int i = 0; i < len; i++) {
            if (i == index) {
                continue;
            }
            if (nums[i] < cur) {
                left[leftLen++] = nums[i];
            } else {
                right[rightLen++] = nums[i];
            }
        }

        // right是>=pivot的元素，rightLen就是大于等于cur的数量
        if (rightLen == k - 1) {
            return cur;
        } else if (rightLen > k - 1) {
            // 目标在right数组，截取有效部分递归
            int[] newRight = new int[rightLen];
            System.arraycopy(right, 0, newRight, 0, rightLen);
            return method1(newRight, k);
        } else {
            // 目标在left数组，减去右边+pivot这部分
            int[] newLeft = new int[leftLen];
            System.arraycopy(left, 0, newLeft, 0, leftLen);
            return method1(newLeft, k - rightLen - 1);
        }
    }
}
