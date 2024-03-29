package org.gogo.week02;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121
 * 输出: true
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class HuiWen {

    public static void main(String[] args) {
        int x = 1212;
        System.out.println(huiWen1(x));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        String s1 = "";
        for (int i = chars.length - 1; i >=0; --i) {
            s1 = s1 + chars[i];
        }
        if (s1.equals(s)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int dum = x;
        int result = 0;
        // 从低位开始计算，计算出最后结果是否和给定的x相当，如果想等，证明是回文
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == dum;
    }

    public static boolean isHuiWen(int x) {
        if (x < 0) {
            return false;
        }
        // 计算结果
        int result = 0;
        int temp = x;
        while (x != 0) {
            // 计算结果
            result = result * 10 + x % 10;
            // 除法
            x /= 10;
        }
        return result == temp;
    }

    public static boolean huiWen1(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == temp;
    }
}
