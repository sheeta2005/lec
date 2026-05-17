package lc1306;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int temp = arr[start];
        int n=start + arr[start];
        if (n< arr.length - 1 && arr[n] != -1) {
            arr[start] = -1;
            if (canReach(arr, n)) {
                return true;
            }
            arr[start]=temp;
        }
        int m=start - arr[start];
        if (m > 0 && m< arr.length - 1 && arr[m] != -1) {
            arr[start] = -1;
            if (canReach(arr, m)) {
                return true;
            }
            arr[start]=temp;
        }
        return false;
    }
}
