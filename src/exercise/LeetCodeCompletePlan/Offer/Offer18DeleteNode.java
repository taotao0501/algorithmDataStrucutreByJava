package exercise.LeetCodeCompletePlan.Offer;



public class Offer18DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dm = new ListNode(0, head);
        ListNode prev = dm;
        ListNode cur = head;
        while(cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        if(cur != null){
            prev.next = cur.next;
        }

        return dm.next;
    }

}
