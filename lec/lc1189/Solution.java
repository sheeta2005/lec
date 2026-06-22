package lc1189;

import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            String s = String.valueOf(c);
            map.put(s, map.computeIfAbsent(s, k -> 0) + 1);
        }
        int res = map.getOrDefault("a", 0);

        if (map.getOrDefault("b", 0) < res) {
            res = map.getOrDefault("b", 0);
        }
        if (map.getOrDefault("l", 0) / 2 < res) {
            res = map.getOrDefault("l", 0) / 2;
        }
        if (map.getOrDefault("o", 0) / 2 < res) {
            res = map.getOrDefault("o", 0) / 2;
        }
        if (map.getOrDefault("n", 0) < res) {
            res = map.getOrDefault("n", 0);
        }
        return res;
    }
}