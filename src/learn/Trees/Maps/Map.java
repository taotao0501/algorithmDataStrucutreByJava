package learn.Trees.Maps;

/**
 * @Description: 映射接口
 * @Author: Bentao She
 * @Date: 2021/12/19 15:36
 * @Version: V1.0
 **/

public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
