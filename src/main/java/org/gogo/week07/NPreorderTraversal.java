package org.gogo.week07;

import org.gogo.Node;

import java.util.*;

/**
 * N叉树前序遍历
 * @author liupenghui
 * @date 2021/7/20 9:53 下午
 */
public class NPreorderTraversal {

    public List<Integer> pp2(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            Node cur = deque.removeLast();
            list.add(cur.val);
            for (Node node : root.children) {
                deque.addFirst(node);
            }
        }
        return list;
    }

    public List<Integer> pp1(Node root) {
        List<Integer> list = new ArrayList<>();
        dfspp1(root, list);
        return list;
    }

    private void dfspp1(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (Node node : root.children) {
                dfspp1(node, list);
            }
        }
    }



    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> plan1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preorder(root, res);
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        // 先处理头节点
        res.add(root.val);
        // 接着 遍历递归孩子
        for (Node child : root.children) {
            preorder(child, res);
        }
    }

    /**
     * 迭代
     * 1、栈中存放未遍历过的节点
     * 2、遍历完当前节点将孩子节点逆序入栈
     * @param root
     * @return
     */
    public List<Integer> plan2(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            Node cur = deque.removeLast();
            res.add(cur.val);
            // 逆序入栈
            for (int i = cur.children.size() - 1; i >= 0; --i) {
                deque.addLast(cur.children.get(i));
            }
        }
        return res;
    }

    public List<Integer> test1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        res.add(root.val);
        for (Node node : root.children) {
            if (node != null) {
                dfs(node, res);
            }
        }
    }

    public List<Integer> test2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            // 孩子逆序入站
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
