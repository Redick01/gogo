package org.gogo.week14;

/**
 * @author Redick
 * @date 2021/10/6 2:28 下午
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        if ("".equals(s) || null == s) {
            return "";
        }
        return s.toLowerCase();
    }

    /**
     * 用位运算的技巧：
     *
     * 大写变小写、小写变大写：字符 ^= 32;
     * 大写变小写、小写变小写：字符 |= 32;
     * 大写变大写、小写变大写：字符 &= 33;
     * SCII码表中大写的A是65，小写的a是97，它们的差是32
     * 65 | 32 转为二进制（按8位来算）可以得到 0100 0001 | 0010 0000 = 0110 0001 = 97 = a
     * @param s
     * @return
     */
    public String plan1(String s) {
        if ("".equals(s) || null == s) {
            return "";
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            ch[i] |= 32;
        }
        return String.valueOf(ch);
    }

    /**
     * 通过 ASCII 码表操作字符串即可。
     * a-z：97-122
     * A-Z：65-90
     * 0-9：48-57
     * @param str
     * @return
     */
    public String plan2(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }
        }
        return String.valueOf(ch);
    }
}
