package lc0_lc99.lc24;


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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null){
            ListNode slow = pre.next;
            ListNode fast = pre.next.next;
            ListNode temp = fast.next;

            fast.next = slow;
            slow.next = temp;
            pre.next = fast;

            pre = slow;
        }
        return dummy.next;
    }
}

