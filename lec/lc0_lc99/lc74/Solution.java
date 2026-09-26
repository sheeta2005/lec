package lc0_lc99.lc74;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return method1(matrix,0, m*n -1, target, n);
    }
    private boolean method1(int[][] matrix, int left, int right, int target, int n) {
        if(left > right) return false;
        int mid = left + ((right - left) >> 1);
        int row = mid / n;
        int col = mid % n;
        int val = matrix[row][col];
        if(val == target) return true;
        if(val > target){
            return method1(matrix, left, mid-1, target, n);
        }else{
            return method1(matrix, mid+1, right, target, n);
        }
    }
}
