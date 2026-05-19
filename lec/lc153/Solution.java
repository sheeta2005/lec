package lc153;

class Solution {
    int binary(int[] arr, int left, int right) {
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public int findMin(int[] nums) {
        return binary(nums, 0, nums.length-1);
    }
}