package LeetCodeCompletePlan.Offer;

/**
 * @Description: 反转链表
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/9 16:59
 * @Version: V1.0
 **/

public class Offer24 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //迭代法
    public ListNode reverseLis2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode nex = head.next;
            cur.next = prev;
            prev = head;
            cur = nex;
        }
        return prev;
    }


    // 递归法
    public ListNode reverseLis(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLis(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
