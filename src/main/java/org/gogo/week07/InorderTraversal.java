package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * @author liupenghui
 * @date 2021/7/18 4:11 下午
 */
public class InorderTraversal {

    public List<Integer> pp3(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public List<Integer> pp2(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public List<Integer> pp1(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        dfs1(node, res);
        return res;
    }

    public void dfs1(TreeNode node, List<Integer> res) {
        dfs1(node.left, res);
        res.add(node.val);
        dfs1(node.right, res);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        plan2(root);
        new InorderTraversal().bfs(root);
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

    /**
     * 2021 08 01 练习，深度优先搜索
     * @param root
     */
    public List<Integer> test(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        // 左-根-右
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    /**
     * 广度优先遍历
     * 思路是使用一个栈，栈的特性是先进后出，先讲根结点push栈中，接着处理左子树，左子树的所有节点都放到栈中，然后从栈中pop出节点，放到结果中，然后再将左子树也放大栈中，然后一直从栈中拿元素就行了
     * @param root
     * @return
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
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

}
