package org.gogo.week06;

import java.util.ArrayDeque;
import java.util.Deque;

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

    public void test5(int[] nums, int k) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(k + i) % nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public void test4(int[] nums, int k) {
        k %= nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, nums.length - 1);
    }

    public void rev(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public int[] test1(int[] nums, int k) {
        int len = nums.length;
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[(i + k) % len] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, len);
        return nums;
    }

    public int[] test2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse2(nums, 0, len - 1);
        reverse2(nums, 0, k - 1);
        reverse2(nums, k, len - 1);
        return nums;
    }

    private void reverse2(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        System.out.println(3 % 7);
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().test4(nums, 8);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * 1、开一个新数组用于存储临时结果
     * 2、遍历原数组，计算出旋转后元素中在数组中的位置并赋值，位置=(i + k) % len
     * 3、将临时数组copy到原数组中
     * @param nums
     * @param k
     */
    public static int[] plan2(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            newNums[(i + k) % len] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, len);
        return nums;
    }

    /**
     * 方案3 原数组元素双指针交换
     * 1. 重新计算一下k，因为有可能大于数组长度，所以有效的k应该等于 k % len
     * 2. 先从0 到 len开始交换
     * 3. 然后交换 0 到 k - 1 位置
     * 4. 最后交换 k 到 len - 1位置
     * 5. 注意，这里采用的是双指针交换，没交换一次start前进一步，end后退一步
     * @param nums
     * @param k
     */
    public void plan3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
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
        int index = nums.length - k;
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
