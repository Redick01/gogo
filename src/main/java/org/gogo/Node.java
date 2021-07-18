package org.gogo;

import java.util.List;

/**
 * @author liupenghui
 * @date 2021/7/18 6:05 下午
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
