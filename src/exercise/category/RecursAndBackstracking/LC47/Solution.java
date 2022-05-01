package exercise.category.RecursAndBackstracking.LC47;

// 有重复数字的序列，返回其说有可能的全排列

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);
        return res;
    }

    // p中保存了一个有 index-1 个元素的排列，现在要把 index放到 这个排列的末尾
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            res.add((LinkedList<Integer>) p.clone());
            System.out.println("res = " + res);
            return;
        }

        for (int i = 0; i < nums.length; i++)
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                System.out.println("-第" + i + "个元素 : 值为" + nums[i]);
                p.addLast(nums[i]);
                System.out.println("-----添加后 p=" + p);
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                System.out.println("-----回复后 p=" + p);
                used[i] = false;
            }
        System.out.println("-index=" + index + "结束");
        return;
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        List<List<Integer>> res = (new Solution()).permute(nums);
        for (List<Integer> list : res)
            printList(list);
    }
}
