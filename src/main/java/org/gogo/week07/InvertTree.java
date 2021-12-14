package org.gogo.week07;

import org.gogo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转二叉树
 * @author liupenghui
 * @date 2021/7/22 2:54 下午
 */
public class InvertTree {

    public TreeNode pp4(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 左右子树交换
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }

    public TreeNode pp3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 反转左右子树
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }


    public TreeNode pp2(TreeNode node) {
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            // 交换左右子树
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            left.right = left;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return node;
    }


    public TreeNode pp1(TreeNode node) {
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            TreeNode left = tempNode.left;
            tempNode.left = tempNode.right;
            tempNode.right = left;
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return node;
    }


    public TreeNode bfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 左右子树交换
            TreeNode temp = queue.poll();;
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }

    /**
     * 反转二叉树练习，思路是左右子树交换，然后递归，继续左右子树交换
     * @param root
     * @return
     */
    public TreeNode test3(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 当前层逻辑，左右子树交换
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 继续左右子树交换
        test3(root.left);
        test3(root.right);
        return root;
    }

    public TreeNode test2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左右子树交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        test2(root.left);
        test2(root.right);
        return root;
    }

    public TreeNode test1(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 当前层处理逻辑，左右子树交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 进入下一层，递归左右子树
        test1(root.left);
        test1(root.right);
        return root;
    }

    /**
     * 递归
     * @param treeNode
     * @return
     */
    private TreeNode invertTree(TreeNode treeNode) {
        // 终止条件
        if (treeNode == null) {
            return null;
        }
        // 当前层处理逻辑

        // 左右子树交换逻辑
        TreeNode temp = treeNode.right;
        treeNode.right = treeNode.left;
        treeNode.left = temp;
        // 左子树递归
        invertTree(treeNode.left);
        // 右子树递归
        invertTree(treeNode.right);
        return treeNode;
    }

    /**
     * 迭代 广度优先遍历
     * @param root
     * @return
     */
    private TreeNode plan2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 队列用于存储树节点元素，将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if (temp.left != null) {
                queue.add(temp.left);
            }
            // 如果当前节点的右子树不为空，放到队列中待处理
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }
}
