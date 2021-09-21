package Sort.mergeSort;

import Sort.utils.ArrayGenerator;
import Sort.utils.InsertionSort;
import Sort.utils.SortingHelper;

import java.util.Arrays;

/**
 * @Description: Merge过程
 * @Author: Bentao She
 * @Date: 2021/9/20 20:54
 * @Version: V1.0
 **/


public class MergeSort {
    private MergeSort(){};

    //第一版本：
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l>=r) return;

        int mid = l+(r-l)/2;
        sort(arr, l, mid);
        sort(arr,mid+1, r);

        //代码优化1: 当子数组已经有序, arr[mid]<arr[mid+1],跳过Merge
        if(arr[mid].compareTo(arr[mid+1]) > 0){
            merge(arr, l, mid, r);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r+1);
        int i=l, j=mid+1;
        //每次循环为 arr[k]赋值,注意 temp与 arr有 l的偏移量
        for(int k=l; k<=r; k++){
            if(i>mid){
                arr[k] = temp[j-l];
                j++;
            }
            else if(j >r){
                arr[k] = temp[i-l];
                i++;
            }
            else if (temp[i-l].compareTo(temp[j-l]) >= 0){
                arr[k] = temp[j-l];
                j++;
            }
            else {
                arr[k] = temp[i-l];
                i++;
            }
        }
    }



    //优化版本
    public static <E extends Comparable> void sort2(E[] arr){

        //优化3：一次性创建辅助空间节省每次创建辅助空间的内存消耗
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort2(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable> void sort2(E[] arr, int l, int r, E[] temp){
        if (l >= r)
            return;
        //优化2:插入排序处理小规模的子数组,会提升算法性能,降低运行时间
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }
        //防止数组越界
        int mid = l + (r - l) / 2;
        sort2(arr, l, mid, temp);
        sort2(arr, mid + 1, r, temp);
        //优化1：判断 是否需要合并
        if(arr[mid].compareTo(arr[mid + 1]) > 0){
            merge2(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable> void merge2(E[] arr, int l, int mid, int r, E[] temp){
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i]; i ++;
            }
            else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i]; i ++;
            }
            else{
                arr[k] = temp[j]; j ++;
            }
        }
    }

    public static void main(String[] args) {
        int n= 100000;
        Integer[] arr= ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);
//        SortingHelper.sortTest("SelectionSort",arr2);
//        SortingHelper.sortTest("InsertionSort",arr3);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);


    }
}
