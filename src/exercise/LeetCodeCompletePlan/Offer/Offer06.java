package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/9 16:34
 * @Version: V1.0
 **/

public class Offer06 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    List<Integer> record = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int len = record.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = record.get(i);
        }
        return res;
    }

    //递归
    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        record.add(head.val);
    }

    //解法2 栈
    public int[] reversePrintByStack(ListNode head) {
        Deque<Integer> record2 = new ArrayDeque<>();
        while (head != null) {
            record2.push(head.val);
            head = head.next;
        }
        int len = record2.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = record2.pop();
        }
        return res;
    }

}
