package Sort.bubbleSort;

/**
 * @Description: 冒泡排序
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/9/19 16:36
 * @Version: V1.0
 **/

public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //优化1：如果完全有序的数组，则提前终止排序过程，优化从 O(n)级别的算法
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素

            boolean isSwapper = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    isSwapper = true;
                }
            }
            if (!isSwapper) {
                break;
            }
        }
    }

    //优化2：每次可能会确定多个数据的位置，而不是每次都只是一个，如果是一个有序的数组，那么O(n)
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素

            // lastSwapperIndex是交换位置后，后一个元素的索引
            int lastSwapedIndex = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    lastSwapedIndex = j + 1;
                }
            }
//            if(lastSwapedIndex == 0){
//                break;
//            }
            // i不仅是 轮数，而且是经过i轮之后有i个元素已经完成排序了。
            // 从lastSwapperIndex到后面所有的元素都已经排序
            //这个条件使得上面break条件失效，因为当 lastIndex ==0,i= arr.length,直接结束最外层的循环。
            i = arr.length - lastSwapedIndex;
        }
    }

    //作业：从后向前实现冒泡排序
    public static <E extends Comparable<E>> void sortFromBacktoFront(E[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; ) {
            //循环不变量：arr[0,i)已排好序，相当于前i个元素排好序了。我们每轮循环，只需要在arr[i]的位置上放上合适的元素就好了。
            //至于内层循环，j只需要从后向前遍历，每次比较data[j - 1]和data[j]就好
            int lastSwapperIndex = len - 1;
            for (int j = len - 1; j >= 1; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j - 1, j);
                    lastSwapperIndex = j - 1;
                }
            }
            i = lastSwapperIndex + 1;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = ArrayGenerator.generateRandomArray(n);
        //SortingHelper.sortTest("BubbleSort", arr);
        //需要30s, O(n^2)
        SortingHelper.sortTest("BubbleSortFromBackToFront", arr);
        //没我呢提
    }
}
