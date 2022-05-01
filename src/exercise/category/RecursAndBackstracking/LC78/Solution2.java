package exercise.category.RecursAndBackstracking.LC78;

// https://leetcode-cn.com/problems/subsets/solution/shou-hua-tu-jie-zi-ji-hui-su-fa-xiang-jie-wei-yun-/
// 第二种思路

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        LinkedList<Integer> subset = new LinkedList<>();
        dfs(nums, 0, subset);
        res.add(new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> subset) {
        // 注意这里 i= index
        // 在执行子递归之前，加入解集，即，在递归压栈前 “做事情”。
        for (int i = index; i < nums.length; i++) {
            subset.addLast(nums[i]);
            res.add(new ArrayList<>(subset));
            dfs(nums, i + 1, subset);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution2()).subsets(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}
