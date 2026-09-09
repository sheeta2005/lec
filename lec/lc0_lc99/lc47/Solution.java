package lc0_lc99.lc47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> res =new ArrayList<>();
                List<Integer> cur =new ArrayList<>();
                Arrays.sort(nums);
                boolean[]  used=new boolean[nums.length];
                dfs(nums,used ,res,cur);
                return  res;
        }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> cur) {
            if (nums.length==cur.size()){
                if (!res.contains(new ArrayList<>(cur))){
                    res.add(cur);
                    return;
                }
            }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            else {
                used[i]=true;
                cur.add(nums[i]);
                dfs(nums, used, res, cur);
                used[i]=false;
                cur .removeLast();
            }

        }
        }

}
