package lc3120;

public class Solution {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        int[][] arr = new int[26][2];
        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i) - 'a';
            int A = word.charAt(i) - 'A';
            //小的
            if (a >= 0) {
                arr[a][0] = 1;
            }
            //大的
            else {
                arr[A][1] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i][0] == 1 && arr[i][0] == arr[i][1]) {
                res++;
            }
        }
        return res;
    }
}
