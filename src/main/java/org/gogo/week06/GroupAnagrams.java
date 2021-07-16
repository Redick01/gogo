package org.gogo.week06;

import java.util.*;

/**
 * 字母异位组
 * @author liupenghui
 * @date 2021/7/14 11:54 下午
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    /**
     * 排序法
     * @param strs
     * @return
     */
    public static List<List<String>> plan2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);
            List<String> strings = map.getOrDefault(s1, new LinkedList<String>());
            strings.add(s);
            map.put(s1, strings);
        }
        return new LinkedList<>(map.values());
    }

    /**
     * 暴力法
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.put(Arrays.toString(chars), map.getOrDefault(Arrays.toString(chars), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                if (entry.getKey().equals(Arrays.toString(chars))) {
                    list.add(str);
                }
            }
            result.add(list);
        }
        return result;
    }
}
