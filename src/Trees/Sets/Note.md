# Set(集合)
## 1.BST是非常好的实现 "集合"的底层数据结构

```java
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
```
add不能重复添加，BST可以满足

## 2.链表实现集合
BST与链表都是动态数据结构



## 3.时间复杂度比较

|             | LinkedListSet | BSTSet（平均  最差，退化成链表） |
| ----------- | ------------- | -------------------------------- |
| 增 add      | O(n)          | O(logN)   O(n)  下同             |
| 查 contains | O(n)          |                                  |
| 删 remove   | O(n)          |                                  |

对于同样的数据，可以对应不同的BST

<img src="E:\MD_Note\算法\img\BST退化成链表.PNG" style="zoom:75%;" />





