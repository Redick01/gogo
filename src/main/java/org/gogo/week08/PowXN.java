package org.gogo.week08;

/**
 * @author Redick
 * @date 2021/7/25 10:26 上午
 */
public class PowXN {

    public static void main(String[] args) {
        System.out.println(new PowXN().plan2(1, -2147483648));
    }

    public double test1(double x, int n) {
        return n > 0 ? myPow2(x, n) : 1.0 / myPow2(x, -n);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = myPow2(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }


    public double test(double x, int n) {
        return n > 0 ? pow1(x, n) : 1.0 / pow1(x, -n);
    }

    private double pow1(double x, int a) {
        // 终止条件
        if (a == 0) {
            return 1.0;
        }
        double result = pow1(x, a / 2);
        return a % 2 == 0 ? result * result : result * result * x;
    }


    /**
     * 暴力法
     * @param x
     * @param n
     * @return
     */
    public double plan1(double x, int n) {
        if (n < 0) {
            return 1 / plan1(x, -n);
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    /**
     * 分治
     * 2^10 = 2^5 * 2^5
     * 2^11 = 2^5 * 2^5 * 2
     * 子问题：
     * 当n为偶数时 pow(x, n) = pow(x, n / 2) * pow(x, n / 2)
     * 当n为奇数时 pow(x, n) = pow(x, n / 2) * pow(x, n / 2) * x
     * @param x
     * @param n
     * @return
     */
    public double plan2(double x, int n) {
        long a = n;
        return a > 0 ? myPow(x, a) : 1.0 / myPow(x, -a);
    }

    private double myPow(double x, long n) {
        // 终止条件
        if (n == 0) {
            return 1.0;
        }
        double result = myPow(x, n / 2);
        return n % 2 == 0 ? result * result : result * result * x;
    }


    /**
     * 分治
     */
    public double test2(double x, int n) {
        return n > 0 ? myPow(x, n) : 1.0 / myPow1(x, -n);
    }

    private double myPow1(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double result = myPow1(x, n);
        return n % 2 == 0  ? result * result : result * result * x;
    }
}
