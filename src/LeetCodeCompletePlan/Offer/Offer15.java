package LeetCodeCompletePlan.Offer;

/**
 * @Description: 二进制中的1的人数 与 231题一致（https://leetcode-cn.com/problems/power-of-two/）
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/25 14:02
 * @Version: V1.0
 **/

public class Offer15 {

    // 解法1 无符号右移
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    // 解法2 n&(n-1)
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }

    //231题，2的幂
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}


