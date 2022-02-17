package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/17 11:31
 * @Version: V1.0
 **/

public class Offer21 {

    // 1.相当于暴力解决法
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        for (int i = 1; i < nums.length ; i++) {
            for(int j = i; j >= 1; j --) {
                if(isOdd(nums[j]) && !isOdd(nums[j-1])) {
                    swap(nums, j, j-1);
                }
            }
        }
        return nums;
    }

    //解法2 双指针
    public int[] exchange2(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int l = 0, r = nums.length - 1;
        while(l < r) {
            while(isOdd(nums[l]) && l < r) {
                l ++;
            }
            while(!isOdd(nums[r]) && r > l) {
                r --;
            }
            if(l < r) {
                swap(nums, l, r);
                l ++;
                r --;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isOdd( int num) {
        if(num == 0) {
            return true;
        } else if(num % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4, 80,81,50};
        int[] res = new Offer21().exchange(test);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }
    }
}
