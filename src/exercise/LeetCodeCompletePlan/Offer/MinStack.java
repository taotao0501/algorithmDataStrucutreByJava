package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: Offer-31题
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/5/3 16:36
 * @Version: V1.0
 **/

public class MinStack {

    Deque<Integer> dataStack;
    Deque<Integer> recordMinStack;
    /** initialize your data structure here. */
    public MinStack() {
        // 数据栈
        dataStack = new ArrayDeque<>();
        // 辅助栈
        recordMinStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(recordMinStack.isEmpty()) {
            recordMinStack.push(x);
        } else {
            recordMinStack.push(Math.min(x, recordMinStack.getFirst()));
        }
    }

    public void pop() {
        dataStack.pop();
        recordMinStack.pop();
    }

    public int top() {
        return dataStack.getFirst();
    }

    public int min() {
        return recordMinStack.getFirst();
    }
}
