package lc560;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] pre = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (pre[i] == k) {
                res++;
            }
            int need = pre[i] - k;
            if (map.containsKey(need)) {
                res += map.get(need);

            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return res;

    }
}

