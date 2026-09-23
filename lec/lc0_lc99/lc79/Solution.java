package lc0_lc99.lc79;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 上下左右：{x偏移，y偏移}
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int[][] visited = new int[board.length][board[0].length];
            int[] ints = list.get(i);
            boolean res = method1(ints[0], ints[1], board, word, 0, visited);
            if (res) {
                return true;
            }
        }
        return false;
    }

    private boolean method1(int x, int y, char[][] board, String word, int index, int[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1) {
            return false;
        }
        if (visited[x][y] == 1 || board[x][y] != word.charAt(index)) {
            return false;
        }

        char need = word.charAt(index);
        if (need == board[x][y]) {
            visited[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                boolean res = method1(x + dirs[i][0], y + dirs[i][1], board, word, index + 1, visited);
                if (res) {
                    return true;
                }
            }
        }
        visited[x][y] = 0;
        return false;
    }
}