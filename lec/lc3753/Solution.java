package lc3753;

import java.util.Arrays;

class Solution {
    private String s;
    private int n;
    private long[][][] memoCnt;
    private long[][][] memoSum;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) return 0L;
        s = Long.toString(num);
        n = s.length();
        memoCnt = new long[16][10][10];
        memoSum = new long[16][10][10];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(memoCnt[i][j], -1);
                Arrays.fill(memoSum[i][j], -1);
            }
        }
        long[] res = dfs(0, -1, -1, true, true);
        return res[1];
    }

    private long[] dfs(int pos, int prev, int curr, boolean isLimit, boolean isLeading) {
        // 【绝对不能改顺序】先判断终止条件，再访问记忆化
        if (pos == n) {
            return new long[]{1L, 0L};
        }

        // 只有无前导零、无上限限制、且已有两位有效数字时，才使用记忆化
        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memoCnt[pos][prev][curr] != -1) {
                return new long[]{memoCnt[pos][prev][curr], memoSum[pos][prev][curr]};
            }
        }

        long cnt = 0, sum = 0;
        int up = isLimit ? (s.charAt(pos) - '0') : 9;

        for (int digit = 0; digit <= up; digit++) {
            boolean newLeading = isLeading && (digit == 0);
            int newPrev = curr;
            int newCurr = newLeading ? -1 : digit;

            long[] sub = dfs(pos + 1, newPrev, newCurr, isLimit && (digit == up), newLeading);
            long subCnt = sub[0], subSum = sub[1];

            // 计算当前位的波动贡献
            if (!newLeading && prev >= 0 && curr >= 0) {
                if ((prev < curr && curr > digit) || (prev > curr && curr < digit)) {
                    // 当前位是峰/谷，所有子方案都加1个波动值
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        // 更新记忆化
        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            memoCnt[pos][prev][curr] = cnt;
            memoSum[pos][prev][curr] = sum;
        }

        return new long[]{cnt, sum};
    }
}