package learn.DynamicProgram.Fibonacci;

/**
 * @Description: 直接超时，因为有很多重复子计算
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/13 17:09
 * @Version: V1.0
 **/

public class Solution1 {
    private int num = 0;

    public int fib(int n) {

        num++;

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {

        int n = 42;

        Solution1 solution = new Solution1();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }
}
