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

    public int test1(char[][] grid) {
        // 岛屿个数
        int nums = 0;

        // 遍历二位数字，碰到1 就把 nums+1 并且递归往外层处理，处理逻辑就是将1都用水淹没成0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs1(i, j, grid);
                }
            }
        }
        return nums;
    }

    private void dfs1(int i, int j, char[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return;
        }
        // 淹没
        grid[i][j] = '0';
        dfs1(i - 1, j, grid);
        dfs1(i + 1, j, grid);
        dfs1(i, j - 1, grid);
        dfs1(i, j + 1, grid);
    }


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

    public static void main(String[] args) {
        char[][] island = {{'0'}};
        System.out.println(new NumIslands().numIslandsUnionSet(island));
    }

    public int numIslandsUnionSet(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = Math.max(m, n);
        UnionSet set = new UnionSet(size);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        set.union(i * m + j, (i - 1) * m + j);
                    }
                    if (j + 1 < n && grid[j + 1][j] == '1') {
                        set.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        set.union(i * m + j, i * m + j - 1);
                    }
                    if (j + 1 < m && grid[i][j + 1] == '1') {
                        set.union(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return set.count;
    }

    class UnionSet {

        /**
         * 集合个数
         */
        private int count = 0;

        private int[] parent;

        /**
         * 初始化集合，初始化默认n个组
         * @param n
         */
        public UnionSet(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }



    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}
