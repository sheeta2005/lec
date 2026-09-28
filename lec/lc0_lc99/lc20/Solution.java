package lc0_lc99.lc20;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (s1.equals("(") || s1.equals("[") || s1.equals("{")) {
                deque.push(s1);
            } else if (s1.equals(")")) {
                if (deque.isEmpty()){return false;}
                String s2 = deque.pop();
                if (!s2.equals("(")) {
                    return false;
                }
            } else if (s1.equals("]")) {
                if (deque.isEmpty()){return false;}
                String s2 = deque.pop();
                if (!s2.equals("[")) {
                    return false;
                }
            } else {
                if (deque.isEmpty()){return false;}
                String s2 = deque.pop();
                if (!s2.equals("{")) {
                    return false;
                }
            }
        }


        return deque.isEmpty();
    }
}