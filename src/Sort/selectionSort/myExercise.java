package Sort.selectionSort;

/**
 * @Description: 自己独立写选择排序算法
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2021/9/19 12:50
 * @Version: V1.0
 **/

public class myExercise {
    private myExercise() {
    }

    // 循环不变量：a[0,i) 已经排完序，a[i,n)未排序
    public static <E extends Comparable<E>> void selectionSort(E[] arr){
        for(int i=0; i< arr.length; i++){
            int minIndex =i;
            //原代码优化：即 j= i+1,而不是 j=i开始的
            for(int j=i+1; j< arr.length; j++){
                if(arr[j].compareTo(arr[minIndex])< 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,4,6,3,8,2,9};
        SelectionSort_GenericClass.sort(arr);
        for(int e:arr) {
            System.out.println(e + " ");
        }
        System.out.println();

        Student[] students = {new Student("alice",98),
                new Student("BoBo", 100),
                new Student("Charles",66)};

        SelectionSort_GenericClass.sort(students);
        for(Student s:students){
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
