package lc0_lc99.lc15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int leftPos = i + 1;
            int rightPos = n - 1;
            while (leftPos < rightPos) {
                int sum = nums[i] + nums[leftPos] + nums[rightPos];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[leftPos]);
                    list.add(nums[rightPos]);
                    if (!set.contains(list)) {
                        set.add(list);
                        res.add(list);
                    }
                    leftPos++;
                } else if (sum > 0) {
                    rightPos--;
                } else {
                    leftPos++;
                }
            }
        }
        return res;
    }
}
