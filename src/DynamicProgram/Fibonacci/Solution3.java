package DynamicProgram.Fibonacci;

import java.util.Arrays;
/**
 * @Description: 动态规划
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/13 17:12
 * @Version: V1.0
 **/

/**
 *
 */
//将原问题拆解成若干子问题，同时保存子问题的答案，使得每个子问题只求解一次，最终获得原问题的的答案。
// 递归问题→重叠问题→记忆化搜索(自顶向下的解决问题) 动态规划(自底向上的解决问题)

public class Solution3 {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 100000;
        Solution3 solution = new Solution3();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
    }
}
