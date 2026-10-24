package lc400_lc499.lc443;

class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        int n = chars.length;
        while (read < n) {
            char currentChar = chars[read];
            int count = 0;
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }
            chars[write] = currentChar;
            write++;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[write] = countStr.charAt(i);
                    write++;
                }
            }
        }
        return write;
    }
}