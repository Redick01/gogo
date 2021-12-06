package org.gogo.week05;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liupenghui
 * @date 2021/7/9 11:34 下午
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = plan2(nums);
    }

    public static List<List<Integer>> test1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1, j = nums.length - 1; i < j;) {
                if (nums[k] + nums[i] < -nums[j]) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (nums[k] + nums[i] > -nums[j]) {
                    while (i < j && nums[j] == nums[--j]);
                } else if (nums[k] + nums[i] == -nums[j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * 暴力解法，三层循环
     * @param nums
     * @return
     */
    public static List<List<Integer>> plan1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        // 用来去重
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<Integer>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        lists.add(list);
                    }
                }
            }
        }
        List<List<Integer>> lists1 = new ArrayList<List<Integer>>();
        // 解过去重
        for (List<Integer> list : lists) {
            StringBuilder s = new StringBuilder();
            for (Integer i : list) {
                s.append(i);
            }
            if (!set.contains(s.toString())) {
                set.add(s.toString());
                lists1.add(list);
            }
        }

        return lists1;
    }

    /**
     * 优化解法 时间复杂度O(n^2)
     * a + b + c = 0;
     * a + b = -c; -c就是一个target
     * 首先将数组排序
     * 三个指针k，i，j
     * k（首）负责枚举， i，j指针分别是k+1和数组末尾位置的指针，i,j指针双指针夹逼，当num[i]+num[j]==-num[k]记录结果
     * num[i]+num[j]>-num[k] --j
     * num[i]+num[j]<-num[k] ++i
     *
     *
     * [-4,-1,-1,0,1,2]
     * @param nums
     * @return
     */
    public static List<List<Integer>> plan2(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; ++k) {
            // nums[k]说明是正数，因为数组排过序，所以不会出现 a + b + c == 0的情况了
            if (nums[k] > 0) {
                break;
            }
            // 如果nums[k] == nums[k - 1]，说明已经处理过，后续可能出现重复结果，所以nums[k] == nums[k - 1]就跳出循环能保证结果不重复
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // i，j双指针夹逼
            for (int i = k + 1, j = nums.length - 1; i < j;) {
                if (nums[i] + nums[j] > -nums[k]) {
                    while(i < j && nums[j] == nums[--j]);
                } else if (nums[i] + nums[j] < -nums[k]) {
                    while(i < j && nums[i] == nums[++i]);
                } else if (nums[i] + nums[j] == -nums[k]) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[k]);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                    r.add(result);
                }
            }
        }
        return r;
    }
}
