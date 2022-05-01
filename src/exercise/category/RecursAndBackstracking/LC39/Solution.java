package exercise.category.RecursAndBackstracking.LC39;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
//https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487910&idx=1&sn=2670aec7139c6b98e83ff66114ac1cf7&chksm=fb418286cc360b90741ed54fecd62fd45571b2caba3e41473a7ea0934f918d4b31537689c664&scene=21#wechat_redirect
//解法解决的是排列，而不是组合

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
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
        //这里的 i = index 就是去重，就是每一次的起点都不能包含之前已经用过的起点
        for (int i = index; i < candidates.length; i++) {
            //这个就是减枝
            if (target < candidates[i])
                continue;
            c.addLast(candidates[i]);
            recursion(candidates, i, c, target - candidates[i], res);
            c.removeLast();
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution()).combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : res)
            printList(list);
    }

}
