package Sort.quickSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 双路快排
 * @Author: Bentao She
 * @Date: 2021/10/3 21:04
 * @Version: V1.0
 **/

public class QuickSort2ways {

    private QuickSort2ways(){};

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random){
        if( l >= r) return;
        int p = partition2(arr,l,r,random);
        sort(arr,l, p-1, random);
        sort(arr, p+1, r, random);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random random){
        //生成 [l, r] 之间的随机索引,随机选取切分元素，然后与左边第一个元素位置互换
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        //循环不变量： arr[l+1,i-1] <=v; arr[j+1,r]>=v .分散在两边
        int i = l + 1, j = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) <0){
                i ++;
            }
            while(j>=i && arr[j].compareTo(arr[l]) >0){
                j --;
            }
            if(i >= j) break;

            swap(arr, i ,j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;

        //随机数组
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSortRandom", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();

        //有序数组
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr,arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSortRandom", arr2);
        SortingHelper.sortTest("QuickSort2Ways",arr);
        System.out.println();

        //元素相同
        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSortRandom", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();
    }
}


