package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liupenghui
 * @date 2021/7/13 5:13 下午
 */
public class TrappingRainWater {


    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(test4(nums));
    }


    public static int test4(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                // 能盛水的高度
                int minH = Math.min(nums[left], nums[i]) - nums[top];
                int minW = i - left - 1;
                area += minH * minW;
            }
            stack.push(i);
        }
        return area;
    }


    public static int test3(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int maxArea = 0;
        // 存储数组下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int minH = Math.min(nums[i], nums[left]) - nums[top];
                int minW = i - left - 1;
                maxArea += minH * minW;
            }
            stack.push(i);
        }
        return maxArea;
    }


    public static int test2(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int maxArea = 0;

        // 存储数组下标
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i= 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                int top = deque.removeLast();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.getLast();
                int minH = Math.min(nums[i], nums[left]) - nums[top];
                int minW = i - left - 1;
                maxArea += minH * minW;
            }
            deque.addLast(i);
        }

        return maxArea;
    }

    /**
     * 使用队列存储单调递减的条形
     * @param nums
     * @return
     */
    public static int plan2(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int maxArea = 0;
        // 单调递减队列，存储递减数组元素的下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 队列元素小于枚举元素就开始计算面积
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                // 如果队列空了，跳出循环
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                // 最小条形高
                int minH = Math.min(nums[i], nums[left]) - nums[top];
                // 当前条形宽
                int currW = i - left - 1;
                maxArea += minH * currW;
            }
            stack.push(i);
        }
        return maxArea;
    }

    /**
     * 暴力解法-时间复杂度高
     * 1、枚举每一个元素，找到元素左边最大条形图和右边最大条形图，取最小的条形图减去当前元素就是该元素所能接住的水量
     * 2、将每一个元素能接到的最大水量加起来就是接水量，画个图就能明白
     * 3、注意，枚举的元素不包含数组首尾元素
     * @param height
     * @return
     */
    public static int plan1(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            // 向左寻找
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 向右寻找
            for (int k = i; k < height.length; k++) {
                maxRight = Math.max(maxRight, height[k]);
            }
            maxArea += Math.min(maxLeft, maxRight) - height[i];
        }
        return maxArea;
    }

    public static int trap(int[] height) {
        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                maxArea += currWidth * currHeight;
            }
            stack.push(i);
        }
        return maxArea;
    }
}
