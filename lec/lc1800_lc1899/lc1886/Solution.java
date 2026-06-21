package com.sheeta1998.lec.lc1886;

class Solution {

    //Arrays.deepEquals  替代same
    //核心技巧：记住顺时针旋转的坐标公式（90°：(i,j)→(j,n-1-i)、180°：(i,j)→(n-1-i,n-1-j)、270°：(i,j)→(n-1-j,i)）；


    public static boolean same(int[][] mat, int[][] target, int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] switchroom(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
        return mat;
    }

    public boolean findRotation(int[][] mat, int[][] target) {

        int a = mat.length;
        int b = mat[0].length;
        int c = target.length;
        int d = target[0].length;
        if (a != c || b != d) {
            return false;
        }
        if (same(mat, target, a, b)) {
            return true;
        }
        switchroom(mat);
        if (same(mat, target, a, b)) {
            return true;
        }
        switchroom(mat);
        if (same(mat, target, a, b)) {
            return true;
        }
        switchroom(mat);
        if (same(mat, target, a, b)) {
            return true;
        }
        return false;
    }
}