package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test69Sqrt {
    /*
    给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

    示例 1：
        输入：x = 4
        输出：2

    示例 2：
        输入：x = 8
        输出：2
        解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

    提示：
    0 <= x <= 2^31 - 1
     */
    @Test
    public void test() {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    /**
     * 思路：二分查找。在[0, x]中查找一个数mid，使得mid * mid <= x，然后返回mid
     * 当 l <= r 时，mid = l + (r - l) / 2，如果 mid * mid <= x，则更新 ans = mid，l = mid + 1，否则 r = mid - 1
     * 这样会一直循环到 l > r，此时返回 ans，就是符合条件的最大的 mid
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
