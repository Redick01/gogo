package org.gogo.week11;

import java.util.ArrayList;

/**
 *  买卖股票的最佳时机 IV
 *
 *  给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Redick
 * @date 2021/8/24 11:34 下午
 */
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 当 k > n / 2时认为k正无穷
        if (k > n / 2) {
            return maxProfit2(prices);
        }
        int profit_out = 0;
        int profit_in = -prices[0];

        return 1;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int out = 0;
        int in = -prices[0];
        for (int i = 1; i < n; i++) {
            out = Math.max(out, in + prices[i]);
            in = Math.max(in, out - prices[i]);
        }
        return out;
    }
}
