package org.gogo.week07;

import org.gogo.ListNode;

import java.util.Stack;

/**
 * @author liupenghui
 * @date 2021/7/18 9:54 上午
 */
public class SwapPairsListNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        test5(node1);
    }

    public static ListNode test6(ListNode head) {
        // 创建哑节点
        ListNode dummyNode = new ListNode(-1);
        // 哑节点指向链表头节点
        dummyNode.next = head;
        // 创建临时节点用于 确定 反转后的node指向
        ListNode temp = dummyNode;
        // 迭代处理
        while (temp.next != null || temp.next.next != null) {
            // 待处理的两个节点
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 临时节点指向 node2
            temp.next = node2;
            // 交换
            node1.next = node2.next;
            node2.next = node1;
            //  临时节点指向处理后的node1，下次处理的节点是两个新的
            temp = node1;
        }
        return dummyNode.next;
    }

















    public static ListNode test5(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyNode.next;
    }

    public static ListNode test4(ListNode head) {
        // 创建哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 临时节点
        ListNode temp = dummyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyNode.next;
    }

    public static ListNode test1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 以 1->2->3->4为例
        //  记录 2
        ListNode tmp = head.next;
        // 递归处理 3 和 4，1指向3和4的处理结果，结果是1指向了4
        head.next = test1(tmp.next);
        // 2 指向 1 和 4 指向 3
        tmp.next = head;
        return tmp;
    }

    public static ListNode test2(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode tmp = listNode.next;
        listNode.next = test2(listNode);
        tmp.next = listNode;
        return tmp;
    }

    public static ListNode test3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode cur = p;
        ListNode net = p;
        ListNode temp = p;
        while (net.next != null && net.next.next != null) {
            cur = cur.next;
            net = net.next.next;
            temp.next = net;
            cur.next = net.next;
            net.next = cur;
            temp = cur;
            net = cur;
        }
        return p.next;
    }

    /**
     * 思路1，双指针前进法，两个指针cur和net，交换后要前进两步处理下两个节点
     * 注意处理第一轮迭代和第二轮迭代的结果要能连起来
     * @param head
     * @return
     */
    public ListNode plan1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //增加一个特殊节点方便处理
        ListNode p = new ListNode(-1);
        // 节点p指向head
        p.next = head;
        ListNode cur = p;
        ListNode net = p;
        // 临时节点，记录一轮处理完 cur的位置
        ListNode temp = p;
        while (net!= null && net.next != null && net.next.next != null) {
            // cur前进一位 net前进两位
            cur = cur.next;
            net = net.next.next;
            // temp 用于确定两组反转后的两个节点的指向关系，比如 1->4
            temp.next = net;
            // 交换一组的两个节点，使 1->2 暂时变成 2->1->3 这里1指向的内容现在还没确认，下次迭代确认
            cur.next = net.next;
            net.next = cur;
            // 现在链表就变成2->1->3->4
            // temp和net都指向1节点，等下次迭代的时候
            // cur就变成3，net就变成4，然后tmp就指向net，也就是1指向4
            temp = cur;
            net = cur;
        }
        return p.next;
    }

    /**
     * 思路2，递归
     * 终止条件：head = null || head.next = null;
     * 函数内部：处理下两个节点，并且头节点指向下两个节点处理结果，例如下两个节点处理结果是 4->3，那就头节点指向4 即head.next=递归结果
     * @param head
     * @return
     */
    public ListNode plan2(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归函数
        // 假设连表内容 1->2->3->4
        // temp临时存储2
        ListNode temp = head.next;
        // 继续递归，处理 3->4节点
        // 递归结束后就变成了4->3
        // 最后头节点指向4，实现了1->4->3
        head.next = plan2(temp.next);
        // 2节点指向1
        temp.next = head;
        // temp  2->1->4->3
        return temp;
    }

    /**
     * 方法3，使用栈存储 待处理的两个节点
     * @param head
     * @return
     */
    public ListNode plan3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //head指向新的p节点，函数结束时返回head.next即可
        head = p;
        while (cur != null && cur.next != null) {
            //将两个节点放入stack中
            stack.add(cur);
            stack.add(cur.next);
            //当前节点往前走两步
            cur = cur.next.next;
            //从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件，当链表长度是奇数时，cur就不为空
        if (cur != null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
    }
}
