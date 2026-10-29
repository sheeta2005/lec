package lc1400_lc1499.lc1456;

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        int maxVowels = currentVowels;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
            if (maxVowels == k) {
                return k;
            }
        }
        return maxVowels;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}