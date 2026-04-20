package com.sheeta1998.lec.lc3546;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        boolean res = false;
        int a = grid.length;
        int b = grid[0].length;
       long[] row = new       long[a];
       long[] row1 = new      long[a];
       long[] row2 = new      long[a];
       long[] column = new    long[b];
       long[] column1 = new  long[b];
       long[] column2 = new  long[b];
        //
        for (int i = 0; i < a; i++) {
            int He = 0;
            for (int j = 0; j < b; j++) {
                He += grid[i][j];
            }
            row[i] = He;
        }
        //
        for (int i = 0; i < b; i++) {
            int He = 0;
            for (int j = 0; j < a; j++) {
                He += grid[j][i];
            }
            column[i] = He;
        }
//
        row1[0] = row[0];
        for (int i = 1; i < a; i++) {
            row1[i] = row1[i - 1] + row[i];
        }
        row2[a - 1] = row[a - 1];
        for (int i = a - 2; i >0; i--) {
            row2[i] = row2[i + 1] + row[i];
        }
//
        column1[0] = column[0];
        for (int i = 1; i < b; i++) {
            column1[i] = column1[i - 1] + column[i];
        }
        column2[b - 1] = column[b - 1];
        for (int i = b - 2; i >0; i--) {
            column2[i] = column2[i + 1] + column[i];
        }
        //

        for (int i = 0; i < a - 1; i++) {
            if (row1[i] == row2[i + 1]) {
                res = true;
            }
        }
        for (int i = 0; i < b - 1; i++) {
            if (column1[i] == column2[i + 1]) {
                res = true;
            }
        }
        return res;
    }

}