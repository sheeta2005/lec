package lc2130;
import java.util.Deque;
import java.util.LinkedList;
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            int a = stack.removeFirst() + stack.removeLast();
            max = Math.max(a, max);
        }
        return max;
    }

}
