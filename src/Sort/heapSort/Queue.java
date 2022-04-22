package Sort.heapSort;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/11/13 15:37
 * @Version: V1.0
 **/

public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
