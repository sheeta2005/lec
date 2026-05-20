package lc396;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (i * nums[i]);
            sum += nums[i];
        }
        arr[0] = res;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + sum - (n * nums[n - i]);
            res = Math.max(res,arr[i]);
        }

        return res;
    }
}