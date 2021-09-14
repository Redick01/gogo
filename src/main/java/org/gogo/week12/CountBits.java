package org.gogo.week12;

/**
 * @author Redick
 * @date 2021/9/14 10:20 下午
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int f = i;
            while (f > 0) {
                f &= (f - 1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] baoLi(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if ('1' == c) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 动态规划——最高有效位
     * @param n
     * @return
     */
    public int[] plan1(int n) {
        int[] res = new int[n + 1];
        int heightBits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                heightBits = i;
            }
            res[i] = res[i - heightBits] + 1;
        }
        return res;
    }

    /**
     * 动态规划——最低设置位
     * @param n
     * @return
     */
    public int[] plan2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[(i & (i - 1))] + 1;
        }
        return res;
    }

}
