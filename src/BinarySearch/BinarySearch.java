package BinarySearch;

/**
 * @Description: 二分法
 * @Author: Bentao She
 * @Date: 2021/12/27 22:58
 * @Version: V1.0
 **/


public class BinarySearch {

    public int search(int[] arr, int target) {
        // 在[l,r)中取值
        int l = 0, r=arr.length;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(target == arr[mid]){
                return mid;
            }
            else if(arr[mid] > target){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while( l <= r) {
            int mid = l + (r-l)/2 ;
            if(numbers[mid] > numbers[r]) {
                l = mid + 1;
            }
            else if( numbers[mid] < numbers[r]){
                r = mid;
            }
            else {
                r = r -1;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] test = {2,2,2,0};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.minArray(test));
    }
}
