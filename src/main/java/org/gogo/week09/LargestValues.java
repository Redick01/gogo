package org.gogo.week09;

import org.gogo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * 在每个树行中找最大值
 * @author Redick
 * @date 2021/7/31 9:31 上午
 */
public class LargestValues {

    /**
     * 广度优先搜索
     * @return
     */
    public List<Integer> plan1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int level = deque.size();
            int temp = -Integer.MIN_VALUE;
            for (int i = 0; i < level; i++) {
                TreeNode node = deque.poll();
                temp = Math.max(temp, node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
