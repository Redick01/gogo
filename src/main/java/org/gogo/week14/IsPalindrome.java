package org.gogo.week14;

/**
 *
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * desc：
 * 本题解法1：保留字符和数字，然后判断是否是回文（反转字符串和原字符串是否相等）
 * 本题解法2：双指针
 * 本题解法3：优化双指针，在原字符串上操作
 *
 * @author Redick
 * @date 2021/10/12 10:23 下午
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "OP";
        System.out.println(new IsPalindrome().isPalindrome("0P"));
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char c : chars) {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 &&c <= 57)) {
                str.append(c);
            }
        }
        String s1 = str.toString().toLowerCase();
        char[] chars1 = s1.toCharArray();
        for (int i = 0, j = chars1.length - 1; i < j; i++, j--) {
            if (chars1[i] != chars1[j]) {
                return false;
            }
        }
        return true;
    }
}
