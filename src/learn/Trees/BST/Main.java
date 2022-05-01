package learn.Trees.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/12/11 22:37
 * @Version: V1.0
 **/


public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 8, 4, 2};
//        for (int num : nums) {
//            bst.add(num);
//        }
//        /////////////////
//        //      5      //
//        //    /   \    //
//        //   3    6    //
//        //  / \    \   //
//        // 2  4     8  //
//        /////////////////
//
////        bst.preOrder();
//
////        System.out.println();
////
////        System.out.println(bst);
//
////        bst.preOrderNR();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        System.out.println(bst.minimum());
//        System.out.println(bst.minimumNR());
        Random random = new Random();
        int n = 1000;

        // test removeMin
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        List<Integer> nums = new ArrayList<>();
//        while(!bst.isEmpty()){
//            nums.add(bst.removeMin());
//        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMin test completed.");


        // test removeMax
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        nums = new ArrayList<>();
//        while(!bst.isEmpty()) {
//            nums.add(bst.removeMax());
//        }

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMax test completed.");
    }
}
