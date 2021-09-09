package org.gogo.week12;

import java.util.Stack;

/**
 * @author Redick
 * @date 2021/9/8 11:40 下午
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            // 从低到高的枚举n的每一位，并将其添加到result中
            result |= (n & 1) << (31 - i);
            // 每次操作完右移一位
            n >>>= 1;
        }
        return result;
    }
}
