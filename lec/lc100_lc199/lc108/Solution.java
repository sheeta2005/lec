package lc100_lc199.lc108;




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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = merge(0,nums.length-1,nums);
        return root;
    }
// 0 1 2 3 4
    private TreeNode merge(int left, int right,int[] nums) {
        if (left>right){return  null;}
        int mid=(left+right)/2;
        TreeNode root =new TreeNode(nums[mid]);
        root.left=merge(left, mid-1,nums);
        root.right=merge(mid+1,right,nums);
        return root;
    }

}