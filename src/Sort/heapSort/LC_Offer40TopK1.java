package Sort.heapSort;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Description: 适用Java标准库中的 优先队列（）
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/11/13 15:52
 * @Version: V1.0
 **/

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000

    // 使用最大堆作为容器，Java标准库默认是最小堆

public class LC_Offer40TopK1 {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i ++) {
            pqMax.add(arr[i]);
        }

        for(int i = k; i < arr.length; i ++) {
            if( !pqMax.isEmpty() && arr[i] < pqMax.peek()) {
                pqMax.remove();
                pqMax.add(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k ; i++) {
            res[i] = pqMax.remove();
        }
        return res;
    }
}
