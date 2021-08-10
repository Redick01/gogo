package org.gogo.week10;

/**
 * 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/8/9 11:51 下午
 */
public class SearchMatrix {

    /**
     * 暴力法，遍历二维数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean plan1(int[][] matrix, int target) {
        for (int[] nums: matrix) {
            for (int num : nums) {
                if (target == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean test1(int[][] nums, int target) {
        int m = nums.length, n = nums[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = nums[mid / n][mid % 2];
            if (temp < target) {
                left = mid + 1;
            } else if (temp > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 一次二分查找
     * 因为该题的特殊性，将二维数组每一行首尾相连是一个单调递增的数组，利用这个特性构建新数组二分
     * @param matrix
     * @param target
     * @return
     */
    public boolean plan2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = matrix[mid / n][mid % n];
            if (temp < target) {
                left = mid + 1;
            } else if (temp > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
