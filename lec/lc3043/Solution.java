package lc3043;

import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            while (num >= 10) {
                set.add(num);
                num /= 10;
            }
            set.add(num);
        }
        for (int num : arr2) {
            while (num >= 10) {
                if (set.contains(num)) {
                    res = Math.max(res, Integer.toString(num).length());
                }
                num /= 10;
            }
            set.add(num);
        }
        return res;
    }
}