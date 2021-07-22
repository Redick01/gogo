package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化 反序列化
 * @author liupenghui
 * @date 2021/7/22 8:29 下午
 */
public class Codec {

    /**
     * Encodes a tree to a single string.
     * 前序遍历实现序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "NULL";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        // 递归
        return deserialize(dataList);
    }

    private TreeNode deserialize(Queue<String> dataList) {
        String val = dataList.poll();
        // 终止条件 碰到NULL 返回null
        if ("NULL".equals(val)) {
            return null;
        }
        // 当前深度处理逻辑 生成根节点
        TreeNode root = new TreeNode(Integer.parseInt(val));
        // 进入下层，处理左右子树
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }
}