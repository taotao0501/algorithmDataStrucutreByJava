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

### 1.3 中/后序遍历

```java
//中序
private void inOrder(Node node) {
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
//后续
private void postOrder(Node node) {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
```

### 1.4 快速的进行前后序遍历

遍历过程中，对于每一个节点，都会访问这个节点三次：

![](F:\Markdown_Note\算法\BST三种遍历思想.PNG)

1. 在访问其左子树之前会访问一次；

2. 访问其左子树之后又回到这个节点；

3. 访问其右子树之后又回到这个节点。
  **总共三次**

  三种遍历方式对应与上图中这个节点三个紫色的访问时机真正的对这个节点进行访问操作（打印输出这个节点的值）

  ![](F:\Markdown_Note\算法\BST遍历.PNG)

- 前序
  在每一次访问该节点的时候进行操作（打印输出）

- 中序

  在第二次访问该节点的时候进行操作

- 后序

  在第三次访问该节点的时候进行操作

### 1.5 三种遍历方式的迭代写法

1. 前序用一个栈

```java
public void preOrderNR() {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
```

2. 中序用一个栈
3. 


### 1.6 层序遍历
层序遍历与前序遍历的迭代写法相似，只是一个是用队列，一个是栈


### 2 BST删除元素
2.1 删除最大/最小元素
- 先递归写出找到最大/最小的元素

2.2 删除任意元素
删除只有左/右子结点的结点
Hibbard Deletion提出的方法删除左右都有孩子的结点：
思想：找到被删除结点的后继（右子树中最小的元素），然后后继替换被删除的结点，最后结点左子树是原来被删除结点的左子树
<img src="E:\MD_Note\算法\img\BST删除.PNG" style="zoom:100%;" />












