package lc100_lc199.lc155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class MinStack {
    Deque<Integer> deque;
    Deque<Integer> deque2;

    public MinStack() {
        deque = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
        deque2.push(Integer.MAX_VALUE);
    }

    public void push(int value) {
        deque.push(value);
        if (value <= deque2.peek()) {
            deque2.push(value);
        }
    }

    public void pop() {
        Integer peek = deque.peek();
        deque.pop();
        if (Objects.equals(peek, deque2.peek())) {
            deque2.pop();
        }


    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {

        return deque2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */