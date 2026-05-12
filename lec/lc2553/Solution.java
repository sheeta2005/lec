package lc2553;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (true) {
                list.add(num % 10);
                if ((num /= 10) == 0) break;
            }
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}