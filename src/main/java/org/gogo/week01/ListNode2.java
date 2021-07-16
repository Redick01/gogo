package org.gogo.week01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListNode2 {

    public static void main(String[] args) {
        ListNode2 li = new ListNode2(1);
        li.next = new ListNode2(2);
        li.next.next = new ListNode2(3);
        for (int i = 0; i < 3; i++) {

        }
        String proxyServer = System.getProperty("proxyServer","http://localhost:8088");
        System.out.println(proxyServer);
    }

    /**
     * 使用额外容器
     * @param head
     * @return
     */
    public static ListNode2 plan2(ListNode2 head) {
        List<ListNode2> list = new ArrayList<>();
        ListNode2 node2 = head;
        while (head.next != null) {
            list.add(node2);
            node2 = node2.next;
        }
        // 反转数组
        Collections.reverse(list);
        for (ListNode2 listNode2 : list) {
            head = listNode2;

        }
        return head;
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    public static ListNode2 reverse(ListNode2 head) {
        // 定义两个指针，cur和pre，cur在后，pre在前
        ListNode2 cur = null, pre = head;
        // 遍历链表
        while (pre.next != null) {
            // 记录pre的next节点
            ListNode2 t = pre.next;
            // 交换cur和pre完成一次局部的反转
            // pre的next指针指向cur
            pre.next = cur;
            // cur前进
            cur = pre;
            // pre前进
            pre = t;
        }
        return cur;
    }

    int value;

    ListNode2 next;

    ListNode2() {}

    ListNode2(int value) {
        value = value;
    }

    ListNode2(int value, ListNode2 next) { this.value = value; this.next = next; }


    public static ListNode2 reverse1(ListNode2 head) {
        // 反转后的链表
        ListNode2 listNode2 = new ListNode2(-1);
        // 当前节点
        ListNode2 pCur = head;
        while (null != pCur) {
            // 下一个节点
            ListNode2 pNex = pCur.next;
            pCur.next = listNode2.next;
            listNode2.next = pCur;
            pCur = pNex;
        }
        return listNode2.next;
    }
}
