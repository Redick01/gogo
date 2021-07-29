package org.gogo.week08;

/**
 * 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Redick
 * @date 2021/7/28 11:07 下午
 */
public class NumIslands {


    /**
     * 深度优先遍历
     * 算法的核心逻辑是当找到1（岛屿）的时候就将1改成0并递归的扩散有过有1就继续改成0，直到没有1，这个过程完成后次数+1，代表这就是一个岛屿
     * @param grid
     * @return
     */
    public int plan1(char[][] grid) {
        // 岛屿个数
        int nums = 0;
        // 遍历二维数组，如果是0就不处理直接continue，否则走到dfs算法中
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    nums += 1;
                    dfs(i, j, grid);
                }

            }
        }
        return nums;
    }

    private void dfs(int i, int j, char[][] g) {
        // 终止条件
        int row = g.length;
        int col = g[0].length;
        // 终止条件
        if (i < 0 || j < 0 || i >= row || j >= col || g[i][j] == '0') {
            return;
        }
        // 将陆地淹没
        g[i][j] = '0';
        dfs(i + 1, j, g);
        dfs(i - 1, j, g);
        dfs(i, j + 1, g);
        dfs(i, j - 1, g);
    }

    /**
     * 算法的核心逻辑是当找到1（岛屿）的时候就将1改成0并递归的扩散有过有1就继续改成0，直到没有1，这个过程完成后次数+1，代表这就是一个岛屿
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // 岛屿个数
        int nums = 0;
        if (null == grid || grid.length == 0) {
            return nums;
        }
        int row = grid.length;
        int col = grid[0].length;
        // 遍历二维数组，如果是0就不处理直接continue，否则走到dfs算法中
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    ++nums;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        // 终止条件
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return;
        }

        // 将陆地淹没
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
