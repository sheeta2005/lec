package lc788;

class Solution {
    private String s;
    private int[][] dp;

    public int rotatedDigits(int n) {
        s = Integer.toString(n);
        dp = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        return dfs(0, true, 0);
    }

    private int dfs(int pos, boolean bound, int diff) {

        if (pos == s.length()) {
            return diff;
        }

        if (!bound && dp[pos][diff] != -1) {
            return dp[pos][diff];
        }

        int max = bound ? s.charAt(pos) - '0' : 9;
        int res = 0;


        for (int i = 0; i <= max; i++) {
            if (i == 3 || i == 4 || i == 7) continue;

            boolean newBound = bound && (i == max);
            int newDiff = diff;


            if (i == 2 || i == 5 || i == 6 || i == 9) {
                newDiff = 1;
            }


            res += dfs(pos + 1, newBound, newDiff);
        }


        if (!bound) {
            dp[pos][diff] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        System.out.println(x.rotatedDigits(24));
    }
}