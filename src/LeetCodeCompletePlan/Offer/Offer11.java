package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2022/1/15 18:43
 * @Version: V1.0
 **/
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
//
// 示例 1：
//
//
//输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
//
//输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 数组 二分查找
// 👍 488 👎 0

public class Offer11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while( l <= r) {
            int mid = l + (r-l)/2 ;
            if(numbers[mid] > numbers[r]) {
                l = mid + 1;
            }
            else if( numbers[mid] < numbers[r]){
                r = mid;
            }
            else {
                r = r -1;
            }
        }
        return numbers[l];
    }
}
