package lc239;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.offer(i);
                continue;
            }
            while (!deque.isEmpty()&&deque.peekFirst() < index) {
                deque.removeFirst();
            }

            while (!deque.isEmpty()&&nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.offer(i);
            while (!deque.isEmpty()&&nums[i] > nums[deque.peekFirst()]) {
                deque.removeFirst();
            }
        }
        res[index++] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty()&&deque.peekFirst() < index) {
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.offer(i);
            while (!deque.isEmpty()&&nums[i] > nums[deque.peekFirst()]) {
                deque.removeFirst();
            }
            res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }
}