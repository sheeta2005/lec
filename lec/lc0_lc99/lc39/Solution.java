package lc0_lc99.lc39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        method(candidates, target, path, res, 0, 0);
        return res;
    }

    private void method(int[] candidates, int target, List<Integer> path, List<List<Integer>> res, int prev, int start) {

        for (int i = start; i < candidates.length; i++) {
            int sum = candidates[i] + prev;
            path.add(candidates[i]);
            if (sum == target) {
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                continue;
            } else if (sum > target) {
                path.remove(path.size() - 1);
                continue;
            }

            method(candidates, target, path, res, sum, i);
            path.remove(path.size() - 1);
        }
    }
}