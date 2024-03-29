package org.gogo.week07;

import org.gogo.TreeNode;

/**
 * @author liupenghui
 * @date 2021/7/22 7:20 下午
 */
public class TreeMaxDepth {

    /**
     * 二叉树最大深度，深度优先搜索，求出左右子树最大深度，+1就是树的最大深度
     * @param root
     * @return
     */
    public int test2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = test1(root.left);
        int right = test1(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeMaxDepth maxDepth = new TreeMaxDepth();
        System.out.println(maxDepth.maxDepth(root));
    }

    public int test1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = test1(root.left);
            int right = test1(root.right);
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 深度优先遍历
     *
     * 做这道题遇到了禁忌情况，就是人肉递归，一定要避免
     *
     * 深度优先遍历 方式就是 计算左子树最大深度和右子树最大深度，然后取最大值+1就是二叉树的深度了
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
