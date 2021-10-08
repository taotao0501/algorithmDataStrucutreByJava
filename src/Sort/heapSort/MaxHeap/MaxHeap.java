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
        shiftUp(data.getSize() -1);
    }

    private void shiftUp(int k){
        //while(k > 0 && data.getSize())
    }

//    private void swap(E[] ){
//
//    }
}
