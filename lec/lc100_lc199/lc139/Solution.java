package lc100_lc199.lc139;

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> hashSet = new HashSet<>(wordDict);
        // a b c d e f g
        for (int i = 1; i <= s.length(); i++) {
            if (!dp[i-1]){continue;}
            for (int j = i; j <= s.length()+1; j++) {
                String substring = s.substring(i-1, j-1);
                if (hashSet.contains(substring)) {
                    dp[j-1] = dp[j-1] || dp[i-1];
                }
            }
        }

        return dp[s.length()];
    }
}