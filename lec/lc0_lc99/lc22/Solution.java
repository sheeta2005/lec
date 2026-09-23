package lc0_lc99.lc22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        method1(res, n, path, 0, 0);
        return res;
    }

    private void method1(List<String> res, int n, StringBuilder path, int left, int right) {
        if (right > left) {
            return;
        }
        if (left == right && right == n) {
            res.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            method1(res, n, path, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (left > right) {
            path.append(")");
            method1(res, n, path, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}