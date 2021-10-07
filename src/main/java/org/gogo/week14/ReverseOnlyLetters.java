package org.gogo.week14;

/**
 * @author Redick
 * @date 2021/10/7 9:54 下午
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        char c = '1';
        System.out.println((int) c);
        String s = "a-bC-dEf-ghIj";
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int end = c.length - 1;
        int begin = 0;
        while (begin < end) {
            if ((int)c[begin] < 65 || ((int)c[begin] > 90 && (int)c[begin] < 97) || (int)c[begin] > 122) {
                ++begin;
                continue;
            }
            if ((int)c[end] < 65 || ((int)c[end] > 90 && (int)c[end] < 97) || (int)c[end] > 122) {
                --end;
                continue;
            }
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            ++begin;
            --end;
        }
        return new String(c);
    }
}
