package org.gogo.week14;

import java.util.*;

/**
 * 151. 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *
 * @author Redick
 * @date 2021/10/7 8:50 下午
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWords words = new ReverseWords();
        String s1 = words.plan1(s);
        System.out.println(s1);
    }

    public String plan1(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String plan2(String s) {
        int begin = 0;
        int end = s.length() - 1;
        // 去掉开头，结尾的空白
        while (begin <= end && s.charAt(begin) == ' ') {
            ++begin;
        }
        while (begin <= end && s.charAt(end) == ' ') {
            --end;
        }
        // 队列
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (begin <= end) {
            char c = s.charAt(begin);
            // 去掉开头和结尾的空格，中间的空格压到队列中
            if ((sb.length() != 0) && (c == ' ')) {
                deque.addFirst(sb.toString());
                sb.setLength(0);
            } else if (c != ' ') {
                sb.append(c);
            }
            ++begin;
        }
        deque.addFirst(sb.toString());
        return String.join(" ", deque);
    }
}
