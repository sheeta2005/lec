package lc0_lc99.lc25;

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


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode begin = head;
        ListNode end = head;
        ListNode temp = null;
        while (begin != null) {
            int a = k;
            while (a != 1) {
                end = end.next;
                a--;
            }
            //反转

            // 1 2 3 4 5
            begin.next = end.next;
            prev.next = end;
            while (a != -1) {
                temp = begin.next.next;
                begin.next.next = begin;
                begin = temp;
            }


        }

        return dummy.next;
    }
}

}
