package lc1861;
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] res = new char[n][m];
        //双重嵌套循环,res是boxgrid顺时针旋转九十度
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[j][m-i-1] = boxGrid[i][j];
            }
        }
        for(int i = n-1; i >= 0; i--){
            for (int j = m-1; j >=0 ; j--) {
                if (res[i][j]=='.'){
                    int k = i;
                    while (k>=0){
                        if (res[k][j]=='#'){
                            res[k][j] = '.';
                            res[i][j] = '#';
                            break;
                        }
                        if (res[k][j]=='*'){break;}
                        k--;
                    }
                }
            }
        }
        return  res;
    }
}