package Sort.quickSort;

/**
 * @Description: leetcode 75题，使用三路快排的思想在 O(n)复杂度下解决问题
 * @Author: Bentao She
 * @Date: 2021/10/4 10:07
 * @Version: V1.0
 **/


public class SortColorSolution {
    public void sortColors(int[] nums) {
        //循环不变量是 nums[0,zero] == 0; nums[zero+1,i-1] ==1 ;nums[two,r]==2
        // zero表示的就是 lt, two表示的是 gt
        int zero = -1, i = 0, two= nums.length;
        while(i < two){
            if(nums[i] <1){
                zero ++;
                swap(nums, i, zero);
                i ++;
            }
            else if(nums[i] > 1){
                two --;
                swap(nums, i ,two);
            }
            else {
                i ++;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
