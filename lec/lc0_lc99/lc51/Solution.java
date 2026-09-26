package lc0_lc99.lc51;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] path = new char[n][n];
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                path[i][j] = '.';
            }
        }
        method1(res, path, n, 0);
        return res;
    }

    private void method1(List<List<String>> res, char[][] path, int n, int cur) {
        if (cur == n) {
            List<String> r = new ArrayList<>();
            for (int i = 0; i < path.length; i++) {
                r.add(new String(path[i]));
            }
            res.add(r);
            return;
        }

        for (int j = 0; j < path[0].length; j++) {
            if (check(path, cur, j)) {
                path[cur][j] = 'Q';
                method1(res, path, n, cur + 1);
                path[cur][j] = '.';
            }
        }
    }


    private boolean check(char[][] path, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (path[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < path.length; i--, j++) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
