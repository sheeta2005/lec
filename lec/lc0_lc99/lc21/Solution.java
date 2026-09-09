package lc0_lc99.lc21;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode a = list1;
        ListNode b = list2;

        while(a != null && b != null){
            if(a.val < b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        if(a != null){
            cur.next = a;
        }else{
            cur.next = b;
        }
        return head.next;
    }
}
