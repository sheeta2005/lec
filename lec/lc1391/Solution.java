package lc1391;

class Solution {

    public int  tool(){
        return 1;
    }
    public boolean hasValidPath(int[][] grid) {
        boolean res =false;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int [][]dpmark = new int[n][m];
        grid[0][0] = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (grid[i][j]==1){
                    //check grid[i][j+1]

                    //if j!=0 check grid[i][j-1]
                }
            }
        }
        if (dp[n][m]==1){res =true;}
        return res;
    }


}