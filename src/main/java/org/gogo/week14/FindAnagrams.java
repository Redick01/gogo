package org.gogo.week14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指字母相同，但排列不同的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * @author Redick
 * @date 2021/10/10 6:01 下午
 */
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        new FindAnagrams().findAnagrams(s, p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new  ArrayList<>();
        int n = p.length(), m = s.length();
        if (n > m) {
            return list;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[p.charAt(i) - 'a'];
            ++cnt2[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            list.add(0);
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s.charAt(i) - 'a'];
            --cnt2[s.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                list.add(i - n + 1);
            }
        }
        return list;
    }

    /**
     * 暴力法
     * @param s
     * @param p
     * @return
     */
    public List<Integer> plan1(String s, String p) {
        int size = p.length();
        if (size == 0 || s.length() < size) {
            return new ArrayList<>();
        }
        if (size == s.length()) {
            if (isAnagrams(s, p)) {
                return Collections.singletonList(0);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i += size ) {
            if (i + size > s.length()) {
                break;
            }
            String s1 = s.substring(i, i + size);
            if (isAnagrams(s1, p)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isAnagrams(String s, String t) {
        // 如果长度字符串长度不同，不是字母异位词
        if (s.length() != t.length()) {
            return false;
        }
        // 将两个字符串拆能字母的数组
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        // 将两个数组中字母排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.toString(sChar).equals(Arrays.toString(tChar));
    }
}
