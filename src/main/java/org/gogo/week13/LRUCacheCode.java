package org.gogo.week13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Redick
 * @date 2021/9/12 10:22 下午
 */
public class LRUCacheCode {

    /**
     * 双向链表
     * 双向链表头节点数据是最近访问的数据
     * 双向链表尾节点数据是最近最少访问数据
     */
    static class DNode {

        int key;

        int val;

        DNode pre;

        DNode next;

        public DNode() {
        }

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 哈希表
     */
    private final Map<Integer, DNode> cache = new HashMap<>();

    /**
     * 缓存容量
     */
    private final int capacity;

    /**
     * 当前缓存使用的大小
     */
    private int size;

    /**
     * 头节点，尾节点 这两个节点是dummy 哑节点
     */
    private final DNode head;
    private final DNode tail;

    public LRUCacheCode(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DNode();
        this.tail = new DNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 从缓存中根据key 查询
     * @param key 缓存key
     * @return 缓存数据
     */
    public int get(int key) {
        DNode node = cache.get(key);
        // 如果不存在返回 -1
        if (null == node) {
            return -1;
        }
        // 如果存在，操作双向链表，将缓存放到双向链表的头部
        moveToHead(node);
        return node.val;
    }

    /**
     * 插入缓存
     * @param key 缓存key
     * @param value 缓存数据
     */
    public void put(int key, int value) {
        DNode node = cache.get(key);
        // 缓存不存在，将其放到缓存中并放到头节点，判断缓存size是否大于容量，如果大于容量要从双向链表尾步删除尾节点
        if (null == node) {
            DNode dNode = new DNode(key, value);
            cache.put(key, dNode);
            // 添加到链表头部
            addNode(dNode);
            ++size;
            // 超出容量
            if (size > capacity) {
                // 移除尾节点
                DNode tailNode = removeTail();
                // 从缓存中移除
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            // 缓存存在，更新val，并且将缓存放到双向链表头节点，将缓存从原来链表位置删除
            node.val = value;
            moveToHead(node);
        }
    }

    /**
     * 将节点移动到头节点，首先要在双向链表中删除节点，然后双向链表头部添加该节点
     * @param dNode 节点
     */
    public void moveToHead(DNode dNode) {
        removeNode(dNode);
        addNode(dNode);
    }

    /**
     * 从双向链表中删除节点
     * @param dNode 删除的节点
     */
    public void removeNode(DNode dNode) {
        dNode.pre.next = dNode.next;
        dNode.next.pre = dNode.pre;
    }

    public void addNode(DNode dNode) {
        dNode.pre = head;
        dNode.next = head.next;
        dNode.next.pre = dNode;
        head.next = dNode;
    }

    /**
     * 移除链表尾节点
     * @return 尾节点
     */
    public DNode removeTail() {
        DNode tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }
}
