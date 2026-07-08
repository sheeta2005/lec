package lc3754;

class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int sum=0;

        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            if (c!='0'){
                sb.append(c);
                sum += c-'0';
            }
        }
        if (sb.isEmpty()){
            return 0;
        }

        return Long.valueOf(sb.toString())*sum;
    }
}