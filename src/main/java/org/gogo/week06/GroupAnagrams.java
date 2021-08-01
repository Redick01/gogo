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
        System.out.println(groupAnagrams(strs).toString());
        System.out.println(new GroupAnagrams().test1(strs).toString());
    }

    public List<List<String>> test1(String[] strings) {
        // 排序后字母字符串和排序前字符串列表映射关系
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);
            List<String> stringList = map.getOrDefault(s1, new ArrayList<>());
            stringList.add(s);
            map.put(s1, stringList);
        }
        return new ArrayList<>(map.values());
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
