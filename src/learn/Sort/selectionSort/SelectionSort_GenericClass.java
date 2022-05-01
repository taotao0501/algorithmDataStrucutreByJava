package learn.Sort.selectionSort;

/**
 * 时间复杂度是 O（n^2)
 */
public class SelectionSort_GenericClass {

    private SelectionSort_GenericClass() {
    }

    ;

    //思想： 循环不变量 arr[i....n)未排序， arr[0..i)已经排序
    // arr[i...n)中的最小值要放到 arr[i]的位置
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //选择 arr[i...n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 6, 3, 8, 2, 9};
        SelectionSort_GenericClass.sort(arr);
        for (int e : arr) {
            System.out.println(e + " ");
        }
        System.out.println();

        Student[] students = {new Student("alice", 98),
                new Student("BoBo", 100),
                new Student("Charles", 66)};

        SelectionSort_GenericClass.sort(students);
        for (Student s : students) {
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
