package lc100_lc199.lc169;

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int curRes = 0;
        for (int num : nums) {
            if (count == 0) {
                curRes = num;
                count++;
            } else {
                if (curRes != num) {
                    count -= 1;

                } else {
                    count++;
                }
            }

        }
        return curRes;
    }
}