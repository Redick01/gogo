package org.gogo.week08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Redick
 * @date 2021/7/25 8:08 下午
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> list = new LetterCombinations().letterCombinations("");
        System.out.println(list.toString());
    }

    public List<String> letterCombinations(String digits) {
        // 初始化键盘2～9
        Map<Character, String> map = new HashMap<>(9);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) {
            return result;
        }
        search(digits, "", 0, result, map);
        return result;
    }

    /**
     *
     * @param digits 输入的数字
     * @param s 合法生成的字符串
     * @param level 层
     * @param result 结果
     * @param map 键盘字典
     */
    private void search(String digits, String s, int level, List<String> result, Map<Character, String> map) {
        // 终止条件
        if (level == digits.length()) {
            result.add(s);
            return;
        }
        // 处理当前层
        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            // 递归
            search(digits, s + letters.charAt(i), level + 1, result, map);
        }
    }
}
