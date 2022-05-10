package exercise.LeetCodeCompletePlan.Offer;

import java.util.Arrays;

/**
 * @Description 判断是否为后续遍历, 参考了别人的代码
 * @Author harrypotterandsbt@gmail.com
 * @Date 2022/5/10
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length <= 2) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length -1);
    }

    private boolean verifyPostorder(int[] arr, int left, int right) {
        if(left >= right) {
            return true;
        }
        int rootValue = arr[right];
        int i = left;
        while(i < right && arr[i] < rootValue) {
            i ++;
        }
        int j = i;
        for(; j < right; j ++){
            if(arr[j] < rootValue) {
                return false;
            }
        }

        if(!verifyPostorder(arr,left, i-1)) {
            return false;
        }
        if(!verifyPostorder(arr, i ,j -1)) {
            return false;
        }
        return true;

    }
}
