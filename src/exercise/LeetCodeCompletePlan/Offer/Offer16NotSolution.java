package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description: x次幂 未理解。幂运算
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/25 18:10
 * @Version: V1.0
 **/

public class Offer16NotSolution {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
