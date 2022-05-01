package learn.Sort.mergeSort;

/**
 * @Description: 规范写法, 不需要维护一个全局变量 res,更加规范。
 * @Author: Bentao She
 * @Date: 2021/9/21 15:31
 * @Version: V1.0
 **/


public class offer51SolutionByMergeFormally {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return sort(nums, 0, nums.length - 1, temp);
    }

    private int sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return 0;

        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(arr, l, mid, temp);
        res += sort(arr, mid + 1, r, temp);
        if (arr[mid] > arr[mid + 1]) {
            res += merge(arr, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1, res = 0;

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
        return res;
    }
}
