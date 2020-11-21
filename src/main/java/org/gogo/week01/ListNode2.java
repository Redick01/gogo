package org.gogo.week01;

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
