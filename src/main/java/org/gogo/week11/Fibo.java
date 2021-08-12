package org.gogo.week11;

/**
 * 斐波那契数列
 * @author Redick
 * @date 2021/8/12 11:03 下午
 */
public class Fibo {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
