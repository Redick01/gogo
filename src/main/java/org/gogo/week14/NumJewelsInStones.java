package org.gogo.week14;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 771. 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * @author Redick
 * @date 2021/10/6 2:46 下午
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";
        new NumJewelsInStones().plan1(jewels, stones);
    }

    public int plan1(String jewels, String stones) {
        Set<Character> set = new HashSet<>(jewels.length());
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
