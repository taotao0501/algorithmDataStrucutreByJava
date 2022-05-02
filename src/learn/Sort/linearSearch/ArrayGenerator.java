package learn.Sort.linearSearch;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator(){}; //不用生成对象，只有方法的类

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++)
            arr[i] = i;
        return arr;
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i<n; i ++)
            arr[i] = rnd.nextInt();
        return arr;
    }
}
