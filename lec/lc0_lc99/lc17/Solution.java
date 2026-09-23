package lc0_lc99.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        method1(digits, 0, path, res, map);
        return res;
    }

    private void method1(String digits, int index, StringBuilder path, List<String> res, HashMap<Character, char[]> map) {
        if (path.length()==digits.length()){
            res.add(path.toString());
            return;
        }
        char c = digits.charAt(index);
        char[] chars = map.get(c);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            path.append(aChar);

            method1(digits,index+1,path,res,map);
            path.deleteCharAt(path.length()-1);
        }
    }
}