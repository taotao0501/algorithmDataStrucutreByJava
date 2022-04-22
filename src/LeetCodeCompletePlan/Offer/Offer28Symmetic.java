package LeetCodeCompletePlan.Offer;

/**
 * @Description: 对称二叉树
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/13 17:34
 * @Version: V1.0
 **/

// 对称二叉树：只有一个根结点的也可以，左右为null，如果有多个结点，那么必须两个结点是相等的，然后再比较一个的左结点，一个的右结点
//首先向确认 一个结点
public class Offer28Symmetic {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }
}
