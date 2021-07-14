package org.gogo.week01;

import java.util.Arrays;

public class DifferentLetters {




    public static boolean isDifferentLetters(String s, String t) {
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
        // 遍历其中一个数组，如果数组中每个元素都相等，就是字母异位词
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }
}
