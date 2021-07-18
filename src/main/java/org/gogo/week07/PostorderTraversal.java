package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupenghui
 * @date 2021/7/18 5:56 下午
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
