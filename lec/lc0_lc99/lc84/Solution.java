package lc0_lc99.lc84;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            arr[i + 1] = heights[i];
        }
        deque.push(0);
        for (int i = 1; i < arr.length; i++) {
            int a = arr[deque.peek()];
            int b = arr[i];
            if (a <= b) {
                deque.push(i);
            } else {
                while (!deque.isEmpty() && arr[deque.peek()] > b) {
                    Integer pop = deque.pop();
                    int nu = arr[pop] * (i-deque.peek()-1);
                    max= Math.max(max,nu);
                }
                deque.push(i);
            }
        }
        return max;
    }
}