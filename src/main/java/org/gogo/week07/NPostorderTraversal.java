package org.gogo.week07;

import org.gogo.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N 叉树后序遍历
 * @author liupenghui
 * @date 2021/7/18 5:55 下午
 */
public class NPostorderTraversal {

    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        List<Node> children= new ArrayList<>();
        children.add(node1);
        children.add(node2);
        children.add(node3);
        children.add(node4);
        node.children = children;
        plan2(node);
    }

    public List<Integer> pp2(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }

    public List<Integer> pp1(Node root) {
        List<Integer> res = new ArrayList<>();
        dfspp1(root, res);
        return res;
    }

    public void dfspp1(Node root, List<Integer> res) {
        if (root != null) {
            for (Node node : root.children) {
                if (node != null) {
                    dfspp1(root, res);
                }
            }
            res.add(root.val);
        }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> plan1(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(Node root, List<Integer> res) {
        if (root != null) {
            for (Node node : root.children) {
                if (node != null) {
                    postorder(node, res);
                }
            }
            res.add(root.val);
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static List<Integer> plan2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

    public List<Integer> test(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        for (Node node : root.children) {
            if (node != null) {
                dfs(node, res);
            }
        }
        res.add(root.val);
    }


    public List<Integer> test1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node cNode : node.children) {
                stack.push(cNode);
            }
        }
        return res;
    }
}
