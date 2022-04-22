package Sort.shellSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.SortingHelper;

import java.util.Arrays;
import java.util.Deque;

/**
 * @Description: 希尔排序法
 * @Author: Bentao She
 * @Date: 2021/9/20 11:19
 * @Version: V1.0
 **/

public class ShellSort {
    private ShellSort() {
    }

    ;

    // h序列：1, 2, 4, 8,
    public static <E extends Comparable<E>> void sort(E[] arr) {
        int len = arr.length;
        int h = len / 2;
        while (h >= 1) {
            for (int start = 0; start < h; start++) {
                // 对 arr[start, start + h, start + 2h, start + 3h ...], 进行插入排序
                for (int i = start + h; i < len; i += h) {
                    E t = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h)
                        arr[j] = arr[j - h];
                    arr[j] = t;
                }
            }
            h /= 2;
        }
    }

    //第二种方式:不需要分组后依次插入，直接就开始插入
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        int len = arr.length;
        int h = len / 2;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = t;
            }
            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        int len = arr.length;
        int h = 1;

        while (h < len)
            h = 3 * h + 1;
        // 1, 4, 13, 40 ...

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = t;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("ShellSort", arr);
        SortingHelper.sortTest("ShellSort3", arr2);
        //使用了新的步长序列，速度快一些。前者 3.3s，后者1.99s。

    }


}
