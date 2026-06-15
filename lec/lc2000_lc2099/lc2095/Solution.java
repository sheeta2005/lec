package lc2000_lc2099.lc2095;


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

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (fast.next == null) {
                flag = true;
            }
        }
        if (flag) {
            last.next = slow.next;
        } else {
            if (slow.next != null) {
                slow.next = slow.next.next;
            } else {
                slow.next = null;
            }
        }

        return head;
    }
}