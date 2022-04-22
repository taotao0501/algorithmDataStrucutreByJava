package Array;

/**
 * @Description: create our own Array
 * @Author: Bentao She
 * @Date: 2021/12/2 23:13
 * @Version: V1.0
 **/


public class Array {
    private int[] data;
    //记录存储元素的个数
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast filed, Array is full.");
        }
        data[size] = e;
        size++;
    }

    public void insert(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Insert filed, Array is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
    }

}
