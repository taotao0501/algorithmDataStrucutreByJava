package Sort.heapSort.MinHeap;

import Sort.heapSort.MaxHeap.Array;

/**
 * @Description: 作业：最小堆的实现
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/11/13 14:44
 * @Version: V1.0
 **/

public class MinHeap<E extends Comparable<E>> {

    private Sort.heapSort.MaxHeap.Array<E> data;

    public MinHeap(int capacity) {
        data = new Sort.heapSort.MaxHeap.Array<>(capacity);
    }

    public MinHeap() {
        data = new Sort.heapSort.MaxHeap.Array<>();
    }

    public MinHeap(E[] arr) {
        data = new Array<E>(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1); i >= 0; i --) {
                siftDown(i);
            }
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index) {
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMin() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMin when heap is empty.");
        }
        return data.get(0);
    }

    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        siftDown(0);
        return ret;
    }

    public void siftDown(int k) {
        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if( j + 1 < data.getSize() && data.get( j + 1).compareTo(data.get(j)) < 0){
                j ++;
            }
            // 上面代码确保 data[j] 是 leftChild 和 rightChild 中的较小值
            if( data.get(k).compareTo(data.get(j)) < 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E repalce(E e) {
        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
