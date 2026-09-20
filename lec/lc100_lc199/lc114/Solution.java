package lc100_lc199.lc114;
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
    public void flatten(TreeNode root) {
        method1(root);
    }
    private void method1(TreeNode root) {
        if (root==null){return;}
        method1(root.left);
        method1(root.right);

        if(root.left != null){
            TreeNode oldRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode pos = root.right;
            while (pos.right!=null){
                pos=pos.right;
            }
            pos.right=oldRight;
        }
    }
}
