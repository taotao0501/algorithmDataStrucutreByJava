package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description 参考K神的题解
 * @Author harrypotterandsbt@gmail.com
 * @Date 2022/5/22
 */
public class Offer36 {

    TreeNode prev, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(TreeNode cur) {
        if(cur == null) {
            return;
        }
        dfs(cur.left);
        if(prev != null) {
            prev.right = cur;
        } else {
            prev = head;
        }
        cur.left = prev;
        prev = cur;
        dfs(cur.right);
    }
}
