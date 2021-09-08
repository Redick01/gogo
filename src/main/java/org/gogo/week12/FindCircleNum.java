package org.gogo.week12;

/**
 * @author Redick
 * @date 2021/8/25 11:46 下午
 */
public class FindCircleNum {

    public static void main(String[] args) {
        int[][] island = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(new FindCircleNum().findCircleNum(island));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionSet set = new UnionSet(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    set.union(i, j);
                }
            }
        }
        return set.count;
    }

    class UnionSet {
        private int count = 0;

        private int[] parent;

        public UnionSet(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
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

    class UnionSet1 {

        private int count = 0;

        private int[] parent;

        public UnionSet1(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
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
}
