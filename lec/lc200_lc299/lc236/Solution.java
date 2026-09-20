package lc200_lc299.lc236;


class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == p) {
            if (right==q||left==q){
                return root;
            }
            return p;
        }
        if (root == q) {
            if (right==p||left==p){
                return root;
            }
            return q;
        }
        if (left != null && right != null) {
            return root;
        }

        return null;
    }
}