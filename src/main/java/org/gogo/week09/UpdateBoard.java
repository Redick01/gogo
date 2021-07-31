package org.gogo.week09;

/**
 *
 * 扫雷游戏
 * @author Redick
 * @date 2021/7/31 2:23 下午
 */
public class UpdateBoard {

    // 用于计算位置周围的坐标，周围一共八个位置
    int[] px = {1, -1, 0, 0, -1, -1, 1, 1};
    int[] py = {0, 0, 1, -1, 1, -1, 1, -1};

    public char[][] plan1(char[][] board, int[] click) {
        if (null == click) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        // 周围的雷数量
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + px[k];
            int y = j + py[k];
            // 超过棋盘边界，不处理
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count += 1;
            }
        }
        // 将棋盘位置改为相邻的雷数
        if (count > 0) {
            board[i][j] = (char) (count + '0');
        } else {
            // 将不是雷切不挨着雷的位置 改为B
            board[i][j] = 'B';
            // 计算周围八个点，进行递归
            for (int k = 0; k < 8; k++) {
                int x = i + px[k];
                int y = j + py[k];
                // 超过棋盘边界，不处理
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                dfs(board, x, y);
            }
        }
    }
}
