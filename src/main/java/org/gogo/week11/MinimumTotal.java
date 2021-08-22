package org.gogo.week11;

import java.util.List;

/**
 * 剑指 Offer II 100. 三角形中最小路径之和
 * @author Redick
 * @date 2021/8/22 10:48 下午
 */
public class MinimumTotal {

    /**
     * DP
     *  a.子问题 problem(i, j) = min(sub(i + 1, j), sub(i + 1, j + 1)) + a[i, j]
     *  b.方程状态 f[i, j]
     *  c.DP方程 f[i, j] = min(f(i + 1, j), f(i + 1, j + 1)) + a[i, j]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                a[j] = Math.min(a[j], a[j + 1]) + triangle.get(i).get(j);
            }
        }
        return a[0];
    }
}
