package Sort.quickSort;

/**
 * @Description: 使用快排的思想解决 Select K问题之一的 Leetcode 215题
 * @Author: Bentao She
 * @Date: 2021/10/4 10:33
 * @Version: V1.0
 **/

import java.util.Random;

/**
 总共有两道题，一个是 215-数组中第K个最大的元素
 另一个是 剑指Offer-40-数组中最小的K个元素
 */
public class SelectKSolutionLC215 {
    // 215题
    //使用 双路排序算法解题
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        Random rnd = new Random();
        int l = 0, r = nums.length-1;
        while(true){
            int index = partition(nums, l, r,rnd);
            if(index == target){
                return nums[index];
            }
            else if(index > target){
                r = index - 1;
            }
            else {
                l = index + 1;
            }
        }
    }

    private int partition(int[] nums, int l ,int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(nums, l, p);
        //循环不变量： arr[l+1,i-1] <= V ; arr[j+1,r]>=V
        int i = l + 1, j = r;
        while(true){
            while(i <= j && nums[i] < nums[l]){
                i ++;
            }
            while(j >= i && nums[j] > nums[l]){
                j --;
            }

            if(i >= j) break;

            swap(nums, i, j);
            i ++;
            j --;
        }

        swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
