package learn.BinarySearch;

/**
 * @Description: 二分法代码实现，有两种实现方法。
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/1/5 13:20
 * @Version: V1.0
 **/

public class BinarySearch {

    // 第一种写法
    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // 第二种写法
    public int binarySearch2(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // Offer旋转数组的问题
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r = r - 1;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 12, 18, 44, 56};
        int target = 4;
        int res = (new BinarySearch()).binarySearch2(arr, target);
        System.out.println(res);
    }

}
