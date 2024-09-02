package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test70ClimbingStairs {
    /*
    设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    示例 1：
        输入：n = 2
        输出：2
        解释：有两种方法可以爬到楼顶。
            1. 1 阶 + 1 阶
            2. 2 阶

    示例 2：
        输入：n = 3
        输出：3
        解释：有三种方法可以爬到楼顶。
            1. 1 阶 + 1 阶 + 1 阶
            2. 1 阶 + 2 阶
            3. 2 阶 + 1 阶

    提示：
        1 <= n <= 45
     */
    @Test
    public void test() {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));

    }

    /**
     * 思路：动态规划
     * 我们用 f(x) 表示爬到第 x 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
     * f(x)=f(x−1)+f(x−2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
//        if (n <= 2) return n;
//        int pre1 = 1, pre2 = 2;
//        for (int i = 3; i <= n; i++) {
//            int cur = pre1 + pre2;
//            pre1 = pre2;
//            pre2 = cur;
//        }
//        return pre2;
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
