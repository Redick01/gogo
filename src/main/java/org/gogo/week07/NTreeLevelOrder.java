package org.gogo.week07;

import org.gogo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的层序遍历
 * @author liupenghui
 * @date 2021/7/21 3:11 下午
 */
public class NTreeLevelOrder {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        if (list.size() <= 0) {
            list.add(new ArrayList<>());
        }
        List<Integer> i = list.get(0);
        i.add(1);

        System.out.println(111);
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> plan1(Node root) {
        if (root == null) {
            return res;
        }
        // 从第一层开始
        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(Node node, int level) {
        // 先用空list将每一层（递归时候）的结果占住
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        // 将每一层的结果add到list中
        res.get(level).add(node.val);
        for (Node node1 : node.children) {
            levelOrder(node1, level + 1);
        }
    }

    public List<List<Integer>> test(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node cNode : root.children) {
            dfs(cNode, level + 1, res);
        }
    }
}
