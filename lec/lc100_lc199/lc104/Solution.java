package lc100_lc199.lc104;


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

    public int maxDepth(TreeNode root) {
        int res = 0;
        res = dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = dfs(root.left) + 1;
        int b = dfs(root.right) + 1;
        return a > b ? a : b;
    }
}