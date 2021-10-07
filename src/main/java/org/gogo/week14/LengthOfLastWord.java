package org.gogo.week14;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * @author Redick
 * @date 2021/10/6 2:41 下午
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");

        return strings.length == 0 ? 0 : strings[strings.length - 1].length();
    }

    /**
     * 从后向前遍历
     * @param s
     * @return
     */
    public int plan1(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
