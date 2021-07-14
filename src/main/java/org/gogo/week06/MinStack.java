package org.gogo.week06;

import java.util.*;

/**
 * @author liupenghui
 * @date 2021/7/14 5:26 下午
 */
public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minValStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minValStack = new LinkedList<>();
        minValStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minValStack.push(Math.min(val, minValStack.peek()));
    }

    public void pop() {
        stack.pop();
        minValStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValStack.peek();
    }
}
