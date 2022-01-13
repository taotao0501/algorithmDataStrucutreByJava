package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2022/1/13 23:14
 * @Version: V1.0
 **/


public class Offer10Fibonacci {
    public int fib(int n) {
        if(n==0)
            return 0;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i =2; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
            memo[i] %= 1000000007;
        }
        return memo[n];
    }

}
