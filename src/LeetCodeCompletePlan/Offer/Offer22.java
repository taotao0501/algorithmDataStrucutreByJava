package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/25 17:17
 * @Version: V1.0
 **/

public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k; i++) {
            if (node2 == null) {
                return null;
            }
            node2 = node2.next;
        }
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}
