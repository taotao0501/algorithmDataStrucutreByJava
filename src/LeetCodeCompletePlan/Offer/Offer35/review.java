package LeetCodeCompletePlan.Offer.Offer35;

/**
 * @Description: 35题复习 手敲三遍，终于完成
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/4/28 8:43
 * @Version: V1.0
 **/

public class review {

    public Node copyRandomListNode(Node head) {
        clone(head);
        setRandomNode(head);
        return extractClonedNode(head);
    }

    private void clone(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node clonedNode = new Node(pNode.val);
            clonedNode.next = pNode.next;
            clonedNode.random = null;
            pNode.next = clonedNode;
            pNode = clonedNode.next;
        }
    }

    private void setRandomNode(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node cloned = pNode.next;
            if(pNode.random != null) {
                cloned.random = pNode.random.next;
            }
            pNode = cloned.next;
        }
    }

    private Node extractClonedNode(Node head) {
        Node pNode = head;
        Node clonedHeadNode = null;
        Node clonedNode = null;
        if(pNode != null) {
            clonedNode = pNode.next;
            clonedHeadNode = clonedNode;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        while(pNode != null) {
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHeadNode;
    }
}
