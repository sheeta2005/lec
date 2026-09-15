package lc100_lc199.lc138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
        hashMap.put(null, null);
        Node dummy = new Node(0);
        Node t1 = head;
        while (t1 != null) {
            hashMap.put(t1, new Node(t1.val));
            t1 = t1.next;
        }
        dummy.next = hashMap.get(head);
        while (head != null) {
            Node cur = hashMap.get(head);
            cur.next=hashMap.get(head.next);
            cur.random=hashMap.get(head.random);
            head=head.next;
        }
        return dummy.next;
    }
}