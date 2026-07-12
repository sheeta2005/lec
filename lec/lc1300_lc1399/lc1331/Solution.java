package lc1300_lc1399.lc1331;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i : copy) {
            if (map.containsKey(i)) {
                continue;
            } else {
                map.put(i, count++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}