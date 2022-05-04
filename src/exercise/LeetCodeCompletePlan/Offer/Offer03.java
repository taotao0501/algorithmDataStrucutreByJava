package exercise.LeetCodeCompletePlan.Offer;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2022/1/15 15:55
 * @Version: V1.0
 **/
//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表 排序
// 👍 674 👎 0

public class Offer03 {
    //方法1 哈希表
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        int count;
        for (int num : nums) {
            count = record.getOrDefault(num, 0) + 1;
            record.put(num, count);
            if (count > 1) {
                return num;
            }
        }

        return -1;
    }

    //长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内,
    // 参考https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/jian-zhi-offer-03-shu-zu-zhong-zhong-fu-42tp8/
    public int way2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
