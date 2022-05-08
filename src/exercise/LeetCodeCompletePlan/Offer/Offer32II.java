package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayDeque;
/**
 * 每行数据放在一个数组里
 */

public class Offer32II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i --) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
