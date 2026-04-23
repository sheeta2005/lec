package lc2615;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> list : map.values()) {
            int m = list.size();
            long[] prefix = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + list.get(i);
            }
            for (int k = 0; k < m; k++) {
                long idx = list.get(k);
                long left = idx * k - prefix[k];
                long right = (prefix[m] - prefix[k + 1]) - idx * (m - k - 1);
                ans[list.get(k)] = left + right;
            }
        }
        return ans;
    }
}