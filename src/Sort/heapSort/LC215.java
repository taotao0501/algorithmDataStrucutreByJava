package Sort.heapSort;

import java.util.PriorityQueue;

/**
 * @Description: 优先队列解决LeetCode 215号问题
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/11/13 16:22
 * @Version: V1.0
 **/
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104


public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pqMin.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (!pqMin.isEmpty() && nums[i] > pqMin.peek()) {
                pqMin.remove();
                pqMin.add(nums[i]);
            }
        }
        return pqMin.peek();
    }
}
