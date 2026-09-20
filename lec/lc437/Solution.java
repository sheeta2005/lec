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
        int sum = 0;
        dfs(root, sum, targetSum, res);

        return res[0];
    }
    private void dfs(TreeNode root, int prev, int targetSum, int[] res) {
        if (root==null){return;}
        prev += root.val;
        if (prev == targetSum) {
            res[0] += 1;
        }
        dfs(root.left, prev, targetSum, res);
        dfs(root.right, prev, targetSum, res);
        prev -= root.val;
        if (prev == targetSum) {
            res[0] += 1;
        }
    }
}