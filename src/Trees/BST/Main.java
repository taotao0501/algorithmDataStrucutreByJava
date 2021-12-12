package Trees.BST;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/12/11 22:37
 * @Version: V1.0
 **/


public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums) {
            bst.add(num);
        }
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

//        bst.preOrder();

//        System.out.println();
//
//        System.out.println(bst);

//        bst.preOrderNR();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
    }
}
