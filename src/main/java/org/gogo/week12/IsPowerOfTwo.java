package org.gogo.week12;

/**
 * @author Redick
 * @date 2021/9/8 11:29 下午
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean baoli(int n) {
        if (n < 0) {
            return false;
        }
        String s = Integer.toBinaryString(Math.abs(n));
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count == 1;
    }
}
