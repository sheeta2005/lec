package lc0_lc99.lc19;


class Solution {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = new ListNode();
        if (head.next == null) {
            return null;
        }
        while (n != 0) {
            n--;
            fast = fast.next;

        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }
}