package lc1800_lc1899.lc1871;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int[] pre = new int[n + 1];
        pre[1] = 1;

        for (int i = 1; i < n; i++) {

            int L = Math.max(0, i - maxJump);
            int R = i - minJump;

            if (R < 0) {
                dp[i] = false;
            } else {
                if (pre[R + 1] - pre[L] > 0 && s.charAt(i) == '0') {
                    dp[i] = true;
                } else {
                    dp[i] = false;
                }
            }
            pre[i + 1] = pre[i] + (dp[i] ? 1 : 0);
        }
        return dp[n - 1];
    }
}