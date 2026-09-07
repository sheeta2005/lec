package lc200_lc299.lc240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length - 1;
        int x = 0;
        int y = matrix[0].length - 1;

        while (x <= n && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }
}
