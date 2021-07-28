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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        plan2(root);
    }

    public static List<Integer> plan1Test1(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        inorder1(node, res);
        return res;
    }

    public static void inorder1(TreeNode node, List<Integer> res) {
        // 左-根-右
        inorder1(node.left, res);
        res.add(node.val);
        inorder1(node.right, res);
    }

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
            // 将左子树先放到栈中
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

    public static List<Integer> test2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 迭代练习中序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> test3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> test4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
