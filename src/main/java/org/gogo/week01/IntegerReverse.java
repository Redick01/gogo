package org.gogo.week01;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class IntegerReverse {


    public static int reverse(int val) {
        int result = 0;
        while (val != 0) {
            // 例 val = 789
            // result 每次乘10 加上 val%10，第一次操作的是 789%10 第二次 78%10 第三次 7%10
            result = result * 10 + val % 10;
            // 取整数 第一次 val = 789/10 第二次 val = 78/10 第三次 val=7%10 第三次跳出循环
            val = val / 10;
        }
        return (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ? 0 : (int) result;
    }



    public int rev(int val) {
        int result = 0;
        while (val != 0) {
            result = result * 10 + val % 10;
            val /= 10;
        }
        return (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) ? 0 : result;
    }
}
