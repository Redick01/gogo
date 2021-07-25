package org.gogo.week08;

import java.util.*;

/**
 * @author Redick
 * @date 2021/7/25 6:40 下午
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,1,1,2,2};
        System.out.println(new MajorityElement().plan4(nums));
    }

    /**
     * 暴力解法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @return
     */
    public int plan1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // int flag = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int maxValue = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxValue <= entry.getValue()) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }

    /**
     * 方法2 排序法
     * @param nums
     * @return
     */
    public int plan2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public int plan3(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public int divide(int[] nums, int lower, int upper) {
        // 终止条件
        if (lower == upper) {
            return nums[lower];
        }
        // 处理当前层数据
        int mid = (upper - lower) / 2 + lower;
        // 分割子问题
        int left = divide(nums, lower, mid);
        int right = divide(nums, mid + 1, upper);
        // 处理并合并结果
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lower, upper);
        int rightCount = countInRange(nums, right, lower, upper);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 方法4 Boyer-Moore 投票算法
     * 众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多
     * @param nums
     * @return
     */
    public int plan4(int[] nums) {
        // 众数临时变量
        int candidate = 0;
        // 众数出现次数
        int count = 0;
        // 算法，出现一次+1否则-1
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
