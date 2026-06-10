package lc3600_lc3699.lc3691;

import java.util.PriorityQueue;

class Solution {
    public int log2(int x) {
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    int[][] stMax;
    int[][] stMin;
    int[] logTable;

    public void build(int[] nums) {
        int n = nums.length;
        if (n == 0) return;

        int K = log2(n) + 1;
        stMax = new int[K][n];
        stMin = new int[K][n];
        logTable = new int[n + 1];


        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }


        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                int mid = i + (1 << (j - 1));
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][mid]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][mid]);
            }
        }


        logTable[1] = 0;
        for (int len = 2; len <= n; len++) {
            logTable[len] = log2(len);
        }
    }


    public int queryMax(int l, int r) {
        int len = r - l + 1;
        int k = logTable[len];
        return Math.max(stMax[k][l], stMax[k][r - (1 << k) + 1]);
    }


    public int queryMin(int l, int r) {
        int len = r - l + 1;
        int k = logTable[len];
        return Math.min(stMin[k][l], stMin[k][r - (1 << k) + 1]);
    }


    public int value(int l, int r) {
        return queryMax(l, r) - queryMin(l, r);
    }

    public long maxTotalValue(int[] nums, int k) {
        build(nums);
        long res = 0;
        int n = nums.length;
        if (n == 0) return 0;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - 1;
            int val = value(l, r);
            maxHeap.add(new int[]{val, l, r});
        }


        while (k > 0 && !maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            int val = cur[0];
            int l = cur[1];
            int r = cur[2];
            res += val;

            if (r > l) {
                int newR = r - 1;
                int newVal = value(l, newR);
                maxHeap.add(new int[]{newVal, l, newR});
            }
            k--;
        }

        return res;
    }
}