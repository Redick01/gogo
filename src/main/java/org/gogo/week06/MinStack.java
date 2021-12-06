package org.gogo.week06;

import java.util.*;

/**
 * 最小栈
 * 设计思路，定义两个双端队列stack和minValStack，分别用于存储正常的栈值和最小的栈值，在push值的时候会与minValStack中当前的值比较，如果push的值小就替换一下
 * 这样回去最小值就直接从这个最小值栈中就可以获取到了
 * @author liupenghui
 * @date 2021/7/14 5:26 下午
 */
public class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minValStack;


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
