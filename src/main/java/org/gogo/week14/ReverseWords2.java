package org.gogo.week14;

import java.util.Arrays;

/**
 *
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @auth or Redick
 * @date 2021/10/7 9:38 下午
 */
public class ReverseWords2 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWords2 words = new ReverseWords2();
        String s1 = words.reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s1 : strings) {
            char[] chars = s1.toCharArray();
            String ss = reverse(chars);
            builder.append(ss).append(" ");
        }
        return new String(builder).trim();
    }

    private String reverse(char[] s) {
        int end = s.length - 1;
        for (int begin = 0; begin < end; ++begin, --end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
        }
        return new String(s);
    }
}
