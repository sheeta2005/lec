package lc2196;
import java.util.HashSet;

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

    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root = new TreeNode(0);
        HashSet<Integer> father = new HashSet<Integer>();
        HashSet<Integer> kid = new HashSet<Integer>();
        int[][] arr = new int[100001][2];

        for (int i = 0; i < descriptions.length; i++) {
            //左孩子
            if (descriptions[i][2] == 1) {
                arr[descriptions[i][0]][0] = descriptions[i][1];
            }
            //右孩子
            else {
                arr[descriptions[i][0]][1] = descriptions[i][1];
            }
            kid.add(descriptions[i][1]);
        }

        for (int i = 0; i < descriptions.length; i++) {
            if (!kid.contains(descriptions[i][0])) {
                root.val = descriptions[i][0];
            }
        }

        method1(root, arr, arr[root.val][0], arr[root.val][1]);

        return root;
    }

    private void method1(TreeNode root, int[][] arr, int left, int right) {
        if (left != 0) {
            root.left = new TreeNode(left);
            method1(root.left, arr, arr[left][0], arr[left][1]);
        }

        if (right != 0) {
            root.right = new TreeNode(right);
            method1(root.right, arr, arr[right][0], arr[right][1]);
        }

    }
}