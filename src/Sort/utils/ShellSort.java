package Sort.utils;

import java.util.Arrays;

public class ShellSort {

    private ShellSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        int h = data.length / 2;
        while(h >= 1){

            for(int start = 0; start < h; start ++){
                // 对 data[start, start + h, start + 2h, start + 3h ...], 进行插入排序
                for(int i = start + h; i < data.length; i += h){
                    E t = data[i];
                    int j;
                    for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                        data[j] = data[j - h];
                    data[j] = t;
                }
            }
            h /= 2;
        }
    }

    //换种方式：不用先分组，直接开始插入排序，省去循环，但是复杂度不变
    public static <E extends Comparable<E>> void sort2(E[] data){
        int h = data.length / 2;
        while(h >= 1){

            for(int i = h; i < data.length; i ++){
                E t = data[i];
                int j;
                for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }

            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data){
        int h = 1;
        while(h < data.length) {
            h = 3 * h + 1;
        }
        // 1, 4, 13, 40 ...
        while(h >= 1){
            for(int i = h; i < data.length; i ++){
                E t = data[i];
                int j;
                for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {

//        int n = 100000;
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("ShellSort", arr);
//        SortingHelper.sortTest("InsertionSort", arr2);
        SortingHelper.sortTest("MergeSort", arr3);

        //10000级别的数据，Shell与 Merge 相当，但是一旦数据变成 百万级别，Merge要快于 Shell,
    }
}
