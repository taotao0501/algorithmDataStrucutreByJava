package LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: offer17题
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/4/20 12:42
 * @Version: V1.0
 **/

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// n为正整数

public class Offer17print1ToMaxN {

    private static char[] numbers = {'0', '1', '2', '3', '4', '5' , '6', '7', '8', '9'};
    List<Integer> result;

    public int[] printNumbers(int n) {
        result = new ArrayList<>();
        dfs(n, "", result);
        result.remove(0);
        int[] res = result.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    private void dfs(int n, String str, List<Integer> result) {
        if(str.length() == n) {
            result.add(Integer.parseInt(str));
            return;
        }
        for(Character c : numbers) {
            dfs(n, str + c, result);
        }
    }

}
