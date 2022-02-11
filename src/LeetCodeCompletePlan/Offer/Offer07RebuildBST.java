package LeetCodeCompletePlan.Offer;

/**
 * @Description: 重建二叉树
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/10 10:36
 * @Version: V1.0
 **/

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 思路：在前序数组中分布是 [root,左子树... ,右子树... ]，中序数组[左子树...,root,右子树]，且中序是有序的。preorder第一个元素为root,在inorder里找root,在其之前的的为左子树（长l1）,在之后的为右子树（长l2）。
 */

public class Offer07RebuildBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    //递归
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,
                                 int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }
        //获取root结点在preorder的索引，就是第一个
        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int leftSubTreeSize = inorderRoot - inorderLeft;

        root.left = myBuildTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + leftSubTreeSize, inorderLeft, inorderRoot-1);
        root.right = myBuildTree(preorder,inorder,
                preorderLeft + 1 + leftSubTreeSize, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

}
