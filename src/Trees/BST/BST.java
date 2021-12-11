package Trees.BST;

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

    public boolean isEmpty(){
        return size == 0;
    }

    public void add( E e) {
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
    // 优化后的 add操作 递归写法
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

    // add 非递归写法
    private void add2(E e) {
        if(root == null){
            root = new Node(e);
            size ++;
            return;
        }
        Node p = root;
        while(p != null){
            if(e.compareTo(p.e) < 0){
                if(p.left == null){
                    p.left = new Node(e);
                    size ++;
                    return;
                }
                p = p.left;
            }
            else if(e.compareTo(p.e) > 0){
                if(p.right == null){
                    p.right = new Node(e);
                    size ++;
                    return;
                }
                p = p.right;
            }
            else {
                return;
            }
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }
        else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }
        else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
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
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
