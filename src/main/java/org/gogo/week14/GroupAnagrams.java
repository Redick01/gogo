package org.gogo.week14;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * @author Redick
 * @date 2021/10/10 5:37 下午
 */
public class GroupAnagrams {

    /**
     * 哈希表+排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 哈希表，key
        Map<String, List<String>> dic = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = dic.getOrDefault(key, new ArrayList<>());
            list.add(str);
            dic.put(key, list);
        }
        return new ArrayList<>(dic.values());
    }
}
