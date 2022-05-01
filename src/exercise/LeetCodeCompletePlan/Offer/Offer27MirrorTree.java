package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/11 15:22
 * @Version: V1.0
 **/

public class Offer27MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftTree = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(leftTree);
        return root;
    }
}
