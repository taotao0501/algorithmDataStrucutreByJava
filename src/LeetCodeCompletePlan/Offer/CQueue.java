package LeetCodeCompletePlan.Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/13 11:08
 * @Version: V1.0
 **/

public class CQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    public CQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        while(stackIn.size() > 0){
            stackOut.push(stackIn.pop());
        }
        if(stackOut.size() > 0){
            return stackOut.pop();
        }
        return -1;
    }
}
