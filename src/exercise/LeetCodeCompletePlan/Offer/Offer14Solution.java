package exercise.LeetCodeCompletePlan.Offer;

import java.util.Arrays;

/**
 * @Description: 用多种解法
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/10 15:13
 * @Version: V1.0
 **/

public class Offer14Solution {

    private int[] memo;

    public int cuttingRope(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than zero");
        }
        //优化1：记忆化搜索
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    //将 n 进行分割（至少分割为两部分）
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        //优化1：记忆化搜索
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        //优化1：记忆化搜索增加
        memo[n] = res;
        return res;
    }

    private int max3(int i, int j, int k) {
        return Math.max(Math.max(i, j), k);
    }

}
