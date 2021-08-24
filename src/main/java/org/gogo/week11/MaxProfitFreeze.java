package org.gogo.week11;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Redick
 * @date 2021/8/24 11:03 下午
 */
public class MaxProfitFreeze {

    /**
     * DP方程 0-不持有 1-持有
     * 第i天不持有
     * dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
     * 第i天持有，在第i天选择买的时候 状态就应该从i - 2转移
     * dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 2][k - 1][0] - prices[i])
     *               max(dp[i - 1][k][1], dp[i - 2][k][0] - prices[i])
     * 简化：
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
     * dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int dpi0 = 0;
        int dpi1 = -prices[0];
        int dppre = 0;// 代表dp[i - 2][0]
        for (int price : prices) {
            int temp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + price);
            dpi1 = Math.max(dpi1, dppre - price);
            dppre = temp;
        }
        return dpi0;
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int dppre = 0;// 代表dp[i - 2][0]
        for (int i = 1; i < n; i++) {
            int temp = dp[i - 1][0];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dppre - prices[i]);
            dppre = temp;
        }
        return dp[n - 1][0];
    }
}
