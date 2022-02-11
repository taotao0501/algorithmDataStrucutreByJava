package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/11 14:37
 * @Version: V1.0
 **/

public class Offer26 {
    //正确的解法
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) {
            return false;
        }
        if(recur(A,B)) {
            return true;
        }
        return (isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    // recur的功能是
    private boolean recur(TreeNode a, TreeNode b) {
        // if( a == null && b == null) {
        //     return true;
        // }
        // if( a == null || b == null) {
        //     return false;
        // }
        if( b == null)
            return true;
        if( a == null)
            return false;
        if( a.val != b.val) {
            return false;
        }
        return recur(a.left, b.left) && recur(a.right, b.right);
    }

}
