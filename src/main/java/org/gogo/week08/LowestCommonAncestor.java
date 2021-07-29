package org.gogo.week08;

import org.gogo.TreeNode;

/**
 * 二叉树的最近公共祖先
 * @author Redick
 * @date 2021/7/27 11:20 下午
 */
public class LowestCommonAncestor {


    TreeNode ans = null;

    public TreeNode test1(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root, p, q);
        return ans;
    }

    private boolean dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSon = dfs2(root.left, p, q);
        boolean rightSon = dfs2(root.right, p, q);
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) && (leftSon || rightSon))) {
            ans = root;
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }


    public TreeNode plan1(TreeNode root, TreeNode p, TreeNode q) {
        dsf1(root, p, q);
        return ans;
    }

    private boolean dsf1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSon = dsf1(root.left, p, q);
        boolean rightSon = dsf1(root.right, p, q);
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) && (leftSon || rightSon))) {
            ans = root;
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }
}
