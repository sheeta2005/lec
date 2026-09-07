package lc100_lc199.lc160;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int ca = 0;
        int cb = 0;
        while (a != null) {
            a = a.next;
            ca++;
        }
        while (b != null) {
            b = b.next;
            cb++;
        }
        if (a != b) {
            return null;
        }
        a = headB;
        b = headA;
        if (ca < cb) {
            for (int i = 0; i < cb - ca; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < ca - cb; i++) {
                b = b.next;
            }
        }

        while (a != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;

    }

}
