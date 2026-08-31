package lc3600_lc3699.lc3658;

class Solution {
    public int gcdOfOddEvenSums(int n) {
        if(n==1){return 1;}
        int a = 0;
        int b = 0;
        a = n * n;
        b = a + n;

        return gcd(a, b);
    }

    private int gcd(int a, int b) {
        int res = 0;
        while (true) {
            res = b % a;
            if (res == 0) {
                return b;
            } else {
                a = b;
                b = res;
            }
        }
    }
}