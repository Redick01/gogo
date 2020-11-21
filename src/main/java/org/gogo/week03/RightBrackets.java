package org.gogo.week03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效括号
 *
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */
public class RightBrackets {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('?', '?');
        LinkedList<Character> linkedList = new LinkedList<Character>();
        linkedList.addLast('?');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                linkedList.addLast(c);
            } else if (map.get(linkedList.removeLast()) != c) {
                return false;
            }
        }

        return linkedList.size() == 1;
    }
}
