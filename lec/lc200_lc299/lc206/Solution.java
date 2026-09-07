package lc200_lc299.lc206;

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


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode nex = head;
        while (cur != null) {

            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
}

