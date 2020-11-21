package org.gogo.week01;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {


    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        // 新链表
        ListNode1 root = new ListNode1(0);
        // 中间链表
        ListNode1 cursor = root;
        // 进位初始化为0
        int carry = 0;

        while (null != l1 || null != l2 || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            ListNode1 sumNode = new ListNode1(sum % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 链表root最终是0》7》0》8，返回root.next 即7》0》8
        return root.next;
    }

    public static ListNode1 addTwoNumbers1(ListNode1 l1, ListNode1 l2) {
        List<ListNode1> root = new ArrayList<ListNode1>();
        String value1 = "";
        while (l1 != null) {
            value1 = value1 + String.valueOf(l1.val);
            l1 = l1.next;
        }

        String value2 = "";
        while (l2 != null) {
            value2 = value2 + String.valueOf(l2.val);
            l2 = l2.next;
        }
        int sum = Integer.parseInt(value1) + Integer.parseInt(value2);
        String sumStr = String.valueOf(sum);
        int[] sumArr = new int[sumStr.length()];
        for (int i = sumStr.length() - 1; 0 <= i; --i) {
            sumArr[i] = Integer.parseInt(String.valueOf(sumStr.charAt(i)));
            System.out.println(sumArr[i]);
            ListNode1 node1 = new ListNode1(sumArr[i]);
            root.add(node1);
        }
        for (int i = 0; i < root.size() - 1; i++) {
            while (root.get(i) != null) {
                root.get(i).next = root.get(i + 1);
                break;
            }
        }
        return root.get(0);
    }

    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1(2);
        l1.next = new ListNode1(4);
        l1.next.next = new ListNode1(3);
        ListNode1 l2 = new ListNode1(5);
        l2.next = new ListNode1(6);
        l2.next.next = new ListNode1(4);
        //System.out.println(7%10);
        ListNode1 l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }

    public ListNode1 getNextNode() {
        return next;
    }
    public void setNextNode(ListNode1 nextNode) {
        this.next = nextNode;
    }
}
