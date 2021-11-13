package Sort.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 快排思想解决剑指Offer40题 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @Author: Bentao She
 * @Date: 2021/10/4 18:43
 * @Version: V1.0
 **/

//并没有独立完成这个问题，太累了

public class SelectKOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }
        Random rnd = new Random();
        selectK(arr, 0, arr.length - 1, k - 1, rnd);

        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rnd){

        int p = partition(arr, l, r, rnd);

        if(k == p)
            return arr[p];

        if(k < p)
            return selectK(arr, l, p - 1, k, rnd);
        return selectK(arr, p + 1, r, k, rnd);
    }

    private int partition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        // a[l+1,i-1] <= V; a[j+1, r] >= V
        int i = l + 1, j = r;
        while(true){
            while(i <= j && arr[i] < arr[l]){
                i ++;
            }

            while(j >= i && arr[j] > arr[l]){
                j --;
            }

            if(i >= j) break;

            swap(arr, i, j);
            i ++;
            j --;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
