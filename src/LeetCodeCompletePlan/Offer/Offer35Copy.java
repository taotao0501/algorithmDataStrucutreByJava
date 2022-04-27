package LeetCodeCompletePlan.Offer;

/**
 * @Description: Offer35 复制 复杂链表
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/4/26 13:38
 * @Version: V1.0
 **/

public class Offer35Copy {

    public Node copyRandomList(Node head) {
        // 三步
        cloneNode(head);
        setRandomNode(head);
        return reConstruct(head);

    }

    // 有三种方法：
    // 1.第一种原版复制，先确定 next，然后找 random，由于random可能在前，也可能在后，所以每次都得从头开始开始找，所以时间复杂度是O(n^2)，
    // 2.使用哈希表记录原版的(N,N')，这样如果N的random指向s,那么N'的random指向对应s',时空复杂度都为O(n)，
    // 3. 最优解法

    // 1.克隆，首尾相连
    private void cloneNode(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node pCloned = new Node(pNode.val);
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    // 2. 设置 cloneNoded的random node
    private void setRandomNode(Node head) {
        Node pNode = head;
        while(pNode != null) {
            Node CloneNode = pNode.next;
            if(pNode.random != null) {
                CloneNode.random = pNode.random;
            }
            pNode = CloneNode.next;
        }
    }

    // 3. 取偶数的链表连在一起
    private Node reConstructNode(Node head) {
        Node pNode = head;
        Node newHead = pNode.next;
        while(newHead != null && newHead.next != null) {
            newHead.next = newHead.next.next;
            newHead = newHead.next;
        }
        return newHead;
    }

    // 3. 书上的解法
    private Node reConstruct(Node head) {
        Node pNode = head;
        Node pClonedHead = null;
        Node pClonedNode = null;
        if(pNode != null) {
            pClonedNode = pNode.next;
            pClonedHead = pClonedNode;
        }
        return null;
    }
}
