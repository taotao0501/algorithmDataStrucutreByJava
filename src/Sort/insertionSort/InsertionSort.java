package Sort.insertionSort;

import java.util.Arrays;

/**
 * @Description: 练习插入排序
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/9/19 14:45
 * @Version: V1.0
 **/

public class InsertionSort {
    private InsertionSort() {
    }

    ;

    /**
     * 循环不变量：arr[0,i)有序，arr[i,n)无序
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 小优化：找到arr[i]合适的位置，直接插入
            E t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        //1.是否正确排序
//        Integer[] test1 = {6,1,2,5,4,3,7};
//         InsertionSort.sort(test1);
//         for(Integer t:test1) {
//             System.out.println(t + " ");
//         }

        //2.分别用 10000 100000 的随机序列测试数据优化比较：
//        int[] dataSize = {10000, 100000};
//        for(int n:dataSize){
//            Integer[] arr = ArrayGenerator.generateRandomArray(n);
//            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("InsertionSort2", arr2);
//        }

        //3. 插入排序对于近似有序数组比所有的排序都要快一些。
//        int[] dataSize2 = {10000, 100000};
//        for(int n:dataSize2){
//            Integer[] randomArr = ArrayGenerator.generateRandomArray(n);
//            Integer[] nearlySortedArr = ArrayGenerator.generateOrderedArray(n);
//            System.out.println("------随机的数组");
//            SortingHelper.sortTest("InsertionSort2", randomArr);
//            System.out.println("------近乎有序的数组");
//            SortingHelper.sortTest("InsertionSort2", nearlySortedArr);
//        }

        //4. 降序数组排成升序数组
        int[] dataSize3 = {10000, 100000};
        for (int n : dataSize3) {
            Integer[] reverseSortedArr = ArrayGenerator.generateReverseOrderedArray(n);
            SortingHelper.sortTest("InsertionSort2", reverseSortedArr);
            SortingHelper.sortTest("SelectionSort", reverseSortedArr);
        }
    }

}
