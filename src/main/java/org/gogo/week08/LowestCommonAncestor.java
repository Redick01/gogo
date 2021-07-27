package org.gogo.week08;

import org.gogo.TreeNode;

/**
 * @author Redick
 * @date 2021/7/27 11:20 下午
 */
public class LowestCommonAncestor {

    public TreeNode plan1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        dsf1(root, p, q, ans);
        return ans;
    }

    private boolean dsf1(TreeNode root, TreeNode p, TreeNode q, TreeNode ans) {
        if (root == null) {
            return false;
        }
        boolean leftSon = dsf1(root.left, p, q, ans);
        boolean rightSon = dsf1(root.right, p, q, ans);
        if ((leftSon && rightSon) || ((root.val == p.val || root.val == q.val) && (leftSon || rightSon))) {
            ans = root;
        }
        return leftSon || rightSon || (root.val == p.val || root.val == q.val);
    }
}
