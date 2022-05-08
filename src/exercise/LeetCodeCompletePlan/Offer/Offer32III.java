package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

/**
 * 之字形打印
 */

public class Offer32III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isleftToRight = true;
        while(!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i --) {
                TreeNode node = queue.poll();
                if(isleftToRight) {
                    temp.offerLast(node.val);
                } else {
                    temp.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            res.add(temp);
            isleftToRight = !isleftToRight;
        }
        return res;
    }
}
