package lc0_lc99.lc45;

class Try {
    public int jump(int[] nums) {
        int further = 0;
        int min = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > further) {
                return min;
            }
            if (further > i - 1) {
                if (end >= nums.length - 1) break;
                return min + 1;
            }
            further = Math.max(further, nums[i] + i);
            if (i == end) {
                min++;
                end = further;
            }

        }
        return min;
    }
}