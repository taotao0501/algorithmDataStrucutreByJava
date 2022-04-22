package Trees.Sets;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/12/19 14:09
 * @Version: V1.0
 **/

public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
