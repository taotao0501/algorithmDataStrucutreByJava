package Sort.mergeSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.InsertionSort;
import Sort.utils.SortingHelper;

import java.util.Arrays;

/**
 * @Description: 自底向上 MergeSort from Bottom to Up
 * @Author: Bentao She
 * @Date: 2021/9/21 9:09
 * @Version: V1.0
 **/

public class MergeSortBU {
    private MergeSortBU() {
    }

    ;

    public static <E extends Comparable> void sortBU(E[] arr) {

        //优化3：一次性创建辅助空间节省每次创建辅助空间的内存消耗
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        //遍历合并的区间长度, 1,2,4
        for (int sz = 1; sz < n; sz += sz) {
            //遍历合并的两个区间的起始位置i
            //具体合并 arr[i,i+sz-1] 和 [i+sz, Math.min(i+sz+sz-1, n-1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    private static <E extends Comparable> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }


    //优化：使用插入排序进行优化
    public static <E extends Comparable> void sortBU2(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;

        // 使用插入排序优化
        // 遍历一遍，对所有 arr[i, i + 15] 的区间，使用插入排序法
        for (int i = 0; i < n; i += 16)
            InsertionSort.sort(arr, i, Math.min(n - 1, i + 15));

        // 遍历合并的区间长度
        // 注意，sz 从 16 开始
        for (int sz = 16; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, i + sz + sz - 1]
            for (int i = 0; i + sz < n; i += sz + sz)
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
        }
    }

    public static void main(String[] args) {
        int n = 5000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort2", arr);
        SortingHelper.sortTest("MergeSortBU", arr2);
        SortingHelper.sortTest("MergeSortBU2", arr3);


    }

}
