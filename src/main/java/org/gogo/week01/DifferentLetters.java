package org.gogo.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DifferentLetters {

    public static void main(String[] args) {
        System.out.println(plan2("eat", "tea"));
    }


    /**
     * 巧妙的哈希表
     * 1、初始化一个哈希表，key为每个字母，英文有26个字母，初始化长度是26
     * 2、遍历字符串a，将a的字母put到哈希表中，因为此时哈希表中是空的，所以该次遍历负责初始化哈希表数据，key是字母，value就是字母出现次数
     * 3、遍历字符串b，从哈希表中的找到对应字母并-1，如果找的过程中出现字母的出现次数为-1说明不是异位字母
     * 4、最后如果哈希表所有字母的出现次数都变成了0那就是字母异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean plan2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> dic = new HashMap<>(26);
        // 对应字母位置+1
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            dic.put(sChar, dic.getOrDefault(sChar, 0) + 1);
        }
        // 对应字母位置-1
        for (int j = 0; j < t.length(); j++) {
            char tChar = t.charAt(j);
            dic.put(tChar, dic.getOrDefault(tChar, 0) - 1);
            if (dic.get(tChar) < 0) {
                return false;
            }
        }
        return true;
    }


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
        return Arrays.toString(sChar).equals(Arrays.toString(tChar));
    }
}
