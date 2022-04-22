package Sort.mergeSort;

/**
 * @Description: 使用Mergesort的思想解决逆序对数问题
 * @Author: Bentao She
 * @Date: 2021/9/21 14:34
 * @Version: V1.0
 **/


public class offer51SolutionByMergeSort {

    private int res = 0;

    public int reversePairs(int[] nums) {
        res = 0;
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, temp);
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            } else {
                arr[k] = temp[i];
                i++;

            }
        }
    }


}
