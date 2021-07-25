package org.gogo.week08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Redick
 * @date 2021/7/25 1:05 下午
 */
public class SubSets {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new SubSets().plan2(nums);
    }

    /**
     * 方法1 分治
     * @param nums
     * @return
     */
    public List<List<Integer>> plan1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        return dfs(nums, 0, result, new ArrayList<>());
    }

    public List<List<Integer>> dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> ans) {
        // 终止条件
        if (nums.length == index) {
            result.add(new ArrayList<>(ans));
            return result;
        }
        // 当前层
        dfs(nums, index + 1, result, ans);
        ans.add(nums[index]);
        dfs(nums, index + 1, result, ans);

        // reverse the current state
        ans.remove(ans.size() - 1);
        return result;
    }

    /**
     * 迭代法
     * @param nums
     * @return
     */
    public List<List<Integer>> plan2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            // 获取到当前幂集的长度
            int size = result.size();
            //遍历并获取到当前幂集里已存在的每一个子集列表：记作temp
            for(int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<>(result.get(j));
                //向temp中加入新元素
                temp.add(num);
                //将新temp加入幂集中
                result.add(temp);
            }
        }
        return result;
    }

}
