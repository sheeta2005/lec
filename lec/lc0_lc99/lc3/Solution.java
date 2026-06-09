package lc0_lc99.lc3;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();
        int res = 0;
        int curRes = 0;
        int leftPos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String s1 = String.valueOf(c);
            while (set.contains(s1)) {
                set.remove(String.valueOf(s.charAt(leftPos)));
                leftPos++;
                curRes--;
            }
            set.add(s1);
            curRes++;
            res=Math.max(curRes,res);
        }
        return res;
    }
}