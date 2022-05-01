package exercise.category.RecursAndBackstracking.LC40;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//每个元素只能使用一次

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> c = new LinkedList<>();

        recursion(candidates, 0, c, target, res);
        return res;
    }

    // index表示 起始begin
    // sum数组存储了元素和为 target
    private void recursion(int[] candidates, int index, LinkedList<Integer> c, int target, ArrayList<List<Integer>> res) {
        if (target == 0) {
            res.add((LinkedList<Integer>) c.clone());
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //这个就是减枝
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (target >= candidates[i]) {
                c.addLast(candidates[i]);
                recursion(candidates, i + 1, c, target - candidates[i], res);
                c.removeLast();
            }

        }
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution()).combinationSum(new int[]{2, 5, 2, 1, 2}, 5);
        for (List<Integer> list : res)
            printList(list);
    }

}
