package lc100_lc199.lc105;


import java.util.HashMap;

class Try {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return method1(0, preorder.length - 1, 0, inorder.length-1, preorder, inorder, map);

    }

    private TreeNode method1(int preBegin, int preEnd, int inBegin, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (preBegin>preEnd){
            return null;
        }
        if (inBegin>inEnd){
            return null;
        }

        int cur = preorder[preBegin];
        TreeNode curNode = new TreeNode(cur);
        int mid = map.get(cur);
        int leftCnt = mid - inBegin;

        curNode.left = method1(preBegin + 1, preBegin + leftCnt, inBegin, mid - 1, preorder, inorder, map);
        curNode.right = method1(preBegin + leftCnt + 1, preEnd, mid + 1, inEnd, preorder, inorder, map);


        return curNode;
    }


}