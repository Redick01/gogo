package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liupenghui
 * @date 2021/7/12 1:24 下午
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * [1,2,3,4,5,6,7]
     * 暴力法
     * @param nums
     */
    public static int[] plan1(int[] nums, int k) {
        if (nums.length == 1 || nums.length == k) {
            return nums;
        }
        // 当k大于数组长度的时候，计算真正的旋转步长
        if (nums.length < k) {
            k = k % nums.length;
        }
        // 开一个新数组
        int[] newNums = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        // 用栈存储数组步长元素的剩余元素
        for (int i = nums.length - k; i < nums.length; i++) {
            stack.add(nums[i]);
        }
        // 计算数组中剩余元素数
        int index = nums.length -k;
        // 将数组中剩余元素拷贝到新数组旋转的对应位置
        for (int i = 0; i < index; i ++) {
            newNums[k++] = nums[i];
        }
        // 栈中的元素数，就是要从新数组起始位置
        int size = stack.size();
        // 将栈中元素在存到新数组中
        for (int i = 0; i < size; i++) {
            newNums[i] = stack.pollFirst();
        }
        // 将新数组元素拷贝到nums中
        System.arraycopy(newNums, 0, nums, 0, nums.length);
        return nums;
    }
}
