package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树中和为某一值的路径,总共有两种解法，一个
 * @Author harrypotterandsbt@gmail.com
 * @Date 2022/5/21
 */
public class Offer34 {

    /**
     * 解法1：递减
     */
    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode node, int val) {
        if(node == null) {
            return;
        }
        val = val - node.val;
        list.add(node.val);
        if(val == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, val);
        dfs(node.right, val);
        list.remove(list.size() -1);
    }

    //还有一种解法，就是累加法

//    List<List<Integer>> res ;
//    List<Integer> list = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        res = new ArrayList<>();
//        dfs(root, 0, target);
//        return res;
//    }
//
//    private void dfs(TreeNode node, int val, int target) {
//        if(node == null) {
//            return;
//        }
//        val = val + node.val;
//        list.add(node.val);
//        if(val == target && node.left == null && node.right == null) {
//            res.add(new ArrayList<>(list));
//        }
//        dfs(node.left, val, target);
//        dfs(node.right, val, target);
//        list.remove(list.size() -1);
//    }
}
