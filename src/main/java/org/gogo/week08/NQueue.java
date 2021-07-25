package org.gogo.week08;

import java.util.*;

/**
 * @author Redick
 * @date 2021/7/25 8:32 下午
 */
public class NQueue {

    public static void main(String[] args) {
        new NQueue().solveNQueens(4);
    }

    /**
     * 回溯
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        // 棋盘初始化
        List<List<String>> result = new ArrayList<>(n);
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 列
        Set<Integer> columns = new HashSet<>();
        // 撇
        Set<Integer> pie = new HashSet<>();
        // 捺
        Set<Integer> na = new HashSet<>();
        dsf(result, n, 0, queens, columns, pie, na);
        return result;
    }

    private void dsf(List<List<String>> result, int n, int row, int[] queens, Set<Integer> columns, Set<Integer> pie, Set<Integer> na) {
        // 终止条件
        if (n == row) {
            // 棋盘的行
            List<String> list = board(queens, n);
            result.add(list);
        } else {
            // 处理当前层
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int na1 = row - i;
                if (na.contains(na1)) {
                    continue;
                }
                int pie1 = row + i;
                if (pie.contains(pie1)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                pie.add(pie1);
                na.add(na1);
                // 处理下一层
                dsf(result, n, row + 1, queens, columns, pie, na);
                // 处理当前层状态
                queens[row] = -1;
                columns.remove(i);
                pie.remove(pie1);
                na.remove(na1);
            }
        }
    }

    public List<String> board(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
