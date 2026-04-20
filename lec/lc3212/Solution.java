package com.sheeta1998.lec.lc3212;

class Solution {
    public static int numberOfSubmatrices(char[][] grid) {
        int count = 0;
        int a = grid.length;
        int b = grid[0].length;

        int[][] ints = new int[a][b];
        boolean flag = false;
        boolean[][] hasX = new boolean[a][b];

        for (int i = 0; i < a; i++) {
            // 内层循环：遍历当前行的每一列 j
            for (int j = 0; j < b; j++) {
                // 获取当前位置的字符
                char c = grid[i][j];
                if (c == 'X') {
                    hasX[i][j] = true;
                    if (i == 0 && j == 0) {
                        ints[i][j] = 1;
                    } else if (i == 0) {
                        ints[i][j] = 1 + ints[i][j - 1];
                    } else if (j == 0) {
                        ints[i][j] = 1 + ints[i - 1][j];
                    } else {
                        ints[i][j] = ints[i][j - 1] + ints[i - 1][j] + 1 - ints[i - 1][j - 1];
                    }

                } else if (c == 'Y') {
                    if (i == 0 && j == 0) {
                        ints[i][j] = -1;
                    } else if (i == 0) {
                        ints[i][j] = -1 + ints[i][j - 1];
                    } else if (j == 0) {
                        ints[i][j] = -1 + ints[i - 1][j];
                    } else {
                        ints[i][j] = ints[i][j - 1] + ints[i - 1][j] - 1 - ints[i - 1][j - 1];
                    }
                } else {
                    if (i == 0 && j == 0) {
                        ints[i][j] = 0;
                    } else if (i == 0) {
                        ints[i][j] = ints[i][j - 1];
                    } else if (j == 0) {
                        ints[i][j] = ints[i - 1][j];
                    } else {
                        ints[i][j] = ints[i][j - 1] + ints[i - 1][j] - ints[i - 1][j - 1];
                    }
                }
            }
        }
        for (int i = 1; i < a; i++) {
            if (hasX[i - 1][0]) {
                hasX[i][0] = true;
            }
        }
        for (int j = 1; j < b; j++) {
            if (hasX[0][j - 1]) {
                hasX[0][j] = true;
            }
        }
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (hasX[i - 1][j] || hasX[i][j - 1]) {
                    hasX[i][j] = true;
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (ints[i][j] == 0 && hasX[i][j]) {
                    count++;
                }
            }
        }
        if (flag) {
            return count;
        } else return 0;
    }

    public static void main(String[] args) {
        char[][] chars = {{'.', '.'},  // 第一行
                {'Y', 'X'}   // 第二行
        };
        System.out.println(numberOfSubmatrices(chars));
        ;
    }

}