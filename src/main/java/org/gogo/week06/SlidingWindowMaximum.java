package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 滑动窗口最大值
 * @author liupenghui
 * @date 2021/7/12 11:04 下午
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] max = maxSlidingWindow(nums, 3);
    }

    public int[] test1(int[] nums, int k) {
        // 窗口个数
        int windowCount = nums.length - k + 1;
        // 结果数组
        int[] res = new int[windowCount];
        // 单调递增队列
        Deque<Integer> deque = new ArrayDeque<>();
        // 遍历数组，遍历的位置就是窗口的右边界
        for (int right = 0; right < nums.length; right++) {
            // 如果队列不为空，队列中元素小于右边界元素，移除队列尾部的这个元素，保持队列单调递增
            while (!deque.isEmpty() && nums[right] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            // 将递增的元素索引放到队列中
            deque.addLast(right);
            // 计算左边界
            int left = right - k + 1;
            // 说明队列头元素已经不在窗口中了
            if (left > deque.getFirst()) {
                deque.removeFirst();
            }
            // 窗口形成，队尾元素即窗口最大值
            if (right + 1 >= k) {
                res[left] = nums[deque.getFirst()];
            }
        }
        return res;
    }



    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 窗口个数
        int windowCount = nums.length - k + 1;
        int[] result = new int[windowCount];
        // 双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            // 队列不为空并且右边界的元素大于队尾索引元素，将队尾数据移除
            while (!deque.isEmpty() && nums[right] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            // 移除队尾下标后，将右边界下标入队
            deque.addLast(right);
            // 计算窗口左边界
            int left = right - k + 1;
            // 队头数据小于左边边界数组下标，说明队头存的下标已经不在窗口中了，直接从队列中移除
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }
            // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时意味着窗口形成。此时，队首元素就是该窗口内的最大值
            if (right + 1 >= k) {
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }
}
