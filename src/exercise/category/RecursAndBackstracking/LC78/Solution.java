package exercise.category.RecursAndBackstracking.LC78;

// https://leetcode-cn.com/problems/subsets/solution/shou-hua-tu-jie-zi-ji-hui-su-fa-xiang-jie-wei-yun-/
//// 第1种思路

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        LinkedList<Integer> subset = new LinkedList<>();
        getSubsets(nums, 0, subset);

        return res;
    }


    private void getSubsets(int[] nums, int index, LinkedList<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // 不加
        getSubsets(nums, index + 1, subset);

        // 加入
        subset.addLast(nums[index]);
        getSubsets(nums, index + 1, subset);
        subset.removeLast();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution()).subsets(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}