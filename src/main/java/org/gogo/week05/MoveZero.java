package org.gogo.week05;

/**
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liupenghui
 * @date 2021/7/9 5:16 下午
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        nums = times_2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] times_2(int[] nums) {
        // 记录移动非0元素的索引index
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
        return nums;
    }


    /**
     * 方法一
     * 先将所有非0的数移到数组前边，然后剩余位置补0
     * @param nums
     * @return
     */
    public static int[] plan_1(int[] nums) {
        // 记录开始补0的下标
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
