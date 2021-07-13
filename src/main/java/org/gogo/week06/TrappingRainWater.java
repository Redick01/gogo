package org.gogo.week06;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liupenghui
 * @date 2021/7/13 5:13 下午
 */
public class TrappingRainWater {


    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println(plan1(nums));
    }

    /**
     * 暴力解法
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
        int ans = 0;
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
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
