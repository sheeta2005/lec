package lc0_lc99.lc55;
class Solution {
    int[] memo;
    public boolean canJump(int[] nums) {
        int len = nums.length;
        memo = new int[len];
        // 0代表未访问，初始全部是0
        if (len == 1) {
            return true;
        }
        return se(len - 1, nums);
    }

    boolean se(int cur, int[] nums) {
        if (cur == 0) {
            return true;
        }
        // 已经算过，直接返回结果
        if(memo[cur] != 0){
            return memo[cur] == 1;
        }
        for (int i = 0; i < cur; i++) {
            if (nums[i] >= cur - i) {
                if (se(i, nums)) {
                    memo[cur] = 1;
                    return true;
                }
            }
        }
        // 所有i都试完，无法到达cur
        memo[cur] = -1;
        return false;
    }
}
