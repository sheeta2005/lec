package lc200_lc299.lc295;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((a, b) -> b - a);
        left.add(-100009);
        right.add(100009);
    }

    public void addNum(int num) {
        int l = left.size();
        int r = right.size();
        if (l - r == 1) {
            if (num > left.peek()) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        } else if (l == r) {
            if (num > right.peek()) {
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if ((left.size() + right.size()) % 2 == 0) {
            return (left.peek() + right.peek()) /2;
        } else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */