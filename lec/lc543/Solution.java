package lc543;


class Solution {

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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] res =new int[1];
        dfs(root,res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root==null){
            return 0;
        }
        int a =dfs(root.left, res);
        int b =dfs(root.right,res);
        if (a+b>res[0]){
            res[0]=a+b;
        }
        return a>b?a+1:b+1;
    }
}