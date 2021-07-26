package org.gogo.week08;

import java.util.*;

/**
 * 电话号码的字母组合
 * @author Redick
 * @date 2021/7/25 8:08 下午
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> list = new LetterCombinations().plan1("2");
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

    private void dsf(String digits, String letter, int level, List<String> res, Map<Character, String> map) {
        if (level == digits.length()) {
            res.add(letter);
            return;
        }
        String temps = map.get(digits.charAt(level));
        for (int i = 0; i < temps.length(); i++) {
            dsf(digits, letter + temps.charAt(i), level + 1, res, map);
        }
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

    /**
     * 广度优先
     * @param digits
     * @return
     */
    public List<String> plan1(String digits) {
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
        Stack<String> stack = new Stack<>();
        char c = digits.charAt(0);
        String letter = map.get(c);
        for (char s : letter.toCharArray()) {
            stack.push(String.valueOf(s));
        }
        char[] t = digits.toCharArray();
        while (!stack.isEmpty()) {
            String e = stack.pop();
            if (digits.length() == 1) {
               result.add(e);
            }
            for (int i = 1; i < t.length; i++) {
                String o = map.get(t[i]);
                for (char se : o.toCharArray()) {
                    result.add(e + String.valueOf(se));
                }
            }
        }
        return result;
    }
}
