package exercise.category.RecursAndBackstracking.LC90;

// 这个答案好！！

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        LinkedList<Integer> subset = new LinkedList<>();
        Arrays.sort(nums);

        dfs(nums, 0, subset);
        res.add(new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> subset) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.addLast(nums[i]);
            res.add(new ArrayList<>(subset));
            dfs(nums, i + 1, subset);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = (new Solution()).subsets(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}
