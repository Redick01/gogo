package org.gogo.week08;

import java.util.*;

/**
 * @author Redick
 * @date 2021/7/25 8:32 下午
 */
public class NQueue {

    public static void main(String[] args) {
        new NQueue().test2(4);
    }


    public List<List<String>> test1(int n) {
        // 棋盘
        List<List<String>> res = new ArrayList<>();
        // 用来记录当前行皇后的位置，比如[1,3,0,2]就代表第一行1位置，第二行3位置，第三行0位置，第四行2位置是皇后，生成棋盘即可
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        // 列集合
        Set<Integer> columns = new HashSet<>();
        // 撇集合
        Set<Integer> pie = new HashSet<>();
        // 捺集合
        Set<Integer> na = new HashSet<>();
        dsf1(n, res, 0, queues, columns, pie, na);
        return res;
    }

    private void dsf1(int n, List<List<String>> res, int row, int[] queues, Set<Integer> columns, Set<Integer> pie, Set<Integer> na) {
        if (n == row) {
            // 生成棋盘行
            List<String> list = board(queues, n);
            res.add(list);
        } else {
            // 遍历皇后数
            for (int i = 0; i < n; i++) {
                // 当前列存在皇后了
                if (columns.contains(i)) {
                    continue;
                }
                // 撇存在皇后了，撇的位置等于 row + 1
                int pie1 = row + 1;
                if (pie.contains(pie1)) {
                    continue;
                }
                // 捺存在皇后了，捺的位置等于 row - 1
                int na1 = row - 1;
                if (na.contains(na1)) {
                    continue;
                }
                queues[row] = i;
                columns.add(i);
                pie.add(pie1);
                na.add(na1);
                dsf1(n, res, row + 1, queues, columns, pie, na);
                // 清理当前层状态
                queues[row] = -1;
                columns.remove(i);
                pie.remove(pie1);
                na.remove(na1);
            }
        }
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

    /**
     * 回溯，n为皇后数
     * @param n
     * @return
     */
    public List<List<String>> test2(int n) {
        List<List<String>> res = new ArrayList<>();
        // 记录皇后在每一行的位置
        int[] queues = new int[n];
        // 给queues赋默认值
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        dfs2(res, n, 0, queues, columns, pie, na);
        return res;
    }

    private void dfs2(List<List<String>> res, int n, int row, int[] queues, Set<Integer> columns, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            List<String> board = board1(queues, n);
            res.add(board);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int pie1 = row + i;
                if (pie.contains(pie1)) {
                    continue;
                }
                int na1 = row - i;
                if (na.contains(na1)) {
                    continue;
                }
                queues[row] = i;
                columns.add(i);
                pie.add(pie1);
                na.add(na1);
                dfs2(res, n, row + 1, queues, columns, pie, na);
                queues[row] = -1;
                columns.remove(i);
                pie.remove(pie1);
                na.remove(na1);
            }
        }
    }

    private List<String> board1(int[] queues, int n) {
        List<String> rowQ = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[queues[i]] = 'Q';
            rowQ.add(new String(c));
        }
        return rowQ;
    }
}
