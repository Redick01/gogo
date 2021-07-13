package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liupenghui
 * @date 2021/7/12 11:04 下午
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] max = test5(nums, 3);
    }

    public static int[] test5(int[] nums, int k) {
        int windowsCount = nums.length - k + 1;
        int[] result = new int[windowsCount];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            deque.addLast(i);
            int left = i - k + 1;
            if (left > deque.getFirst()) {
                deque.removeFirst();
            }
            if (i + 1 >= k) {
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static int[] test4(int[] nums, int k) {
        // 窗口个数
        int windowCount = nums.length - k + 1;
        // 结果
        int[] result = new int[windowCount];
        // 双端队列，队列中存的是数组索引下标
        Deque<Integer> deque = new ArrayDeque<>();
        // 遍历数组，数组下标是右边界
        for (int i = 0; i < nums.length; i++) {
            // 队列不等于空，队列首元素小于等于遍历元素，移除队列首元素，队首存的永远是窗口最大值
            while (!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            // 存到队尾
            deque.addLast(i);
            // 左边界
            int left = i - k + 1;
            // 左边界大于队首，说明队首元素已经不在窗口中，移除队首数据
            if (left > deque.getFirst()) {
                deque.removeFirst();
            }
            // 记录结果，右边界大于等于窗口，说明已经形成了窗口，队首数据就是窗口最大值
            if (i + 1 >= k) {
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static int[] test3(int[] nums, int k) {
        // 窗口个数
        int windowCount = nums.length - k + 1;
        // 结果数组
        int[] result = new int[windowCount];
        // 双端队列，存储数组下标
        Deque<Integer> deque = new ArrayDeque<>();
        // i是右边界
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            // 添加元素
            deque.addLast(i);
            // 左边界
            int left = i - k + 1;
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }
            // 窗口形成，记录结果
            if (i + 1 >= k) {
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    /**
     * 滑动窗口算法，使用单调队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] test2(int[] nums, int k) {
        // 确定窗口个数
        int windowCount = nums.length - k + 1;
        // 初始化结果数组
        int[] result = new int[windowCount];
        // 定义双端队列，注意双端队列存储的是数组元素的索引
        Deque<Integer> deque = new ArrayDeque<>();
        // 循环数组， i是窗口的右边界
        for (int i = 0; i < nums.length; i++) {
            // 队列不为空，判断队列存元素和遍历到的数组元素大小，如果队列头的元素小于遍历元素，要移除队列的数据
            while (!deque.isEmpty() && nums[deque.getFirst()] <= nums[i]) {
                deque.removeFirst();
            }
            // 将元素下标加到队列尾部
            deque.addLast(i);
            // 确定窗口左边界
            int left = i - k + 1;
            // 队头数据小于左边边界数组下标，说明队头存的下标已经不在窗口中了，直接从队列中移除
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }
            // 右边界+1大于等于窗口大小时，窗口形成，队头数据就是该窗口内最大值
            if (i + 1 >= k) {
                result[left] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 窗口个数
        int windowCount = nums.length - k + 1;
        int[] result = new int[windowCount];
        // 双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            // 队列不为空并且右边界的元素大于队尾索引元素，将队尾数据移除
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
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
