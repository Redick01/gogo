package org.gogo.week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

 你可以按任意顺序返回答案。

 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author liupenghui
 * @date 2021/7/11 1:21 下午
 */
public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        test2(nums, 9);
    }

    public static int[] test2(int[] nums, int target) {
        // key为数组元素 value为数组元素下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not exist this value!");
    }


    /**
     * 方法1 双指针暴力求解
     * @param nums
     * @param target
     * @return
     */
    public static int[] plan1(int[] nums, int target) {
        int[] r = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    r[index] = i;
                    r[++index] = j;
                }
            }
        }
        return r;
    }

    /**
     * 方法2，使用哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] plan2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not exist this value!");
    }
}
