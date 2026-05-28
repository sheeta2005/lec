package com.sheeta1998.lec.lc3070;

public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        int a = grid.length+1;
        int b = grid[0].length+1;
        int[][] ints = new int[a][b];
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                ints[i][j]=ints[i][j-1]+ints[i-1][j]+grid[i-1][j-1]-ints[i-1][j-1];
                if (ints[i][j]<=k){
                    count++;
                }
            }
        }
        return count;
    }
}
