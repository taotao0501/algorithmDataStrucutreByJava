package Trees.BST;

import java.util.*;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/12/11 13:03
 * @Version: V1.0
 **/

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 增
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    // 原版add操作
//    public void add(E e) {
//        if( root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
//    }
//    private void add(Node node, E e) {
//        if(e.equals(node.e)) {
//            return;
//        } else if(e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    /**
     * 增操作：递归写法
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 增操作：非递归写法
     *
     * @param e
     */
    private void add2(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }
        Node p = root;
        while (p != null) {
            if (e.compareTo(p.e) < 0) {
                if (p.left == null) {
                    p.left = new Node(e);
                    size++;
                    return;
                }
                p = p.left;
            } else if (e.compareTo(p.e) > 0) {
                if (p.right == null) {
                    p.right = new Node(e);
                    size++;
                    return;
                }
                p = p.right;
            } else {
                return;
            }
        }
    }

    /**
     * 查：
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历：递归写法
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        //先写遍历终止条件
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历：非递归写法
     */
    public void preOrderNR() {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历：递归写法
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 中序遍历的非递归写法 head == root
     */
    public void inOrderNR(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            System.out.println(node.e + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    /**
     * 后续遍历：递归写法
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 后续遍历：非递归写法，使用两个栈
     *
     * @param head
     */
    public void postOrderNR(Node head) {
        if (head == null) {
            return;
        }
        Deque<Node> stack1 = new ArrayDeque<>();
        Deque<Node> stack2 = new ArrayDeque<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().e + " ");
        }
    }

    /**
     * 层序遍历:和前序遍历的结构很相似，一个是栈，一个是队列
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找BST最小元素：递归写法
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找BST最小元素：非递归写法
     *
     * @return
     */
    public E minimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.e;
    }

    /**
     * 寻找BST最小元素：递归写法,非递归就不写了，和上面一样
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        //递归终止条件:删除一个结点的就是将其 leftNode 和 rightNode 为null，同时
        // 没有
        if (node.left == null) {
            //保留右子树
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    private void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e) == 0
            // 分 左子树为null，右子树为null,左右都不为null
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            // 也可以用前驱结点

            //使用后继
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right); //removeMin并没有真正删除，因为删除的node变成successor了。
            size++;

            successor.left = node.left;
            node.left = node.right = null;
            size--;  //二者可以抵消
            return successor;

            //使用前驱
//            Node predecessor = maximum(node.left);
//            predecessor.left = removeMax(node.left);
//            predecessor.right = node.right;
//            node.left = node.right = null;
//            return predecessor;
        }
    }

    /**
     * floor操作：在BST中寻找 不大于定数值e的最大值
     * @param e
     * @return
     */
    public E floor(E e) {
        if(size ==0 || e.compareTo(minimum()) < 0) {
            return null;
        }
        Node floorNode = floor(root, e);
        return floorNode.e;
    }

    private Node floor(Node node, E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) == 0){
            return node;
        }

        if(e.compareTo(node.e) < 0){
            return floor(node.left,e);
        }

        //如果node 有可能是 e 的 floor结点，也有可能不是（存在比 node.e 大但是小于 e 的其余节点）
        // 需要尝试向node的右子树寻找一下
        Node tempNode = floor(node.right, e);
        if(tempNode != null){
            return tempNode;
        }
        return node;
    }

    /**
     * floor操作：在BST中寻找不小于定数值e的最小值
     * @param e
     * @return
     */
    public E ceil(E e){
        if(size == 0 || e.compareTo(root.e) > 0){
            return null;
        }
        Node ceilNode = ceil(root, e);
        return ceilNode.e;
    }

    private Node ceil(Node node, E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) == 0){
            return node;
        }

        if(e.compareTo(node.e) > 0){
            return ceil(node.right, e);
        }

        //如果node有可能是 e 的ceil结点，也有可能不是（存在比 node.e 小但是大于 e 的其余节点）
        // 需要尝试向node的左子树寻找一下
        Node tempNode = ceil(node.left, e);
        if(tempNode != null){
            return tempNode;
        }
        return node;
    }

    /**
     * 找排名为K的键（树中正好右k个小于它的键），做select需要重新维护一个变量
     * @return
     */
//    public E select(int k){
//        return select(root, k).e;
//    }
//
//    private Node select(Node node, int k){
//        if(node == null) {
//            return null;
//        }
//        int t = size( node.left );
//        if(t > k)
//
//    }

//    public int rank(){
//        return
//    }



    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        for(int i = 1; i < 10; i += 2)
            bst.add(i);

        System.out.print("floor : ");
        for(int i = 0; i <= 10; i ++)
            System.out.print(bst.floor(i) + " ");
        System.out.println();

        System.out.print("ceil  : ");
        for(int i = 0; i <= 10; i ++)
            System.out.print(bst.ceil(i) + " ");
        System.out.println();
    }














    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++) {
            res.append("--");
        }
        return res.toString();
    }
}
