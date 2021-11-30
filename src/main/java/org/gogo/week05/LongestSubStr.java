package org.gogo.week05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liupenghui
 * @date 2020/12/27 10:06 下午
 */
public class LongestSubStr {

    public static int test3(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int n = s.length();
        int subStrLength = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            subStrLength = Math.max(subStrLength, right - i + 1);
        }
        return subStrLength;
    }

    public static int test2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int n = s.length();
        int subStrLength = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 ) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            subStrLength = Math.max(subStrLength, right - i + 1);
        }
        return subStrLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(test2(s));
    }

    public static int test1(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int right = -1;
        int maxSubStrLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            maxSubStrLen = Math.max(maxSubStrLen, right - i + 1);
        }
        return maxSubStrLen;
    }

    /**
     * 滑动窗口法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        Set<Character> subStr = new HashSet<Character>(s.length());
        char[] chars = s.toCharArray();
        int n = chars.length;
        // 子串的右边界
        int right = -1;
        // 最大子串长度
        int subStrMaxLength = 0;
        // 便遍历字符数组，构建Set
        for (int i = 0; i < n; ++i) {
            // 左指针i每移动一次，窗口中减掉一个字符，左指针每移动一次，代表一个字串已经算完了
            if (i != 0) {
                subStr.remove(chars[i - 1]);
            }
            // 移动右指针，并且判断字串中是否存在重复字符
            while (right + 1 < n && !subStr.contains(chars[right + 1])) {
                subStr.add(chars[right + 1]);
                ++right;
            }
            subStrMaxLength = Math.max(subStrMaxLength, right - i + 1);
        }
        return subStrMaxLength;
    }
}
