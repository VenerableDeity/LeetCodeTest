package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Test50Pow {
    /*
    实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。

    示例 1：
        输入：x = 2.00000, n = 10
        输出：1024.00000

    示例 2：
        输入：x = 2.10000, n = 3
        输出：9.26100

    示例 3：
        输入：x = 2.00000, n = -2
        输出：0.25000
        解释：2-2 = 1/22 = 1/4 = 0.25

        提示：
        -100.0 < x < 100.0
        -2^31 <= n <= 2^31-1
        n 是一个整数
        要么 x 不为零，要么 n > 0 。
        -10^4 <= x^n <= 10^4
     */
    @Test
    public void test() {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }

    /**
     * 思路：暴力法，直接计算x的n次方
     * @param x
     * @param n
     * @return
     */
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        double res = x;
//        for (int i = 1; i < Math.abs(n); i++) {
//            res *= x;
//        }
//        return n > 0 ? res : 1 / res;
//    }

    /**
     * 思路：快速幂，递归，将n分解为n/2，然后递归计算。时间复杂度O(logn)
     * 递归逻辑：
     *      首先递归调用 quickMul(x, N / 2) 来获取 x 的 N/2 次幂的结果，存储在变量 y 中，
     *      如果 N 是偶数，则 x 的 N 次幂可以表示为 (x^(n/2))^2 即 y * y
     *      如果 N 是奇数，则 x 的 N 次幂可以表示为 (x^(n/2))^2×x，即 y * y * x。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
