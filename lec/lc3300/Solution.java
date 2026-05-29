package lc3300;

public class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            int curRes = 0;
            for (int j = 0; j < s.length(); j++) {
                int num = s.charAt(j) - '0';
                curRes += num;
            }

            res = Math.min(res, curRes);
        }
        return res;
    }
}
