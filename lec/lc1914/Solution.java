package lc1914;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            // 1. 把当前层抽成一维数组
            List<Integer> list = new ArrayList<>();
            // 上边界
            for (int j = layer; j < n - layer; j++) {
                list.add(grid[layer][j]);
            }
            // 右边界（跳过第一个，已经在上边界处理过）
            for (int i = layer + 1; i < m - layer; i++) {
                list.add(grid[i][n - layer - 1]);
            }
            // 下边界（跳过最后一个，已经在右边界处理过）
            for (int j = n - layer - 2; j >= layer; j--) {
                list.add(grid[m - layer - 1][j]);
            }
            // 左边界（跳过第一个和最后一个，都已经处理过）
            for (int i = m - layer - 2; i > layer; i--) {
                list.add(grid[i][layer]);
            }

            // 2. 计算实际轮转次数
            int len = list.size();
            int shift = k % len;
            if (shift == 0) continue;

            // 3. 做 k 次循环左移（等价于一次整体旋转）
            List<Integer> rotated = new ArrayList<>();
            for (int i = shift; i < len; i++) {
                rotated.add(list.get(i));
            }
            for (int i = 0; i < shift; i++) {
                rotated.add(list.get(i));
            }

            // 4. 把轮转后的数组写回当前层
            int idx = 0;
            // 上边界
            for (int j = layer; j < n - layer; j++) {
                grid[layer][j] = rotated.get(idx++);
            }
            // 右边界
            for (int i = layer + 1; i < m - layer; i++) {
                grid[i][n - layer - 1] = rotated.get(idx++);
            }
            // 下边界
            for (int j = n - layer - 2; j >= layer; j--) {
                grid[m - layer - 1][j] = rotated.get(idx++);
            }
            // 左边界
            for (int i = m - layer - 2; i > layer; i--) {
                grid[i][layer] = rotated.get(idx++);
            }
        }
        return grid;
    }
}