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

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l>=r) return;

        //优化2:插入排序处理小规模的子数组,会提升算法性能,降低运行时间
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l+(r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

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

    public static void main(String[] args) {
        int n= 100000;
        Integer[] arr= ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2= Arrays.copyOf(arr,arr.length);
        Integer[] arr3= Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("SelectionSort",arr2);
        SortingHelper.sortTest("InsertionSort",arr3);
        SortingHelper.sortTest("MergeSort",arr);
    }
}
