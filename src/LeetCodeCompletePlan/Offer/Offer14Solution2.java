package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/10 15:51
 * @Version: V1.0
 **/

public class Offer14Solution2 {

    public int cuttingRope(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n should");
        }
        // memo[i]定义：将数字i分割（至少分为两部分）后得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解memo[i]
            for (int j = 1; j < i; j++) {
                // j + (i-j)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private int max3(int i, int j, int k) {
        return Math.max(Math.max(i, j), k);
    }
}
