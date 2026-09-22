package lc200_lc299.lc200;

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] judge = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !judge[i][j]) {
                    dfs(i, j, grid, judge);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] judge) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || judge[i][j]) {
            return;
        }
        judge[i][j] = true;

        dfs(i + 1, j, grid, judge);
        dfs(i - 1, j, grid, judge);
        dfs(i, j + 1, grid, judge);
        dfs(i, j - 1, grid, judge);
    }
}