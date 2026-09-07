package lc200_lc299.lc234;


import java.util.ArrayDeque;
import java.util.Deque;

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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque =new ArrayDeque<>();
        ListNode tn1r=head;
        while (tn1r!=null){
            deque.push(tn1r.val);
            tn1r=tn1r.next;
        }
        while (head!=null) {
            if (deque.pop()!= head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}