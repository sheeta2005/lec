package lc0_lc99.lc32;

class Solution2 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        int[] dp = new int[n];
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    // 前一位就是左括号，直接匹配
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else {
                    // 前一位是右括号，往前找匹配的左括号
                    int matchLeft = i - dp[i-1] - 1;
                    if (matchLeft >= 0 && s.charAt(matchLeft) == '(') {
                        // 匹配成功，加上前一段的长度
                        int prev = (matchLeft >= 1) ? dp[matchLeft - 1] : 0;
                        dp[i] = dp[i-1] + 2 + prev;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}