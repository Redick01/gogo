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
        List<List<Integer>> result = new SubSets().subsets(nums);
    }

    public List<List<Integer>> test1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        return dfs1(result, 0, new ArrayList<>(), nums);
    }

    private List<List<Integer>> dfs1(List<List<Integer>> result, int level, List<Integer> ans, int[] nums) {
        // 终止条件，数组都递归完了
        if (level == nums.length) {
            result.add(new ArrayList<>(ans));
            return result;
        }
        // 当前层处理
        dfs1(result, level + 1, ans, nums);
        ans.add(nums[level]);
        dfs1(result, level + 1, ans, nums);
        // 处理当前层状态
        ans.remove(ans.size() - 1);
        return result;
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
            List<List<Integer>> newSubSets = new ArrayList<>();
            //遍历并获取到当前幂集里已存在的每一个子集列表：记作temp
            for (List<Integer> subSet : result) {
                List<Integer> newSubSet = new ArrayList<>(subSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            result.addAll(newSubSets);
        }
        return result;
    }

    public List<List<Integer>> test2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> subSet : result) {
                List<Integer> newSubSet = new ArrayList<>(subSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            result.addAll(newSubSets);
        }
        return result;
    }

    public List<List<Integer>> test3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for(List<Integer> subSet : res) {
                List<Integer> newSubSet = new ArrayList<>(subSet);
                newSubSet.add(num);
                newSubSets.add(newSubSet);
            }
            res.addAll(newSubSets);
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, tmp, 0);
        return res;
    }

    /**
     * 空集 [] 肯定是一个子集。
     * 以 1 开头的子集：[1], [1, 2], [1, 3], [1, 2, 3]
     * 以 2 开头的子集：[2], [2, 3]
     * 以 3 开头的子集：[3]

     * @param nums
     * @param tmp
     * @param start
     */
    public void backtrack(int[] nums, List<Integer> tmp, int start) {
        // 所有的都要，所以不需要递归终止条件
        res.add(new ArrayList<>(tmp));
        for (int i = start;i < nums.length; i++) {

            tmp.add(nums[i]);

            backtrack(nums, tmp, i + 1);

            tmp.remove(tmp.size() - 1);
        }
    }
}
