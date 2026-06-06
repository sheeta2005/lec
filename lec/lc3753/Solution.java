package lc3753;

public class Solution {
    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private long calc(long num) {
        char[] c = String.valueOf(num).toCharArray();
        long[][][][] dp = new long[16][2][11][11];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 11; k++) {
                    // 直接填充最后一维的一维数组
                    java.util.Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        //10是不可能到达的地方
        return dfs(dp, 0, 1, 10, 10, c);
    }

    private long dfs(long[][][][] dp, int pos, int tight, int last1, int last2, char[] c) {
        if (pos == c.length) {
            return 0;
        }
        if (dp[pos][tight][last1][last2] != -1) {
            return dp[pos][tight][last1][last2];
        }
        long res = 0;
        int max = tight == 1 ? c[pos] - '0' : 9;

        for (int i = 0; i <= max; i++) {
            int newTight = (tight == 1 && i == max) ? 1 : 0;
            if (last1 != 10 && last2 != 10) {
                if ((last1 > last2 && last2 < i) || (last1 < last2 && last2 > i)) {
                    res+=1;
                }
            }
            res += dfs(dp, pos + 1, newTight, last2, i, c);

        }
        return dp[pos][tight][last1][last2] = res;
    }
}