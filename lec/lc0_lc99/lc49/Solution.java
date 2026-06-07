package lc0_lc99.lc49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int index =0;
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int n = method1(s, map);
            if (n != -1) {
                res.get(n).add(s);
            }
            else {
                ArrayList<String > ss = new ArrayList<>();
                ss.add(s);
                res.add(ss);
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String s1 = String.valueOf(chars);
                map.put(s1,index++);
            }
        }

        return res;
    }

    private int method1(String s, HashMap<String, Integer> map) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = String.valueOf(chars);
        if (map.containsKey(s1)) {
            return map.get(s1);
        }
        return -1;
    }
}