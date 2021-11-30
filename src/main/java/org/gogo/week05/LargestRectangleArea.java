package org.gogo.week05;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author liupenghui
 * @date 2021/7/11 8:56 下午
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.println(test7(height));
    }

    public static int test7(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        nums = newNums;
        len += 2;
        stack.push(0);
        int maxAre = 0;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                maxAre = Math.max(maxAre, height * width);
            }
            stack.push(i);
        }
        return maxAre;
    }

    public static int test6(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        nums = newNums;
        len += 2;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int maxH = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, maxH * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static int test5(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        len += 2;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        nums = newNums;
        int maxArea = 0;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static int test4(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] newNums = new int[len + 2];
        System.arraycopy(nums, 0, newNums, 1, len);
        len += 2;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        nums = newNums;
        int maxArea = 0;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int height = nums[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.add(i);
        }
        return maxArea;
    }

    public static int test3(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        len += 2;
        heights = newHeight;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < len; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static int test2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int maxAre = 0;

        // 初始化一个长度比原来长2的新数组
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 存数组下标
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        len += 2;
        heights = newHeights;
        for (int i = 1; i < len; i++) {
            while (heights[stack.peek()] > heights[i]) {
                // 面积是求左侧的矩形
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxAre = Math.max(maxAre, height * width);
            }
            stack.push(i);
        }
        return maxAre;
    }

    public int baoLi(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int height = array[i];
            int left = i;
            int right = i;
            while (left > 0 && array[left - 1] >= height) {
                left--;
            }
            while (right < len - 1 && array[right + 1] >= height) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }
        return maxArea;
    }

    /**
     * 暴力解法1
     * 枚举数组元素
     * 看左边能延伸到哪，记下最左边元素下标
     * 看右边能延伸到哪，记下最右边元素下表
     * @param heights
     * @return
     */
    public static int plan1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int h = heights[i];
            int left = i;
            int right = i;
            while (left > 0 && heights[left - 1] >= h) {
                left--;
            }
            while (right < len - 1 && heights[right + 1] >= h) {
                right++;
            }
            maxArea = Math.max(maxArea, (right - left + 1) * h);
        }
        return maxArea;
    }


    /**
     * 利用栈
     *
     * 栈中记录的是下标
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }
        int[] newHeights = new int[length + 2];
        System.arraycopy(heights, 0, newHeights, 1, length);
        length = length + 2;
        heights = newHeights;
        // 存储的是条形图索引
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int maxArea = 0;
        for (int i = 1; i < length; i++) {
            // 核心逻辑，找到右边界，并循环找栈中所有数组下边元素的右边界，找不到就压栈
            while (heights[stack.peek()] > heights[i]) {
                // 高度可以直接取出
                int high = heights[stack.pop()];
                // 可以计算出条形图面积
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, high * width);
            }
            // 条形图越来越多就将数组下标压栈，数组越来越大还确定不了右边界，继续向右遍历
            stack.add(i);
        }
        return maxArea;
    }


    public int stackRaise(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;
        // 存储单调递增的高度的矩形的数组下标，意味着矩形高度单调递增
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int maxArea = 0;
        for (int i = 1; i < len + 2; i++) {
            // 维护单调递增栈，发现违反单调性就计算面积
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            // 满足单调性，压栈
            stack.add(i);
        }
        return maxArea;
    }
}
