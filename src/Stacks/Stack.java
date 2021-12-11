package Stacks;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/12/4 17:26
 * @Version: V1.0
 **/

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
