package lc3000_lc3099.lc3838;

public class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int length = words.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length ; i++) {
            String s = words[i];
            int sum = 0;
            for (int j = 0; j < s.length() ; j++) {
                sum += method2(s.charAt(j),weights);
                sum %= 26;
            }
            System.out.println(sum);
            stringBuilder.append(method1(sum));
        }
        return stringBuilder.toString();
    }

    private int method2(char c,int[] weights) {
        return weights[25+c-'z'];
    }

    private char method1(int sum) {

        return  (char) ('z' - sum);
    }
}
