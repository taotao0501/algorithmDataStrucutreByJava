package learn.Sort.linearSearch;

/**
 * 1.在data数组中查找16，
 * 输入为数组和目标元素，输出为目标元素所在的索引；若不存在，返回-1
 */

public class LinearSearch {

    private LinearSearch(){} //把这个设为私有，这样外界就无法实例化这个类了，简直骚操作
    //如果是只有一个文件，既有实现方法也有main,可以将实现方法变成 static 方法
    public static <E> int search(E[] data, E target) {
        for(int i=0;i< data.length;i++) {
            if(data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Integer[] data={24,18,12,9,16,66,32,4};
        int[] dataSize = {1000000, 10000000};
        for(int n: dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            for(int k=0;k <100; k++)
                LinearSearch.search(data,n);
            long endTime = System.nanoTime();

            double time = (endTime-startTime) / 1000000000.0;
            System.out.println("n = "+ n + ", 100 runs: "+ time + " s");
        }
    }
}
