package lc300_lc399.lc300;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 空集合 或 当前数大于末尾元素，直接追加
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                // 递归二分找到第一个 >= num 的下标，替换
                int index = findFirstGreaterOrEqual(list, num, 0, list.size());
                list.set(index, num);
            }
        }

        return list.size();
    }

    // 递归二分：返回 list 中第一个 >= num 的元素下标
    private int findFirstGreaterOrEqual(List<Integer> list, int num, int left, int right) {
        // 递归终止：左右边界重合，就是目标位置
        if (left == right) {
            return left;
        }

        int mid = left + ((right - left) >> 1);

        if (list.get(mid) >= num) {
            // 中间值 >= num，目标在左半区（包含 mid）
            return findFirstGreaterOrEqual(list, num, left, mid);
        } else {
            // 中间值 < num，目标在右半区
            return findFirstGreaterOrEqual(list, num, mid + 1, right);
        }
    }
}
