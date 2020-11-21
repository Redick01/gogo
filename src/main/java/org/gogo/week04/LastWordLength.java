package org.gogo.week04;

/**
 * @Author Redick
 * @Date 2020/11/17 11:55 下午
 */
public class LastWordLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("hello world1"));
    }

    /**
     * 简单粗暴
     * 1.利用java String的split方法将单词按照空格分割
     * 2.如果分割后的字符串数组长度为0 直接返回0
     * 3.否则返回字符串数组的最后一个元素长度就是最后一个单词长度了
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
