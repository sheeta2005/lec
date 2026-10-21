package lc300_lc399.lc345;

class Solution {
    public String reverseVowels(String s) {
        int pos1 = 0;
        int pos2 = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (pos1 <= pos2) {
            if (isVowel(charArray[pos1]) && !isVowel(charArray[pos2])) {
                pos2--;
            } else if (isVowel(charArray[pos2]) && !isVowel(charArray[pos1])) {
                pos1++;
            } else if (isVowel(charArray[pos1]) && isVowel(charArray[pos2])) {
                char temp = charArray[pos1];
                charArray[pos1] = charArray[pos2];
                charArray[pos2] = temp;
                pos1++;
                pos2--;
            } else {
                pos1++;
                pos2--;
            }
        }
        return new String(charArray);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}