package learn.LinkedLists;

/**
 * @Description: 实现链表 ，包括增、遍历、查询、修改和删除等操作
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/5/1 15:41
 * @Version: V1.0
 **/

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        //最后一个有e的Node
        public Node(E e) {
            this(e, null);
        }

        //最后的 null
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素e,非 常用操作，仅供练习
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index,");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //Node node = new Node(e);
            //node.next = prev.next;
            //prev.next = node;
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头新增元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作， 练习用:)
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index,");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作， 练习用:)
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index,");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contain(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 删除链表的第index(0-based)个位置，返回删除的元素
    // 在链表中不是一个常用的操作， 练习用:)

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index,");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        //这里for循环的遍历 遍历列表
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

}
