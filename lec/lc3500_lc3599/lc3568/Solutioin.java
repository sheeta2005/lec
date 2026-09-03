package lc3500_lc3599.lc3568;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 方向：上下左右
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    static class State {
        int x,y,mask,e;
        State(int x,int y,int mask,int e){
            this.x=x;
            this.y=y;
            this.mask=mask;
            this.e=e;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sx=-1,sy=-1;
        int litterCount=0;
        // 记录每个L对应的垃圾编号
        int[][] litterId = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c = classroom[i].charAt(j);
                if(c=='S'){
                    sx=i; sy=j;
                }else if(c=='L'){
                    litterId[i][j] = litterCount++;
                }
            }
        }
        // 没有垃圾，直接0步
        if(litterCount ==0) return 0;
        int fullMask = (1 << litterCount) - 1;

        // maxEnergy[x][y][mask]：到达(x,y)该掩码状态，保存最大剩余能量
        int[][][] maxEnergy = new int[m][n][1<<litterCount];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<(1<<litterCount);k++){
                    maxEnergy[i][j][k] = -1;
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        q.offer(new State(sx,sy,0,energy));
        maxEnergy[sx][sy][0] = energy;

        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int t=0;t<sz;t++){
                State cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                int mask = cur.mask;
                int e = cur.e;

                for(int[] d: dirs){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(nx<0||nx>=m||ny<0||ny>=n) continue;
                    char ch = classroom[nx].charAt(ny);
                    if(ch == 'X') continue;

                    // 规则：能量等于0的时候，只能踩R格子才允许移动
                    if(e == 0 && ch != 'R'){
                        continue;
                    }

                    int newE = e - 1;
                    int newMask = mask;

                    if(ch == 'R'){
                        newE = energy; //重置满能量
                    }
                    if(ch == 'L'){
                        int id = litterId[nx][ny];
                        newMask = mask | (1 << id);
                    }

                    // 剪枝：这个位置+这个mask，之前已经有更高能量来过，直接舍弃
                    if(newE <= maxEnergy[nx][ny][newMask]){
                        continue;
                    }
                    maxEnergy[nx][ny][newMask] = newE;

                    if(newMask == fullMask){
                        return step + 1;
                    }
                    q.offer(new State(nx, ny, newMask, newE));
                }
            }
            step++;
        }
        return -1;
    }
}