package lc0_lc99.lc5;

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int pos1 = i;
            int pos2 = i;
            while (pos1 >= 0 && pos2 < s.length()) {
                if (s.charAt(pos1) != s.charAt(pos2)) {
                    break;
                }
                if (pos2 - pos1 + 1 > max) {
                    max = pos2 - pos1 + 1;
                    res = s.substring(pos1, pos2 + 1);
                }
                pos1--;
                pos2++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int pos1 = i;
            int pos2 = i + 1;
            while (pos1 >= 0 && pos2 < s.length()) {
                if (s.charAt(pos1) != s.charAt(pos2)) {
                    break;
                }
                if (pos2 - pos1 + 1 > max) {
                    max = pos2 - pos1 + 1;
                    res = s.substring(pos1, pos2 + 1);
                }
                pos1--;
                pos2++;
            }
        }
        return res;
    }
}