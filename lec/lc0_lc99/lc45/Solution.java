package lc0_lc99.lc45;

import java.util.Arrays;

class Solution {
    public int jump(int[] num) {
        int n = num.length;
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            method(arr, num, i);
        }

        return arr[n - 1];
    }

    private void method(int[] arr, int[] num, int i) {
        if (arr[i] == Integer.MAX_VALUE) {
            return;
        }
        int cur = num[i];
        for (int j = i+1; j <= i+cur && j < num.length; j++) {
            arr[j] = Math.min(arr[j], arr[i] + 1);
        }
    }
}