package lc0_lc99.lc98;


import java.util.ArrayList;
import java.util.List;

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

    public boolean isValidBST(TreeNode root) {
    int[] arr = new int[10086];
    List<Integer> list =new ArrayList<>();
    method1(list,root);
        for (int i = 1; i < list.size() ; i++) {
            if (list.get(i)<list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void method1(List<Integer> list, TreeNode root) {
if (root==null){return;}
    method1(list,root.left);
    list.add(root.val);
    method1(list,root.right);
    }


}