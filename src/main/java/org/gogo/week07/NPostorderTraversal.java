package org.gogo.week07;

import org.gogo.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liupenghui
 * @date 2021/7/18 5:55 下午
 */
public class NPostorderTraversal {

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
}
