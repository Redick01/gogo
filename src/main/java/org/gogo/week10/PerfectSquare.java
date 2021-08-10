package org.gogo.week10;

/**
 * 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/8/8 11:45 下午
 */
public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(new PerfectSquare().test1(16));
    }

    public boolean test2(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left * left == num;
    }

    /**
     * 二分法
     * @param num
     * @return
     */
    public boolean test1(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left * left == num;
    }

    public boolean plan1(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num==0;
    }

    public boolean plan2(int num) {
        if (0 == num || 1 == num) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left * left == num;
    }
}
