package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现环形队列
 * 实现方案，用Deque实现即可，注意定义队列容量
 * @author liupenghui
 * @date 2021/7/14 3:14 下午
 */
public class MyCircularDeque {

    public static void main(String[] args) {
        /**
         * Your MyCircularDeque object will be instantiated and called as such:
         * MyCircularDeque obj = new MyCircularDeque(k);
         * boolean param_1 = obj.insertFront(value);
         * boolean param_2 = obj.insertLast(value);
         * boolean param_3 = obj.deleteFront();
         * boolean param_4 = obj.deleteLast();
         * int param_5 = obj.getFront();
         * int param_6 = obj.getRear();
         * boolean param_7 = obj.isEmpty();
         * boolean param_8 = obj.isFull();
         */
        MyCircularDeque myCircularDeque = new MyCircularDeque(10);
        System.out.println(myCircularDeque.insertFront(10));
        System.out.println(myCircularDeque.insertLast(20));
        System.out.println(myCircularDeque.insertLast(21));
        System.out.println(myCircularDeque.insertLast(22));
        System.out.println(myCircularDeque.insertLast(23));
        System.out.println(myCircularDeque.insertLast(24));
        System.out.println(myCircularDeque.insertLast(25));
        System.out.println(myCircularDeque.insertLast(26));
        System.out.println(myCircularDeque.insertLast(27));
        System.out.println(myCircularDeque.insertLast(28));
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.getFront());
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.isEmpty());

        Deque<Integer> deque = new ArrayDeque<>();

    }

    private final Deque<Integer> deque = new LinkedList<>();

    /**
     * size of CircularDeque
     */
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (deque.size() >= capacity) {
            return false;
        }
        deque.addFirst(value);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (deque.size() >= capacity) {
            return false;
        }
        deque.addLast(value);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (deque.isEmpty()) {
            return false;
        }
        deque.removeFirst();
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (deque.isEmpty()) {
            return false;
        }
        deque.removeLast();
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (deque.size() == 0) {
            return -1;
        }
        return deque.getFirst();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (deque.size() == 0) {
            return -1;
        }
        return deque.getLast();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capacity == deque.size();
    }
}
