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

    char[][] g;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    /**
     * 深度优先遍历
     * 算法的核心逻辑是当找到1（岛屿）的时候就将1改成0并递归的扩散有过有1就继续改成0，直到没有1，这个过程完成后次数+1，代表这就是一个岛屿
     * @param grid
     * @return
     */
    public int plan1(char[][] grid) {
        // 岛屿个数
        int nums = 0;
        g = grid;
        // 遍历二维数组，如果是0就不处理直接continue，否则走到dfs算法中
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == '0') {
                    continue;
                }
                nums += dfs(i, j);
            }
        }
        return nums;
    }

    private int dfs(int i, int j) {
        // 终止条件
        if (g[i][j] == '0') {
            return 0;
        }
        // 将陆地淹没
        g[i][j] = '0';
        for (int k = 0; k < dx.length; ++k) {
            // 计算 g[i][j] 相邻的元素的坐标x y
            int x = i + dx[k];
            int y = j + dy[k];
            if (x > 0 && x < g.length && y > 0 && y < g[i].length) {
                if (g[x][y] == '0') {
                    continue;
                }
                dfs(x, y);
            }
        }
        return 1;
    }
}
