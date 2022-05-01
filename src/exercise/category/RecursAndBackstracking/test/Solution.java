package exercise.category.RecursAndBackstracking.test;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }


    public int getMin() {
        return minStack.pop();
    }
}



