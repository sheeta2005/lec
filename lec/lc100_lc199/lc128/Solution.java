package lc100_lc199.lc128;

import java.util.HashMap;


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int len = left + right + 1;
                map.put(num, len);
                map.put(num - left, len);
                map.put(num + right, len);
                res = Math.max(res, len);
            }
        }
        return res;
    }
}