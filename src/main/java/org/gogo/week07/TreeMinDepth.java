package org.gogo.week07;

import org.gogo.TreeNode;

/**
 * 二叉树最小深度
 *
 * 最小深度是指 根节点到没有叶子结点的子树的深度（根节点到最近叶子结点的路径的节点数量）
 * @author liupenghui
 * @date 2021/7/22 7:58 下午
 */
public class TreeMinDepth {

    /**
     * 递归，深度优先遍历
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 当前层业务处理 + 进入下一层
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
