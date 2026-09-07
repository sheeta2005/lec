package lc100_lc199.lc142;


public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode pos1 = head;
        ListNode pos2 = head;
        while (pos1 != null) {
            pos1 = pos1.next;
            if (pos1 == null) {
                return null;
            }
            pos1 = pos1.next;
            pos2 = pos2.next;
            if (pos1 == pos2) {
                pos2=head;
                while (pos1!=pos2){
                    pos1=pos1.next  ;
                    pos2=pos2.next  ;
                }
                return pos2;
            }
        }
        return null;
    }
}
