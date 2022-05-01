package exercise.LeetCodeCompletePlan.Offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description: 需要大数运算
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/10 18:18
 * @Version: V1.0
 **/

public class Offer14IISolution3 {

    public int cuttingRope(int n) {
        BigInteger[] memo = new BigInteger[n + 1];
        Arrays.fill(memo, BigInteger.valueOf(1));
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                BigInteger secondPra = BigInteger.valueOf(j * (i - j));
                if (memo[i] == null) {
                    throw new IllegalArgumentException("Why secondPra became null");
                }
                memo[i] = memo[i].max(secondPra);
                memo[i] = memo[i].max(memo[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return memo[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        int res = (new Offer14IISolution3()).cuttingRope(8);
        System.out.println(res);
    }

}
