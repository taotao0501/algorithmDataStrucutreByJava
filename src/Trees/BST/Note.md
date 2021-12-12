# 二分搜索树(BST)理论笔记
> 动态数据结构由结点组成，结点包含的链接可以为null 或者指向其他结点。在BST中，
> 每个结点只有一个父结点（根结点特例，没有父结点），而且每个结点都只有左右两个链接，
>分别指向自己的左和右子结点。同时二叉树具有天然的递归结构，可以看作每个链接指向了另一个个二叉树，而
>这棵树的根结点就是被指向的结点。因此二叉树可以被定义为一个空链接，或者是一个有左右两个链接
>的结点，每一个链接都指向一棵（独立的）子二叉树。在BST中，每个结点还包含一个键和一个值，键之间
>也有顺序之分以支持高效的查找

定义：一棵BST，是一个二叉树，其中每个结点都含有一个Comparable的键，且每个结点的键都大于其
左子树的任意节点的键而小于右子树的任意结点的键。

## 1. BST 写法
### 1.1 向二分搜索树中添加一个元素的递归和非递归写法，
- 递归写法
```java
private Node add(Node node, E e) {
       if(node == null) {
           size ++;
           return new Node(e);
       }

       if( e.compareTo(node.e) < 0) {
           node.left = add(node.left, e);
       }
       else if(e.compareTo(node.e) > 0) {
           node.right = add(node.right, e);
       }
       return node;
    }
```
- 非递归写法
```java
pulic void add(E e) {
    if(root == null) {
        root = new Node(e);
        size ++;
        return
    }
    Node p = root;
    while(p != null) {
        if(e.compareTo())
        
    }   
}
```

可以联想到链表的添加元素的递归写法。
```java
head = new Node(e,head);
// 等同于下面
Node node = new Node(e);
node.next = head;
head = node;
```

### 1.2 前序遍历

#### 伪码以及思想

<img src="E:\MD_Note\算法\img\BST前序遍历思想.png" style="zoom:40%;" />

先访问根结点，然后访问左子树，再访问右子树。遍历的递归写法是 首先写递归终止的条件（与深度优先遍历和广度优先遍历一样）

```java
 private void preOrder(Node node){
        //先写遍历终止条件
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
```






