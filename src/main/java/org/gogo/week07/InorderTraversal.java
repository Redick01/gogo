package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liupenghui
 * @date 2021/7/18 4:11 下午
 */
public class InorderTraversal {

    /**
     * 方法1 递归
     * @param node
     * @return
     */
    public static List<Integer> plan1(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        return list;
    }

    public static void inorder(TreeNode node, List<Integer> res) {
        // 终止条件
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    /**
     * 方法2 迭代
     * @param root
     * @return
     */
    public static List<Integer> plan2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            // 处理右边
            root = root.right;
        }
        return result;
    }
}
