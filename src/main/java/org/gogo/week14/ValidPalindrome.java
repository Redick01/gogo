package org.gogo.week14;

/**
 *
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 *
 * @author Redick
 * @date 2021/10/12 10:57 下午
 */
public class ValidPalindrome {


    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("abca"));
    }

    /**
     * 贪心算法实现
     * 定义双指针分别指向字符串首尾，然后判断双指针范围内的串是不是回文串，不是的话就++--，然后继续判断如果双指针字符相等继续，不等就删除其中一个，再判断，注意此时是两种情况，
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (isPalindrome(s, 0, s.length() - 1)) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j;) {
            char low = s.charAt(i);
            char height = s.charAt(j);
            if (low == height) {
                ++i;
                --j;
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return false;
    }

    private boolean isPalindrome(String s, int low, int height) {
        char[] chars = s.toCharArray();
        for (int i = low, j = height; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
