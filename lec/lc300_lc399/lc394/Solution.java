package lc300_lc399.lc394;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<String> deque1 = new ArrayDeque<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c <= '9' && c >= '0') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                deque.push(num);
                num = 0;
                deque1.push(sb.toString());
                sb.setLength(0);
            } else if (c == ']') {
                int k = deque.pop();
                String inner = sb.toString();
                String outer = deque1.pop();
                sb.setLength(0);
                sb.append(outer);
                for (int i = 0; i < k; i++) {
                    sb.append(inner);
                }
            } else {
                sb.append(c);
            }

        }


        return sb.toString();
    }
}