package lc0_lc99.lc32;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    max = Math.max(max, i - deque.peek());
                }

            }
        }

        return max;
    }
}