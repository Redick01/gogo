package org.gogo.week03;

import java.util.*;

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

    public static boolean test3(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> dic = new HashMap<>();
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');
        dic.put('?', '?');
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast('?');
        for (char c : s.toCharArray()) {
            if (dic.containsKey(c)) {
                deque.addLast(c);
            } else if (dic.get(deque.removeLast()) != c) {
                return false;
            }
        }
        return deque.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(test3("()"));
    }

    public static boolean test1(String s) {
        // 奇数长度，不可能是有效括号
        if (s.length() % 2 != 0) {
            return false;
        }
        // 用哈希表存储有效括号对
        Map<Character, Character> dic = new HashMap<>();
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');
        dic.put('?', '?');
        // 双端队列用于有效括号的做括号
        Deque<Character> deque = new ArrayDeque<>();
        deque.addFirst('?');
        for (char c : s.toCharArray()) {
            if (dic.containsKey(c)) {
                deque.addLast(c);
            } else if (dic.get(deque.removeLast()) != c) {
                return false;
            }
        }
        return deque.size() == 1;
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
