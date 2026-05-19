package lc2540;

import java.util.HashSet;

public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        if (nums1.length > nums2.length) {
            for (int num : nums2) {
                set.add(num);
            }
            for (int num : nums1) {
                if (set.contains(num)) {
                    return num;
                }
            }
        } else {
            for (int num : nums1) {
                set.add(num);
            }
            for (int num : nums1) {
                if (set.contains(num)) {
                    return num;
                }
            }
        }

        return -1;
    }
}
