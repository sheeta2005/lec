package lc1291;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        // 固定基础串：所有顺次数都是该串连续截取
        String base = "123456789";
        // low的数字位数
        int lenMin = String.valueOf(low).length();
        // high的数字位数
        int lenMax = String.valueOf(high).length();

        // 遍历每一种数字长度
        for (int len = lenMin; len <= lenMax; len++) {
            // 滑动窗口：截取长度为len的连续子串，窗口起点最大到 9-len
            for (int start = 0; start <= 9 - len; start++) {
                // 截取 [start, start+len) 连续字符，就是顺次数字符串
                String numStr = base.substring(start, start + len);
                int num = Integer.parseInt(numStr);
                // 判断是否落在区间内
                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}