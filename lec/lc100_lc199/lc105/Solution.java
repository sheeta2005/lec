package lc100_lc199.lc105;


import java.util.HashMap;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrder.put(inorder[i], i);
        }
        int left = 0;
        int right = preorder.length - 1;
        int index = inOrder.get(preorder[0]);
        return method1(preorder, inorder, inOrder, left, right, index);

    }

    private TreeNode method1(int[] preorder, int[] inorder, HashMap<Integer, Integer> inOrder, int left, int right, int index) {
        if (left > right) {
            return null;
        }
        TreeNode cur = new TreeNode(inorder[index]);
        int leftCnt = index - left;
        cur.left = method1(preorder, inorder, inOrder, left, index - 1, index+1);
        cur.right = method1(preorder, inorder, inOrder, index + 1, right,index+leftCnt+1 );
        return cur;
    }


}