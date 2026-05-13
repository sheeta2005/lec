package lc1674;

class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int sum = a + b;

            // 1. 初始：所有x需要2次修改
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // 2. 进入cost=1的区间，修改次数减1
            int l = Math.min(a, b) + 1;
            int r = Math.max(a, b) + limit;
            diff[l] -= 1;
            diff[r + 1] += 1;

            // 3. 进入cost=0的点，修改次数再减1
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        // 计算前缀和，找出最小修改次数
        int minOps = Integer.MAX_VALUE;
        int currentOps = 0;
        for (int x = 2; x <= 2 * limit; x++) {
            currentOps += diff[x];
            minOps = Math.min(minOps, currentOps);
        }
        return minOps;
    }
}