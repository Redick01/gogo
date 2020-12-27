package org.gogo.week05;

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

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
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
