package lc2078;
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            if (colors[0] != colors[n - 1 - i] || colors[i] != colors[n - 1]) {
                return n - 1 - i;
            }
        }

        return 0;
    }
}