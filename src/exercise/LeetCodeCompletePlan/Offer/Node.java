package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description: Offer 35 复杂链表
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/4/26 13:40
 * @Version: V1.0
 **/

public class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public int getVal() {
        return this.val;
    }
}
