package Sort.quickSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.SortingHelper;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/9/23 23:02
 * @Version: V1.0
 **/


public class QuickSort {

    private QuickSort() {
    }

    ;

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        //循环不变量： arr[l+1,j]<V; arr[j+1,r]>=v
        //选取左边第一个，初始 j=l，这样 arr[l+1,l]为空
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                //扩展左边子数组
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 50000;
        //int n = 1000000;
        //Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort", arr2);
        SortingHelper.sortTest("QuickSort1", arr);

        // QuickSort要比MergeSort快一些，一方面Merge要比partition逻辑要复杂一些。
        //对于 n=50000 的有序序列，第一版本的快排直接堆栈溢出。因为其算法复杂度是 O(n^2)
    }
}
