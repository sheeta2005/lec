package lc1700_lc1799.lc1768;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int pos1 = 0;
        int pos2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (pos1 != len1 && pos2 != len2) {
            stringBuilder.append(word1.charAt(pos1++));
            stringBuilder.append(word2.charAt(pos2++));
        }
        if (len1 > len2) {
            while (pos1 != len1) {
                stringBuilder.append(word1.charAt(pos1++));
            }
        } else {
            while (pos2 != len2) {
                stringBuilder.append(word2.charAt(pos2++));
            }
        }
        return stringBuilder.toString();
    }
}