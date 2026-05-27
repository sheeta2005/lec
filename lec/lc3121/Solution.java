package lc3121;

public class Solution {
    public int numberOfSpecialChars(String word) {
        int[][] arr = new int[26][2];
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            //处理小写
            if (cur <= 'z' && cur >= 'a') {
                int num = cur - 'a';
                if (arr[num][1] != 0) {
                    arr[num][0] = 0;
                } else arr[num][0] = 1;
            }
            //处理大写
            if (cur <= 'Z' && cur >= 'A') {
                int num = cur - 'A';
                arr[num][1] = 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i][0] == 1 && arr[i][1] == 1) {
                res++;
            }
        }
        return res;
    }
}
