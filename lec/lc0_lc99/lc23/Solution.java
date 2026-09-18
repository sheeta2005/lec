package lc0_lc99.lc23;
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int offset = 10000;
        int[] arr = new int[20001];
        for (ListNode head : lists) {
            ListNode p = head;
            while (p != null) {
                arr[p.val + offset]++;
                p = p.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            for(int j = 0; j < count; j++){
                int realVal = i - offset;
                cur.next = new ListNode(realVal);
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
