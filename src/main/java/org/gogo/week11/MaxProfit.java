package org.gogo.week11;

/**
 * 买卖股票最佳时机
 *
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Redick
 * @date 2021/8/23 11:13 下午
 */
public class MaxProfit {

    /**
     * 动态规划，升维，生成三维数组
     * i 天数大于0小于等于prices.length ，k 可交易次数 ， 0没有持有股票1持有股票
     * dp[i][k][0]
     *
     * a.子问题 可获得的最大收益就是 dp[n - 1][k][0]，一定是卖出才是收益最大，所以是0
     * b.状态定义 1.今天手中持有股票，2.今天手中没有持有股票
     * c.DP方程
     *    今天手中没有持有股票：
     *    dp[i - 1][k][0]昨天没有持有，今天不操作
     *    dp[i - 1][k][1] + prices[i] 昨天持有，今天卖出，今天没有股票了
     *    dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
     *    今天手中持有股票：
     *    dp[i - 1][k][1] 昨天持有，今天不宝座
     *    do[i - 1][k - 1][0] - prices[i]昨天卖出了，没有持有股票，今天买入了
     *    dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
     *
     * 本题是当k等于1，也就是说只能选择一天卖出，将k带入dp方程，进一步优化得如下方程
     *
     * dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i])
     *
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     * dp[i][1] = max(dp[i - 1][1], - prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int out = 0;
        int in = -prices[0];
        for (int i = 1; i < n; i++) {
            out = Math.max(out, in + prices[i]);
            in = Math.max(in, -prices[i]);
        }
        return out;
    }
}
