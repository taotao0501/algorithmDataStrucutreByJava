package Sort.heapSort.MaxHeap;

/**
 * @Description: 最大堆实现
 * @Author: Bentao She
 * @Date: 2021/10/5 8:57
 * @Version: V1.0
 **/


public class MaxHeap<E extends Comparable<E>> {
    /**
     * 第一阶段：基本组件
     */
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // Heapify实现为一个构造函数
    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        if(arr.length != 1){
            for (int i = parent(arr.length - 1); i >= 0 ; i --) {
                siftDown(i);
            }
        }
    }





    //返回堆中元素个数
    public int size(){
        return data.getSize();
    }

    //判断堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引(从0开始)所表示的元素的父亲的节点
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1)/2;
    }

    //返回完全二叉树的数组表示中，一个索引(从0开始)所表示的元素的左孩子的节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引(从0开始)所表示的元素的右孩子的节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 第二阶段：向堆中添加元素 Shift up
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() -1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() -1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // siftDown的逻辑将数组最后一个元素放到 堆顶，这样确保 完全二叉树的性质不变。然后再siftDown
    private void siftDown(int k) {
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j ++;
            }
            //上面代码确保 data[j] 是 leftChild 和 rightChild 中的最大值
            if( data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }




}
