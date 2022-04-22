package Queues;

/**
 * @Description: 基于动态数组实现普通队列
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/12/4 18:36
 * @Version: V1.0
 **/

public class ArrayQueue<E> implements Queue {

    private Array<E> array;

    public ArrayQueue(Array<E> array) {
        this.array = array;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty(Object o) {
        return false;
    }

    @Override
    public void enqueue(Object o) {

    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object getFront() {
        return null;
    }
}
