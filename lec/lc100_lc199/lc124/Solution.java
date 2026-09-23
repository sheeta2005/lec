package lc100_lc199.lc124;


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

    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0]=Integer.MIN_VALUE;
        dfs(root, 0, res);

        return res[0];
    }

    private int dfs(TreeNode root, int prev, int[] res) {
        if (root == null) {
            return 0;
        }

        int a = dfs(root.left, prev, res);
        int b = dfs(root.right, prev, res);
        int sum = root.val;
        if (a > 0) {
            sum += a;
        }
        if (b > 0) {
            sum += b;
        }
        res[0] = res[0] > sum ? res[0] : sum;
        return Math.max(0,Math.max(a,b))+ root.val;
    }
}