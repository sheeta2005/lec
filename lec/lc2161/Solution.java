package lc2161;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public int[] pivotArray(int[] nums, int pivot) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                q1.add(nums[i]);
            } else if (nums[i] == pivot) {
                count++;
            } else {
                q2.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!q1.isEmpty()) {
                nums[i] = q1.poll();
                continue;
            }
            if (count != 0) {
                nums[i] = pivot;
                count--;
                continue;
            }
            if (!q2.isEmpty()) {
                nums[i] = q2.poll();
            }

        }

        return nums;
    }
}
