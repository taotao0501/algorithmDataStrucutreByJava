package Sort.mergeSort;

/**
 * @Description: 剑指offer51 暴力解法
 * @Author: Bentao She
 * @Date: 2021/9/21 14:21
 * @Version: V1.0
 **/


public class Offer51Solution1 {

    public int reversePairs(int[] nums) {
        int res = 0;
        for(int i=0; i< nums.length;i++ ){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]> nums[j]){
                    res ++;
                }
            }
        }
        return res;
    }
}
