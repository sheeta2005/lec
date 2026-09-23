package lc437;


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        int[] res = new int[1];
        dfs1(root, targetSum, res);
        return res[0];
    }

    void dfs1(TreeNode root, int targetSum, int[] res) {
        if (root == null) {
            return;
        }
        dfs2(root, targetSum, res, 0);
        dfs1(root.left, targetSum, res);
        dfs1(root.right, targetSum, res);
    }

    void dfs2(TreeNode root, int targetSum, int[] res, long prev) {
        if (root == null) {
            return;
        }
        long sum = prev + root.val;
        if (sum == targetSum) {
            res[0]++;
        }
        dfs2(root.left, targetSum, res, sum);
        dfs2(root.right, targetSum, res, sum);
    }
}