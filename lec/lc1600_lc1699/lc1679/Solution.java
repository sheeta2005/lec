package lc1600_lc1699.lc1679;

import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int target = k - num;
            int count = map.getOrDefault(target, 0);
            if (count > 0) {
                res++;
                map.put(target, count - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}