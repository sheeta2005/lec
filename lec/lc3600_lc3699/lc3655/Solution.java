package com.sheeta1998.lec.lc3655;

class Solution {
    final int MOD = 1000000007;

    private long qpow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n) + 1;
        java.util.Map<Long, java.util.Map<Integer, Long>> groups = new java.util.HashMap<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            long val = v % MOD;
            if (k > B) {
                int idx = l;
                while (idx <= r) {
                    nums[idx] = (int) ((long) nums[idx] * val % MOD);
                    idx += k;
                }
            } else {
                int rem = l % k;
                long groupKey = ((long) k << 32) | rem;
                int leftT = (l - rem) / k;
                int rightT = (r - rem) / k;
                long invVal = qpow(val, MOD - 2);

                java.util.Map<Integer, Long> diffMap = groups.computeIfAbsent(groupKey, key -> new java.util.HashMap<>());

                diffMap.put(leftT, diffMap.getOrDefault(leftT, 1L) * val % MOD);
                int maxT = (n - rem - 1) / k;
                if (rightT + 1 <= maxT) {
                    diffMap.put(rightT + 1, diffMap.getOrDefault(rightT + 1, 1L) * invVal % MOD);
                }
            }
        }


        for (var entry : groups.entrySet()) {
            long groupKey = entry.getKey();
            int k = (int) (groupKey >> 32); // 解包步长k
            int rem = (int) (groupKey & 0xFFFFFFFFL); // 解包余数rem
            var diffMap = entry.getValue();
            int maxT = (n - rem - 1) / k;

            // 差分点按位置排序，用于顺序计算前缀积
            var sortedDiffs = new java.util.ArrayList<>(diffMap.entrySet());
            sortedDiffs.sort(java.util.Map.Entry.comparingByKey());

            long product = 1;
            int diffPtr = 0; // 差分点指针
            // 遍历序列，应用前缀积
            for (int t = 0; t <= maxT; t++) {
                // 处理当前位置的所有差分更新
                while (diffPtr < sortedDiffs.size() && sortedDiffs.get(diffPtr).getKey() == t) {
                    product = product * sortedDiffs.get(diffPtr).getValue() % MOD;
                    diffPtr++;
                }
                // 应用到原数组
                int pos = rem + t * k;
                nums[pos] = (int) ((long) nums[pos] * product % MOD);
            }
        }

        // 计算最终异或结果
        int xorRes = 0;
        for (int num : nums) xorRes ^= num;
        return xorRes;
    }
}