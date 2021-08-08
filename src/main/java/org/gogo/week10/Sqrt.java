package org.gogo.week10;

/**
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/8/8 10:53 下午
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().plan2(6));
    }

    /**
     * 二分查找实现
     * @param x
     * @return
     */
    public int plan1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // 上下界
        int left = 1, right = x;
        while (left <= right) {
            // 防止越界
            int mid = left + (right - left) / 2;
            // 防止乘法越界，改用除法
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int plan2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int c = x;
        while (x / c < c) {
            c = (x + c / x) / 2;
        }
        return c;
    }
}
