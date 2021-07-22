package org.gogo.week04;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @Author Redick
 * @Date 2020/11/18 11:28 下午
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(test1(5));
    }

    /**
     * 当n较小时候适用于递归算法，斐波那契数列
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int test1(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static int times_2(int n) {
        // 不使用Fibo
        if (n <= 2) {
            return n;
        }
        // f3 是结果
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; ++i) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 当n较大时，递归深度增加，不再适合递归，我们发现是尾递归，可以通过for循环优化
     * 减少空间做法
     * p->q->r
     * 1  2  3
     * p->q->r
     * 2  3  5
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;

        }
        return r;
    }

    /**
     * 当n较大时，递归深度增加，不再适合递归，我们发现是尾递归，可以通过for循环优化
     * 采用滚动数组法
     * p->q->r
     * 1  2  3
     * p->q->r
     * 2  3  5
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int[] db = new int[n + 1];
        db[0] = 1;
        db[1] = 1;

        for (int i = 2; i <= n; i++) {
            db[i] = db[i - 1] + db[i - 2];
        }
        return db[n];
    }
}
