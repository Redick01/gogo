package org.gogo.week14;

/**
 *
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @author Redick
 * @date 2021/10/6 3:55 下午
 */
public class ReverseString {

    /**
     * 双指针 交换
     * @param s
     */
    public void plan1(char[] s) {
        int end = s.length - 1;
        for (int begin = 0; begin < end; ++begin, --end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
        }
    }
}
