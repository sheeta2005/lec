package lc437;

import java.util.HashMap;

public class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // 初始化前缀和0，次数1
        int[] res = new int[1];
        prexDfs(res, root, targetSum, map, 0L);
        return res[0];
    }

    private void prexDfs(int[] res, TreeNode root, int targetSum, HashMap<Long, Integer> map, long pre) {
        if (root == null) {
            return;
        }
        long sum = pre + root.val;
        long need = sum - targetSum;
        if (map.containsKey(need)) {
            res[0] += map.get(need);
        }
        // 存入当前前缀和
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        prexDfs(res, root.left, targetSum, map, sum);
        prexDfs(res, root.right, targetSum, map, sum);

        // 回溯：左右子树全部跑完，在这里撤销！！
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
