package org.gogo.week04;

/**
 * 58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Redick
 * @Date 2020/11/17 11:55 下午
 */
public class LastWordLength {

    public int test2(String str) {
        int end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >=0 && str.charAt(start) != ' ') {
            start--;
        }
        return end -start;
    }

    public int test1(String str) {
        int end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && str.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(new LastWordLength().test1("a"));
    }

    /**
     * 简单粗暴
     * 1.利用java String的split方法将单词按照空格分割
     * 2.如果分割后的字符串数组长度为0 直接返回0
     * 3.否则返回字符串数组的最后一个元素长度就是最后一个单词长度了
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        String[] strings = s.split(" ");

        return strings.length == 0 ? 0 : strings[strings.length - 1].length();
    }

    /**
     * 官方解法
     * 1、找到整个字符串末尾指针，从后向前遍历，如果最后一位不是空格，那就向前遍历，否则末尾指针不动跳过
     * 2、如果末尾指针小于0，即字符串长度为0时，直接返回0
     * 3、将末尾指针赋值到另一个向前遍历的指针，该指针遍历条件是不等于空格，如果等于空格，就不再遍历
     * 4、这样，最后一个单词长度就等于，末尾指针减去另一个向前遍历的指针，也就是最后一单词的尾指针减去最后一个单词的头指针
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {

        int end = s.length() - 1;
        // 1
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        // 2
        if (end < 0) {
            return 0;
        }
        // 3
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        // 4
        return end - start;
    }
}
