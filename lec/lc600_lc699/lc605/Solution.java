package lc600_lc699.lc605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] newArr = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            newArr[i + 1] = flowerbed[i];
        }
        int res = 0;
        for (int i = 1; i <= flowerbed.length; i++) {
            if (newArr[i - 1] == 0 && newArr[i] == 0 && newArr[i + 1] == 0) {
                newArr[i] = 1;
                res++;
            }
        }
        return res >= n;
    }
}