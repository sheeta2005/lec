package com.sheeta1998.lec.lc2906;

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int total = a * b;
        int[] arr = new int[total];
        int[] prearr = new int[total];
        int[] sufarr = new int[total];
        int count = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[count++] = grid[i][j];
            }
        }
        for (int i = 0; i < total; i++) {
            if (i == 0) {
                prearr[0] = arr[0];
                sufarr[a * b - 1] = arr[a * b - 1];
                continue;
            }
            prearr[i] = arr[i] * prearr[i - 1] % 12345;
            sufarr[a * b - 1 - i] = arr[a * b - 1 - i] * sufarr[a * b - i] % 12345;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 && j == 0) {
                    grid[0][0] = sufarr[1] % 12345;
                    continue;
                }
                if (i == a - 1 && j == b - 1) {
                    grid[i][j] = prearr[a * b - 2] % 12345;
                    continue;
                }
                grid[i][j] = prearr[i * b + j - 1] * sufarr[i * b + j + 1] % 12345;
            }
        }
        return grid;
    }
}