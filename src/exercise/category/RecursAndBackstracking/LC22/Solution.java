package exercise.category.RecursAndBackstracking.LC22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > right)
            return;

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    private static void printList(List<String> list) {
        for (String e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> result = (new Solution()).generateParenthesis(3);
        printList(result);
    }
}
