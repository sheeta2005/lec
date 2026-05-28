package lc0_lc99.lc61;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int n = 0;
        ListNode count = head;
        while (count.next != null) {
            count = count.next;
            n++;
        }
        n++;
        if (n == 1) {
            return head;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        int headNum = n - k;
        int tailNum = n - k - 1;
        ListNode tail;
        ListNode oldHead = head;

        for (int i = 0; i < tailNum; i++) {
            head = head.next;
        }
        tail = head;
        head = tail.next;
        tail.next = null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = oldHead;
        return head;
    }

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
}