package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description: 47/48 未能通过 47,48
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/11 15:06
 * @Version: V1.0
 **/

public class Offer26Fail {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isSame(A, B)) {
            return true;
        }
        return (isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    // isSame用来判断两个子树是否相等。
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
