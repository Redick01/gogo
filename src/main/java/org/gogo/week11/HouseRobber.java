package org.gogo.week11;

/**
 * 打家劫舍1
 *
 *
 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



 示例 1：

 输入：[1,2,3,1]
 输出：4
 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 偷窃到的最高金额 = 1 + 3 = 4 。
 示例 2：

 输入：[2,7,9,3,1]
 输出：12
 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author Redick
 * @date 2021/8/22 10:08 下午
 */
public class HouseRobber {


    /**
     * 动态规划1，将其转化成二维数组，升维部分记录该房子偷还是不偷
     * DP:
     *   a.子问题：a[0]...a[i] a[i] = a[i - 1] or a[i] 第i家偷还是不偷
     *   b.状态定义：将问题升维，a[i][0 or 1] 0：第i家偷 ，1：第i家不偷
     *   c.DP方程：
     *     第i家偷：a[i][0] = Math(a[i - 1][0], a[i - 1][1])
     *     第i家不偷： a[i][1] = Math(a[i - 1][0]， 0) + a[i][1]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 定义二维数组
        int [][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 优化，不升维
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            // DP方程，i - 1不偷 i - 2偷在加上i家
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
