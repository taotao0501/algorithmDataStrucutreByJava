package Sort.quickSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 三路快排
 * @Author: Bentao She
 * @Date: 2021/10/3 22:43
 * @Version: V1.0
 **/


public class QuickSort3ways {

    private QuickSort3ways() {
    }

    ;

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        //循环不变量： arr[l+1,lt] < V; arr[lt+1,i-1] == V ; arr[gt,r] > V
        //初始值使得所有区间初始时都为空
        int lt = l, i = l + 1, gt = r + 1;
        //当 i == gt 遍历结束
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else { // arr[i] == arr[l]
                i++;
            }
        }
        swap(arr, l, lt);
        // arr[l,lt-1] < V; arr[lt,gt-1] == V ; arr[gt,r] > V
        sort(arr, l, lt - 1, random);
        sort(arr, gt, r, random);
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;

        //随机数组
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSortRandom", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        //有序数组
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSortRandom", arr2);
        SortingHelper.sortTest("QuickSort2Ways", arr);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        //元素相同
        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSortRandom", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

    }


}
