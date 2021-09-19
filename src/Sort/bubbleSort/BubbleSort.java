package Sort.bubbleSort;

/**
 * @Description: 冒泡排序
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/9/19 16:36
 * @Version: V1.0
 **/

public class BubbleSort {

    private BubbleSort(){}


    public static<E extends Comparable<E>> void sort(E[] arr){
        for(int i=0; i < arr.length -1; i++){
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素
            for(int j=0; j< arr.length-i-1; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr, j,j+1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //优化1：如果完全有序的数组，则提前终止排序过程，优化从 O(n)级别的算法
    public static<E extends Comparable<E>> void sort2(E[] arr){
        for(int i=0; i < arr.length -1; i++){
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素

            boolean isSwapper = false;
            for(int j=0; j< arr.length-i-1; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr, j,j+1);
                    isSwapper = true;
                }
            }
            if(!isSwapper) {
                break;
            }
        }
    }

    //优化2：每次可能会确定多个数据的位置，而不是每次都只是一个
    public static<E extends Comparable<E>> void sort3(E[] arr){
        for(int i=0; i < arr.length -1;){
            //循环不变量：arr[n-j,n)已排好序，通过一轮冒泡在 arr[n-i-1]位置上放上合适的元素

            // lastSwapperIndex是交换位置后，后一个元素的索引
            int lastSwapedIndex = 0;
            for(int j=0; j< arr.length-i-1; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr, j,j+1);
                    lastSwapedIndex = j+1;
                }
            }
//            if(lastSwapedIndex == 0){
//                break;
//            }
            // i不仅是 轮数，而且是经过i轮之后有i个元素已经完成排序了。
            // 从lastSwapperIndex到后面所有的元素都已经排序
            //这个条件是得上面 break条件失效，因为当 lastIndex ==0,i= arr.length,直接结束最外层得循环。
            i = arr.length - lastSwapedIndex;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n);
        SortingHelper.sortTest("BubbleSort", arr);
        //需要30s, O(n^2)
    }


}
