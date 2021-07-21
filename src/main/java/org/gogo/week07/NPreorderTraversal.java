package org.gogo.week07;

import org.gogo.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉树前序遍历
 * @author liupenghui
 * @date 2021/7/20 9:53 下午
 */
public class NPreorderTraversal {

    /**
     * N叉树前序遍历 递归法
     * @param root
     * @return
     */
    public List<Integer> test1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pre(root, res);
        return res;
    }

    public void pre(Node node, List<Integer> res) {
        res.add(node.val);
        for (Node node1 : node.children) {
            pre(node1, res);
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
}
