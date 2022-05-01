package learn.Sort.quickSort;

import learn.Sort.utils.ArrayGenerator;
import learn.Sort.utils.InsertionSort;
import learn.Sort.utils.SortingHelper;

import java.util.Arrays;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/9/25 9:18
 * @Version: V1.0
 **/


public class QucikSortOptimizedByInsertionSort {
    private QucikSortOptimizedByInsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // 使用 Insertion learn.Sort 优化
        if (r - l <= 7) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        E v = arr[l];

        // arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
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

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSortOptimizedByInsertion", arr2);
        // 一般而言，小数组的插入排序能够优化递归排序的高级算法。但是不同语言可能有差异，
        // 而且优化结果不一定很明显，或者可能适得其反。
    }
}
