package lc100_lc199.lc199;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (deque.size() != 0) {
            int size =deque.size();
            int curVal = -1;
            for (int i = 0; i<size; i++) {
                TreeNode pos = deque.poll();
                if (pos.left != null) {
                    deque.offer(pos.left);
                }
                if (pos.right != null) {
                    deque.offer(pos.right);
                }
                curVal = pos.val;
            }
            list.add(curVal);
        }
        return list;
    }
}