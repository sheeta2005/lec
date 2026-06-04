package lc3751;

class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for (; num1 <= num2; num1++) {

            res += method1(num1);
        }
        return res;
    }
    public int method1(int num1) {
        if (num1 < 100) {
            return 0;
        }
        int res = 0;
        String s = String.valueOf(num1);
        int n = s.length();
        for (int i = 1; i <= n - 2; i++) {
            System.out.println(s.charAt(i));
            if (s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) {

                res++;
            }
            if (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }
}