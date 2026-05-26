package lc28;

class Solution {

    public static int[] next(String s2) {
        int[] next = new int[s2.length()];
        next[0] = 0;
        for (int i = 1; i < s2.length(); i++) {
            int len = next[i - 1];

            while (len != 0 && s2.charAt(i) != s2.charAt(len)) {
                len = next[len - 1];
            }
            if (s2.charAt(i) == s2.charAt(len)) {
                len++;
            }
            next[i] = len;
        }
        return next;
    }

    public static int kmp(String s1, String s2) {
        int[] next = next(s2);
        int len = 0;
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(len);

            while (len != 0 && a != b) {
                len = next[len - 1];
                b = s2.charAt(len);
            }
            if (a == b) {
                len++;
                if (len == s2.length()) {
                    return i - s2.length() - 1;
                }
            }

        }
        return -1;
    }

    public int strStr(String haystack, String needle) {

        return kmp(haystack, needle);

    }
}