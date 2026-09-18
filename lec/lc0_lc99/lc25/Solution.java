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
        ListNode cur ;
        ListNode prev ;
        ListNode temp ;
        ListNode nextGroupBegin = head;
        ListNode lastGroupEnd = dummy;
        ListNode begin ;
        ListNode end ;

        dummy.next = head;
        //dummy 1 2 3 4 5
        while (true) {
            begin=nextGroupBegin;
            end=nextGroupBegin;
            for (int i = 1; i < k; i++) {
                end=end.next;
                if (end==null){return dummy.next;}
            }
            nextGroupBegin=end.next;
            cur=begin;
            prev=nextGroupBegin;
            while (cur!=nextGroupBegin){
                temp= cur.next;
                cur.next=prev;
                prev=cur;
                cur=temp;
            }
            lastGroupEnd.next=end;
            lastGroupEnd=begin;
        }


    }
}