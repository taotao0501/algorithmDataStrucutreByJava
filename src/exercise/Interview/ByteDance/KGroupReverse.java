package exercise.Interview.ByteDance;

// 字节25题 变种 不足K个也转
public class KGroupReverse {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dm = new ListNode(-1,head);
        ListNode prev = dm, end = prev;
        while(end!=null){
            for(int i=0; i<k && end!=null; i++){
                end = end.next;
            }
            if(end == null){
                //break;
                prev.next = reverse(prev.next);
            }
            else {
                ListNode nex = end.next;
                end.next = null;
                ListNode start = prev.next;
                prev.next = reverse(start);
                start.next = nex;

                prev = start;
                end = prev;
            }

        }

        return dm.next;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode rev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,6,7,8};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new KGroupReverse()).reverseKGroup(head, 3);
        System.out.println(head2);
    }
}
