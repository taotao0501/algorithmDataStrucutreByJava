package learn.Queues;

/**
 * @Description: 队列接口
 * @Author: Bentao She
 * @Date: 2021/12/4 18:29
 * @Version: V1.0
 **/

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
