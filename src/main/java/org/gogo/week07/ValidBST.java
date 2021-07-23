package org.gogo.week07;

import org.gogo.TreeNode;

/**
 * 验证二叉搜索树
 * @author liupenghui
 * @date 2021/7/22 4:22 下午
 */
public class ValidBST {

    public boolean test1(TreeNode root) {
        return test1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean test1(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return test1(root.left, lower, root.val) && test1(root.right, root.val, upper);
    }

    /**
     * 二叉搜索树
     * 左子树所有节点均小于跟节点，右子树的所有节点均大于根节点
     * 1、终止条件是root==null和根节点小于低位数值或根节点大于高位数值
     * 2、如果root==null 是二叉搜索树
     * 3、根节点小于低位数值或根节点大于高位数值不是二叉搜索树
     * 4、定义高低位数值，目的是比较左右子树与根节点的大小
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        // 左子树处理，低位不变，高位为每次递归的根节点，根节点满足大于所有左子树节点结果是true否则是false
        // 右子树处理，高位不变，低位为每次递归的跟界定，跟节点满足小于所有右子树节点结果是true否则是false
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
