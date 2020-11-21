package org.gogo.week02;

public class MergeSortedNode {

    /**
     * 合并有序链表
     * 1.如果l1或l2有一个链表是空的，那么只返回另一个链表即可
     * 2.设置一个dummyNode，由于存储合并后的链表，初始化dummyNode节点的头节点值为0
     * 3.只要是l1和l2都不为空，就循环两个链表比较，然后与head进行赋值，交换操作
     * 4.只要有一个链表为空，那么已经赋值的dummyNode后续的节点就是剩下的l1或l2的节点了
     * 5.最后返回dummyNode.next就是已经合并好的有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        mergeTwoLists(listNode1, listNode2);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode getNextNode() {
        return next;
    }
    public void setNextNode(ListNode nextNode) {
        this.next = nextNode;
    }
}