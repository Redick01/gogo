package org.gogo.week11;

/**
 *
 * 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 *
 * 输入：prices = [1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/8/24 10:28 下午
 */
public class MaxProfitIII {

    /**
     *
     * DP方程：i天 k可交易次数 0-没有持有 1-持有股票
     * i天手中不持有股票
     * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
     * i天手中持有股票
     * dp[i][k][1] = max(dp[i - 1][k][0], dp[i - 1][k - 1][0] - prices[i])
     *
     * 将k=2带入
     * dp[i][2][0] = max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i])
     * dp[i][2][1] = max(dp[i - 1][2][0], dp[i - 1][1][0] - prices[i])
     *
     * 此时，已经无法再化简了，k很小，我们直接将k=1的也列出来
     *
     * dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
     * dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 第一天不持有
        int dp10 = 0;
        // 第一天持有
        int dp11 = -prices[0];
        // 第二天不持有
        int dp20 = 0;
        // 第二天持有
        int dp21 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, dp10 - prices[i]);
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, -prices[i]);
        }
        // 最后只有卖出了才能获得最大收益
        return dp20;
    }
}
