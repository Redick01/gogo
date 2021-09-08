package org.gogo.week12;

/**
 * @author Redick
 * @date 2021/9/8 11:05 下午
 */
public class HammingWeight {

    public static void main(String[] args) {
        int n = 521;
        System.out.println(new HammingWeight().hammingWeight(n));
    }

    /**
     * 位运算
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    /**
     * 每一位都与1做与运算，如果不是0就是1，需要循环32
     * @param n
     * @return
     */
    public int plan2(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 暴力
     * @param n
     * @return
     */
    public int plan1(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if ('1' == c) {
                count++;
            }
        }
        return count;
    }
}
