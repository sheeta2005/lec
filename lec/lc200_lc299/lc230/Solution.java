package lc200_lc299.lc230;


import java.util.ArrayList;
import java.util.List;

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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        method1(list, root);
        return list.get(k);
    }

    private void method1(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        method1(list, root.left);
        list.add(root.val);
        method1(list, root.right);
    }
}

