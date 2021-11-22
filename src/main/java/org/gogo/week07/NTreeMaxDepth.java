package org.gogo.week07;

import org.gogo.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liupenghui
 * @date 2021/11/21 11:02 下午
 */
public class NTreeMaxDepth {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        for (Node node : root.children) {
            res = Math.max(maxDepth(node), res);
        }
        return res + 1;
    }

    public int bfs(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();

            while (size-- > 0) {
                Node node = deque.pollFirst();
                for (Node node1 : node.children) {
                    deque.addLast(node1);
                }
            }
            res++;
        }
        return res;
    }
}
