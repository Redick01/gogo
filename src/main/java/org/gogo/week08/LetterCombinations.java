package org.gogo.week08;

import java.util.*;

/**
 * 电话号码的字母组合
 * @author Redick
 * @date 2021/7/25 8:08 下午
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> list = new LetterCombinations().test2("234");
        System.out.println(list.toString());
    }

    public List<String> test2(String digits) {
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
        dfs1(result, digits, map, "", 0);
        return result;
    }

    private void dfs1(List<String> result, String digits, Map<Character, String> map, String letter, int level) {
        if (level == digits.length()) {
            result.add(letter);
            return;
        }
        String temp = map.get(digits.charAt(level));
        for (int i = 0; i < temp.length(); i++) {
            dfs1(result, digits, map, letter + temp.charAt(i), level + 1);
        }
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
     * 1、遍历输入的数字
     * 2、先将第一个数字对应的字母push到队列中
     * 3、然后继续遍历digits，pop队列中的现有的字母，与新的数字对应的字母组成组合并放到队列中
     * 4、最后队列中的数据就是字母组合，生成结果即可
     * @param digits
     * @return
     */
    public List<String> plan1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
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
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < digits.length(); i++) {
            char number = digits.charAt(i);
            String letter = map.get(number);
            if (stack.isEmpty()) {
                for (int j = 0; j < letter.length(); j++) {
                    stack.push(String.valueOf(letter.charAt(j)));
                }
            } else {
                int len = stack.size();
                for (int o = 0; o < len; o++) {
                    String s = stack.removeLast();
                    for (int k = 0; k < letter.length(); k++) {
                        stack.push(s + letter.charAt(k));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
