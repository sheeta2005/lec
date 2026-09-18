//package lc100_lc199.lc146;
//
//import java.util.HashMap;
//
//
//public class LRUCache {
//    class ListNode {
//        int key;
//        int val;
//        ListNode prev;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    private int capacity;
//    private HashMap<Integer, ListNode> map;
//    private ListNode dummyHead;
//    private ListNode dummyTail;
//
//    public LRUCache(int capacity) {
//        dummyHead = new ListNode();
//        dummyTail = new ListNode();
//        dummyHead.next = dummyTail;
//        dummyTail.prev = dummyHead;
//        this.capacity = capacity;
//        map= new HashMap<>();
//    }
//
//
//    private void addToHead(ListNode node) {
//        ListNode temp = dummyHead.next;
//        dummyHead.next = node;
//        node.prev = dummyHead;
//        node.next = temp;
//        temp.prev = node;
//    }
//
//    private void moveToHead(ListNode node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//        addToHead(node);
//    }
//
//    private void removeTail() {
//        ListNode node = dummyTail.prev;
//        dummyTail.prev.prev.next = dummyTail;
//        dummyTail.prev = dummyTail.prev.prev;
//        map.remove(node.key);
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            ListNode node = map.get(key);
//            moveToHead(node);
//            return node.val;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            ListNode node = map.get(key);
//            node.val = value;
//            moveToHead(node);
//        } else {
//            if (capacity==map.size()){
//                removeTail();
//            }
//            ListNode node = new ListNode(key, value);
//            addToHead(node);
//            map.put(key, node);
//        }
//    }
//}
