package lc1000_lc1099.lc1071;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals((str2+str1))){
            return "";
        }
        int a =str1.length();
        int b =str2.length();
        int gcd = gcd(a, b);
        StringBuilder sb= new StringBuilder(str1+str2);
        return sb.substring(0,gcd-1);

    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}