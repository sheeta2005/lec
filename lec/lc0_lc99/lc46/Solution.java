package lc0_lc99.lc46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur= new ArrayList<>();
        boolean[] ak = new boolean[nums.length];
        dfs(nums,res,cur,ak);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] ak) {
            if (nums.length==cur.size()){
                res.add(cur);
                return;
            }
        for (int i = 0; i < nums.length; i++) {
            if (ak[i]){
                continue;
            }
            else {
                ak[i]=true;
                cur.add(nums[i]);
                dfs(nums, res, cur, ak);
                ak[i]=false;
                cur .removeLast();
            }

        }

    }


}
//鸣响，震动——我们生在永不停息的火车之上，一往无前的冲劲将我们撕扯向这片暴躁的大地。好在那小小的铰链，将你我相连。