package lc3600_lc3699.lc3633;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            int ls = landStartTime[i];
            int ld = landDuration[i];
            for(int j = 0; j < waterStartTime.length; j++){
                int ws = waterStartTime[j];
                int wd = waterDuration[j];
                int end1 = Math.max(ls, 0) + ld;
                end1 = Math.max(ws, end1) + wd;
                int end2 = Math.max(ws, 0) + wd;
                end2 = Math.max(ls, end2) + ld;
                res = Math.min(res, Math.min(end1, end2));
            }
        }
        return res;
    }
}