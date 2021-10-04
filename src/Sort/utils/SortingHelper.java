package Sort.utils;

import Sort.mergeSort.MergeSortBU;
import Sort.mergeSort.MergeSortTrack;
import Sort.mergeSort.MergeSort;
import Sort.quickSort.QucikSortOptimizedByInsertionSort;
import Sort.quickSort.QuickSort2ways;
import Sort.quickSort.QuickSort3ways;

public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++)
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){

        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSortTrack")){
            MergeSortTrack.sort(arr);
        }
        else if (sortname.equals("MergeSort2")){
            MergeSort.sort2(arr);
        }
        else if(sortname.equals("MergeSortBU"))
            MergeSortBU.sortBU(arr);
        else if(sortname.equals("MergeSortBU2"))
            MergeSortBU.sortBU2(arr);
        else if(sortname.equals("QuickSort1")){
            Sort.quickSort.QuickSort.sort(arr);
        }
        else if(sortname.equals("QuickSortRandom")){
            Sort.quickSort.QuickSortOptimizedByRandom.sort(arr);
        }
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSortOptimizedByInsertion"))
            QucikSortOptimizedByInsertionSort.sort(arr);
        else if(sortname.equals("QuickSort2Ways"))
            QuickSort2ways.sort(arr);
        else if(sortname.equals("QuickSort3Ways"))
            QuickSort3ways.sort(arr);
        else if(sortname.equals("HeapSort"))
            HeapSort.sort(arr);
        else if(sortname.equals("BubbleSort"))
            BubbleSort.sort(arr);
        else if(sortname.equals("ShellSort"))
            ShellSort.sort2(arr);
        else if(sortname.equals("ShellSort3"))
            Sort.shellSort.ShellSort.sort3(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}