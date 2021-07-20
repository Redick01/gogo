package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author liupenghui
 * @date 2021/7/18 5:56 下午
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        plan3(root);
    }

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

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> plan2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        while (root != null || !stack.isEmpty()) {
            // 左-右-根
            // 左子树处理
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 右子树处理
            root = stack.pop();
            if (root.right == null || root.right == node) {
                res.add(root.val);
                node = root;
                root = null;
            } else {
                // 存在右子树，将节点放入栈中，并处理右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public static List<Integer> test3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = null;
        while (root != null || !stack.isEmpty()) {
            // 左子树处理
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root == node || root.right == null) {
                res.add(root.val);
                node = root;
                root = null;
            } else {
                // 处理右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 迭代法2
     * 1、模仿前序遍历
     * 2、稍微改动一下，将前序遍历的序改为根-右-左
     * 3、将数组反转就得到了结果
     */
    public static List<Integer> plan3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
