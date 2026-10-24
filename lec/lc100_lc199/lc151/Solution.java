package lc100_lc199.lc151;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}