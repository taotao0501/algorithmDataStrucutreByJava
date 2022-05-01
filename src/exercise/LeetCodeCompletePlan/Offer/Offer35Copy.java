package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description: Offer35 复制 复杂链表
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/4/26 13:38
 * @Version: V1.0
 **/

public class Offer35Copy {

    public Node copyRandomListNode(Node head) {

        clonedListNode(head);
        setRandomNode(head);
        return extractClonedNode(head);

    }

    private void clonedListNode(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node clonedNode = new Node(pNode.val);
            clonedNode.next = pNode.next;
            clonedNode.random = null;// 显示指定，也可以不写
            pNode.next = clonedNode;
            pNode = clonedNode.next;
        }
    }

    private void setRandomNode(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node clonedNode = pNode.next;
            if(pNode.random != null) {
                clonedNode.random = pNode.random.next;
            }
            pNode = clonedNode.next;
        }
    }

    private Node extractClonedNode(Node head) {
        Node pNode = head;
        Node clonedHeadNode = null;
        Node clonedNode = null;

        if(pNode != null){
            clonedNode = pNode.next;
            clonedHeadNode = clonedNode;
            pNode.next = clonedNode.next;
            pNode = clonedNode.next;
        }

        while(pNode != null) {
            // 现在cloneNode就是clonedHeadNode
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHeadNode;
    }
}
