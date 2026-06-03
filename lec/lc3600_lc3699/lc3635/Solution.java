package lc3600_lc3699.lc3635;

import java.util.Arrays;


class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        // 1. 打包并排序陆地项目（按开始时间升序）
        int[][] land = new int[n][3]; // [开始时间, 持续时间, 结束时间]
        for (int i = 0; i < n; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
            land[i][2] = landStartTime[i] + landDuration[i];
        }
        Arrays.sort(land, (a, b) -> a[0] - b[0]);

        // 打包并排序水上项目
        int[][] water = new int[m][3];
        for (int i = 0; i < m; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
            water[i][2] = waterStartTime[i] + waterDuration[i];
        }
        Arrays.sort(water, (a, b) -> a[0] - b[0]);

        // 2. 预处理陆地项目的前缀最小时长和后缀最小结束时间
        int[] prefixMinDurLand = new int[n];
        prefixMinDurLand[0] = land[0][1];
        for (int i = 1; i < n; i++) {
            prefixMinDurLand[i] = Math.min(prefixMinDurLand[i - 1], land[i][1]);
        }
        int[] suffixMinFinishLand = new int[n + 1];
        suffixMinFinishLand[n] = Integer.MAX_VALUE; // 边界哨兵
        for (int i = n - 1; i >= 0; i--) {
            suffixMinFinishLand[i] = Math.min(suffixMinFinishLand[i + 1], land[i][2]);
        }

        // 预处理水上项目的前缀最小时长和后缀最小结束时间
        int[] prefixMinDurWater = new int[m];
        prefixMinDurWater[0] = water[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDurWater[i] = Math.min(prefixMinDurWater[i - 1], water[i][1]);
        }
        int[] suffixMinFinishWater = new int[m + 1];
        suffixMinFinishWater[m] = Integer.MAX_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            suffixMinFinishWater[i] = Math.min(suffixMinFinishWater[i + 1], water[i][2]);
        }

        // 3. 提取排序后的开始时间和结束时间数组（方便二分查找）
        int[] landStarts = new int[n];
        int[] landFinishes = new int[n];
        for (int i = 0; i < n; i++) {
            landStarts[i] = land[i][0];
            landFinishes[i] = land[i][2];
        }
        int[] waterStarts = new int[m];
        int[] waterFinishes = new int[m];
        for (int i = 0; i < m; i++) {
            waterStarts[i] = water[i][0];
            waterFinishes[i] = water[i][2];
        }

        // 4. 计算两种顺序的最小完成时间
        int minLandFirst = calculateMin(landFinishes, waterStarts, prefixMinDurWater, suffixMinFinishWater);
        int minWaterFirst = calculateMin(waterFinishes, landStarts, prefixMinDurLand, suffixMinFinishLand);

        return Math.min(minLandFirst, minWaterFirst);
    }

    // 辅助函数：计算"先玩first类，再玩second类"的最小完成时间
    private int calculateMin(int[] firstFinishes, int[] secondStarts, int[] secondPrefixMinDur, int[] secondSuffixMinFinish) {
        int minTime = Integer.MAX_VALUE;
        int m = secondStarts.length;

        for (int finish1 : firstFinishes) {
            // 二分查找：找到第一个开始时间 > finish1 的项目索引
            int k = upperBound(secondStarts, finish1) - 1;
            int currentMin = Integer.MAX_VALUE;

            // 情况1：有项目在finish1前开放 → 选耗时最短的，结束时间=finish1+最短时长
            if (k >= 0) {
                currentMin = Math.min(currentMin, finish1 + secondPrefixMinDur[k]);
            }
            // 情况2：有项目在finish1后开放 → 选最早结束的那个
            if (k + 1 < m) {
                currentMin = Math.min(currentMin, secondSuffixMinFinish[k + 1]);
            }

            minTime = Math.min(minTime, currentMin);
        }
        return minTime;
    }

    // 二分查找：返回第一个大于target的元素索引
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

