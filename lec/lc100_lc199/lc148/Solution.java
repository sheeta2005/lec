package lc100_lc199.lc148;


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

    public ListNode sortList(ListNode head) {
        return sortMy(head);
    }


    ListNode searchMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;
        return rightStart;
    }


    ListNode sortMy(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode mid = searchMid(node);
        ListNode l = sortMy(node);
        ListNode r = sortMy(mid);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode pos1 = l;
        ListNode pos2 = r;
        ListNode dummy = new ListNode();
        ListNode cur = dummy; //直接指向dummy，不要new新节点
        while (pos1!= null && pos2!= null) {
            if (pos1.val < pos2.val) { // < 从小到大升序
                cur.next = pos1;
                pos1 = pos1.next;
            } else {
                cur.next = pos2;
                pos2 = pos2.next;
            }
            cur=cur.next;
        }
        //剩余部分接上
        cur.next = pos1 == null ? pos2 : pos1;
        return dummy.next;
    }

}