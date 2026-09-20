package lc100_lc199.lc102;


import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (deque.size()!=0){
            int size = deque.size();
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pos = deque.poll();
                if(pos.left != null){
                    deque.offer(pos.left);
                }
                if(pos.right != null){
                    deque.offer(pos.right);
                }
                list.add(pos.val);
            }
            res.add(list);
        }
        return res;
    }



}