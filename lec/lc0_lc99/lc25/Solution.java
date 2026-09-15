package lc0_lc99.lc25;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode begin = head;
        ListNode end = head;

        ListNode nextGroup = dummy;

        //dummy 1 2 3 4 5 6

        while (end != null) {
            end = begin;
            for (int i = 1; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }
            nextGroup .next= end;
            nextGroup = end.next;
            end.next=null;
            //dummy 1 2 3 4 5 6
            //开始转换
            ListNode pos2 = begin;
            ListNode prev = dummy;
            ListNode temp = head;
            while (pos2 != nextGroup) {

                temp = pos2.next;
                pos2.next = prev;
                prev = pos2;
                pos2 = temp;
            }

            begin.next = nextGroup;
            begin = nextGroup;

        }


        return dummy.next;
    }
}