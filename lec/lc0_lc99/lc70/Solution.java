package lc0_lc99.lc70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        for (int i = 2; i < n; i++) {
            dp(arr, n, i);
        }
        return arr[n - 1];
    }

    private void dp(int[] arr, int n, int cur) {
        arr[cur] = arr[cur - 1] + arr[cur - 2] ;
    }


}