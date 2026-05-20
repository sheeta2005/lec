package lc2657;

import java.util.HashMap;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int count = 0;
        int[] res = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(A[i], k -> 0);
            map.put(A[i], map.get(A[i]) + 1);
            if (map.get(A[i]) == 2) {
                map.put(A[i], 0);
                count++;
            }
            map.computeIfAbsent(B[i], k -> 0);
            map.put(B[i], map.get(B[i]) + 1);
            if (map.get(B[i]) == 2) {
                map.put(B[i], 0);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}