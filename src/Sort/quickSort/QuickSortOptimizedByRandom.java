package Sort.quickSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 使用随机选取切分元素解决第一版排序的缺陷
 * @Author: Bentao She
 * @Date: 2021/9/25 10:43
 * @Version: V1.0
 **/


public class QuickSortOptimizedByRandom {

    private QuickSortOptimizedByRandom() {
    }

    ;

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) return;
        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        //生成 [l, r] 之间的随机索引,随机选取切分元素，然后与左边第一个元素位置互换
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);
        //循环不变量： arr[l+1,j]<V; arr[j+1,r]>=v
        //初始 j=l，这样 arr[l+1,l]为空
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
        int n = 5000;
        //int n = 1000000;
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort", arr2);
        SortingHelper.sortTest("QuickSortRandom", arr);
    }

}
