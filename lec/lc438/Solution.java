package lc438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) return res;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            String c = String.valueOf(p.charAt(i));
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<String, Integer> map1 = new HashMap<>();
        int right = 0;
        // 初始化s的前pLen窗口
        for (; right < pLen; right++) {
            String c = String.valueOf(s.charAt(right));
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        if (map1.equals(map)) {
            res.add(0);
        }

        // 滑动窗口，条件修正
        for (int left = 0; right < sLen; left++, right++) {
            // 1. 移除左边界字符
            String leftChar = String.valueOf(s.charAt(left));
            map1.put(leftChar, map1.get(leftChar) - 1);
            if (map1.get(leftChar) == 0) {
                map1.remove(leftChar);
            }
            // 2. 添加新右边界字符
            String rightChar = String.valueOf(s.charAt(right));
            map1.put(rightChar, map1.getOrDefault(rightChar, 0) + 1);
            // 3. 判断匹配，起始下标 left+1
            if (map1.equals(map)) {
                res.add(left + 1);
            }
        }
        return res;
    }
}




