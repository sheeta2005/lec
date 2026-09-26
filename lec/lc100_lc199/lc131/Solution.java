package lc100_lc199.lc131;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        method1(s, res, path, 0);
        return res;
    }

    private void method1(String s, List<List<String>> res, List<String> path, int start) {
        // 递归到字符串末尾，收集方案
        if(start >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        // 枚举结束位置 end，截取 [start, end]
        for(int end = start; end < s.length(); end++){
            String sub = s.substring(start, end+1);
            // 只继续递归：当前子串是回文的情况
            if(isPalindrome(sub)){
                path.add(sub);
                method1(s, res, path, end+1);
                path.remove(path.size()-1);
            }
        }
    }

    // 判断是否回文
    private boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
