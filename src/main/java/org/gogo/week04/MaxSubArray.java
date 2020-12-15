package org.gogo.week04;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Redick
 * @Date 2020/11/22 10:09 下午
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1};
        System.out.println(maxSubArray1(nums));
    }

    /**
     * 最笨的方法，三层循环，数据量多了就完了
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        if (null == nums || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int newArray[] = Arrays.copyOfRange(nums, i, j);
                int cur = 0;
                for (int a : newArray) {
                    cur += a;
                    if (cur > result) {
                        result = cur;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 动态规划，前面的元素大于0时，将前面的元素加到当前元素
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i -1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }
}
