package lc0_lc99.lc54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 总元素数量，收集满直接结束，避免死循环兜底
        int total = rows * cols;

        while (res.size() < total) {
            res.add(matrix[i][j]);
            matrix[i][j] = 101; // 标记已访问

            // 向右优先
            if (j + 1 < cols && matrix[i][j + 1] != 101) {
                j++;
            }
            // 向右走不通，向下
            else if (i + 1 < rows && matrix[i + 1][j] != 101) {
                i++;
            }
            // 向下走不通，向左
            else if (j - 1 >= 0 && matrix[i][j - 1] != 101) {
                j--;
            }
            // 向左走不通，向上
            else if (i - 1 >= 0 && matrix[i - 1][j] != 101) {
                i--;
            }
            // 四个方向全部堵住，退出循环
            else {
                break;
            }
        }
        return res;
    }
}