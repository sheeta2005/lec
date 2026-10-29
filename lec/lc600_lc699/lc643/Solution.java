package lc600_lc699.lc643;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            deque.offer(nums[i]);
            res += nums[i];
        }
        double max = res / k;
        for (int i = k; i < nums.length; i++) {
            deque.offer(nums[i]);
            res -= deque.poll();
            res += nums[i];
            if ((res / k) > max) {
                max = res / k;
            }
        }
        return max;
    }
}