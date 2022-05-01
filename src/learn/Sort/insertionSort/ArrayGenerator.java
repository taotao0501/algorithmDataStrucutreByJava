package learn.Sort.insertionSort;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {
    }

    ; //不用生成对象，只有方法的类

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generateRandomArray(int n) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    // 逆有序数组
    public static Integer[] generateReverseOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = i;
        }
        return arr;
    }
}
