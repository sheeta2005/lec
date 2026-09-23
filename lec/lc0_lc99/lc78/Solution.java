package lc0_lc99.lc78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        method(nums, res, path, 0);


        return res;
    }

    private void method(int[] nums, List<List<Integer>> res, List<Integer> path, int index) {
        if (index > nums.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!res.contains(path)) {
            res.add(new ArrayList<>(path));
        }
        method(nums, res, path, index + 1);
        path.add(nums[index]);
        method(nums, res, path, index + 1);
        path.remove(path.size() - 1);
    }
}