package Sort.selectionSort;

public class SelectionSort {
    private SelectionSort(){};

    //思想： 循环不变量 arr[i....n)未排序， arr[0..i)已经排序
    // arr[i...n)中的最小值要放到 arr[i]的位置
    public static void sort(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            //选择 arr[i...n)中的最小值的索引
            int minIndex=i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,3,8,2,9};
        SelectionSort.sort(arr);
        for(int e:arr) {
            System.out.println(e + " ");
        }
        System.out.println();
    }
}
