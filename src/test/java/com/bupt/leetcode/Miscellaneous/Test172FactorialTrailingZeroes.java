package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test172FactorialTrailingZeroes {
    /*
    给定一个整数 n ，返回 n! 结果中尾随零的数量。
    提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1

    示例 1：
        输入：n = 3
        输出：0
        解释：3! = 6 ，不含尾随 0

    示例 2：
        输入：n = 5
        输出：1
        解释：5! = 120 ，有一个尾随 0

    示例 3：
        输入：n = 0
        输出：0

    提示：
        0 <= n <= 10^4

    进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
     */
    @Test
    public void test() {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(0));
        System.out.println(trailingZeroes(7));
        System.out.println(trailingZeroes(13));
    }

    /**
     * 思路：计算阶乘中能被5整除的个数
     * n! 尾零的数量即为 n! 中因子 10 的个数，而 10=2×5，因此转换成求 n! 中质因子 2 的个数和质因子 5 的个数的较小值。
     * 由于质因子 5 的个数不会大于质因子 2 的个数，我们可以仅考虑质因子 5 的个数。
     * 而 n! 中质因子 5 的个数等于 [1,n] 的每个数的质因子 5 的个数之和，我们可以通过遍历 [1,n] 的所有 5 的倍数求出。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }


    public int trailingZeroesUpdate(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
